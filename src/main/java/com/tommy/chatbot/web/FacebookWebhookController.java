package com.tommy.chatbot.web;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.tommy.chatbot.domain.Statements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Tommy on 2017/4/26.
 */
@RequestMapping("/facebook")
@Controller
public class FacebookWebhookController {

    @RequestMapping(value = "/webhook",method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String gallery(HttpServletRequest httpServletRequest, @RequestParam(value = "ask",required = false)String ask,
                                                                 @RequestParam(value = "hub.mode",required = false)String mode,
                                                                 @RequestParam(value = "hub.challenge",required = false)String challenge,
                                                                 @RequestParam(value = "hub.verify_token",required = false)String verifyToken) {
        System.out.println(mode);
        System.out.println(challenge);
        System.out.println(verifyToken);
        return challenge;
    }
}
