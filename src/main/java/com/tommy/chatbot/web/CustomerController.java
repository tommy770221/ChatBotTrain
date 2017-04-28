package com.tommy.chatbot.web;
import com.mongodb.BasicDBObject;
import com.tommy.chatbot.service.CustomerMongoService;
import com.tommy.chatbot.domain.Customer;
import com.tommy.chatbot.domain.Statements;
import com.tommy.chatbot.service.StatementsMongoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RequestMapping("/customers")
@Controller
@RooWebScaffold(path = "customers", formBackingObject = Customer.class)
public class CustomerController {

    @Autowired
    private CustomerMongoService repository;

    @Autowired
    private MongoOperations mongoOperation;

    @Autowired
    private StatementsMongoService statementsMongoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(Model uiModel) {

        List users = repository.findAll();
        uiModel.addAttribute("customers",users);
        return "customers/list";

    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String save(Model uiModel) {

        Customer customer=new Customer();
        customer.setFirstName("123aaa");
        customer.setLastName("456bbb");
        repository.save(customer);
        return "redirect:/customers/list";

    }

    @RequestMapping(value = "/test", method = RequestMethod.GET,produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String test(Model uiModel,@RequestParam(value = "ask", required = false) String ask ) throws UnsupportedEncodingException {
        ask=new String(ask.getBytes("iso-8859-1"),"utf-8");
        System.out.println("ask = " +ask);
        Statements statements=new Statements();


        /*BasicDBObject query = new BasicDBObject("statements",new BasicDBObject("in_response_to.text", new BasicDBObject("$regex", "^"+ask+"")));
        System.out.println(query.toString());
        BasicQuery queryTwo = new BasicQuery("{\"in_response_to.text\": {$regex : '.*" + ask + ".*'} }");
        System.out.println(queryTwo.toString());*/
       // List<Statements> statementsList= mongoOperation.find(queryTwo,Statements.class);
        List<Statements> statementsList=statementsMongoService.findStatementsByRegexpResponse(".*"+ask+".*"+"你.*");
        int ran= (int)(Math.random()*42+1);
        int i=ran % statementsList.size();
        System.out.println("answer size = " +statementsList.size());
        System.out.println("answer i = " +i);
        System.out.println(statementsList.get(i).getText());
        return statementsList.get(i).getText();

    }


}

