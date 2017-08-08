package com.tommy.chatbot.web;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.restfb.*;
import com.restfb.types.send.IdMessageRecipient;
import com.restfb.types.send.Message;
import com.restfb.types.send.SendResponse;
import com.restfb.types.webhook.WebhookEntry;
import com.restfb.types.webhook.WebhookObject;
import com.restfb.types.webhook.messaging.MessagingAttachment;
import com.restfb.types.webhook.messaging.MessagingItem;
import com.tommy.chatbot.domain.FBMessage;
import com.tommy.chatbot.domain.Statements;
import com.tommy.chatbot.service.FBMessageMongoService;
import com.tommy.chatbot.service.StatementsMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by Tommy on 2017/4/26.
 */
@RequestMapping("/facebook")
@Controller
public class FacebookWebhookController {


    @Autowired
    private StatementsMongoService statementsMongoService;

    @Autowired
    private FBMessageMongoService fbMessageMongoService;

    @RequestMapping(value = "/webhook",method = {RequestMethod.GET,RequestMethod.POST}, produces = "text/plain")
    @ResponseBody
    public String gallery(HttpServletRequest httpServletRequest,
                                                                 @RequestParam(value = "hub.mode",required = false)String mode,
                                                                 @RequestParam(value = "hub.challenge",required = false)String challenge,
                                                                 @RequestParam(value = "hub.verify_token",required = false)String verifyToken) {

         String pageAccessToken="EAABhI56kvksBAH4h1LLWh95CSR0NrXNy0Lh2453RTPA8NYcF5MHpcOXrWGzqsAjWdaBnreRkMY3dZBU8ZAZCqZCMfiYDBjh67tjVHmIVCjNAKQsIMjpVbSzNyR3aHucK6k179ZA4S5m3CTGx73TxSZBo9UKonYPw959Bz1LZBBBNQZDZD";
        try {
            String request=getRequestBodyAsString(httpServletRequest);
            System.out.println("getRequestBodyAsString(httpServletRequest) : "+request);
            JsonMapper mapper = new DefaultJsonMapper();
            String responseCat = "";
            WebhookObject webhookObject =
                    mapper.toJavaObject(request, WebhookObject.class);
            String askForJeiba=".*";
            for(WebhookEntry webhookEntry: webhookObject.getEntryList()){
                for(MessagingItem messageItem:webhookEntry.getMessaging()){
                    System.out.println("messageItem.getSender() : "+messageItem.getSender().getId());
                    System.out.println("messageItem.getRecipient() : "+messageItem.getRecipient().getId());
                    if(messageItem.getMessage()!=null){
                        System.out.println("messageItem.getText() : "+messageItem.getMessage().getText());
                        String sentence=messageItem.getMessage().getText();
                        System.out.println(sentence);

                            JiebaSegmenter segmenter = new JiebaSegmenter();
                            System.out.println(segmenter.process(sentence, JiebaSegmenter.SegMode.SEARCH).toString());
                            List<SegToken> segTokenList = segmenter.process(sentence, JiebaSegmenter.SegMode.SEARCH);

                            for (SegToken segToken : segTokenList) {
                                System.out.println(segToken.word.toString());
                                askForJeiba=askForJeiba+segToken.word.trim()+".*";

                            }

                            List<Statements> statementsList=statementsMongoService.findStatementsByRegexpResponse(askForJeiba);

                        if(!(statementsList==null)){
                            int ran= (int)(Math.random()*300+1);
                            if(statementsList.size()!=0){
                                int i=ran % statementsList.size();
                                responseCat=statementsList.get(i).getText();
                                System.out.println(responseCat);
                            }
                            System.out.println("result not null!");
                        }else{
                            System.out.println("result is null!");
                        }


                            IdMessageRecipient recipient = new IdMessageRecipient(messageItem.getSender().getId());
                            if ("".equals(responseCat)) {
                                responseCat = sentence;
                            }
                            Message simpleTextMessage = new Message(responseCat);


                            // create a version 2.8 client
                            FacebookClient pageClient = new DefaultFacebookClient(pageAccessToken, Version.VERSION_2_8);
                            SendResponse resp = pageClient.publish("me/messages", SendResponse.class,
                                    Parameter.with("recipient", recipient), // the id or phone recipient
                                    Parameter.with("message", simpleTextMessage));
                            System.out.println(resp.getResult());
                            System.out.println(resp.isSuccessful());

                            FBMessage fbMessage=new FBMessage();
                            fbMessage.setMessagerId(messageItem.getSender().getId());
                            fbMessage.setAskMessage(sentence);
                            fbMessage.setResponseMessage(responseCat);
                            fbMessage.setCreateDate(new Date());
                            fbMessageMongoService.save(fbMessage);

                            if (messageItem.getMessage().getAttachments() != null) {
                                for (MessagingAttachment messagingAttachment : messageItem.getMessage().getAttachments()) {
                                    System.out.println("messageItem.getRecipient() : " + messagingAttachment.getPayload());
                                }

                            }

                    }

                }
                System.out.println(webhookEntry.getClass().getName());
            }


        System.out.println(mode);
        System.out.println(challenge);
        System.out.println(verifyToken);

    } catch (IOException e) {
            e.printStackTrace();
     }catch (Exception e){
            e.printStackTrace();
     }
        return challenge;
    }

    protected String getRequestBodyAsString(HttpServletRequest req) throws IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        return buffer.toString();
    }
}
