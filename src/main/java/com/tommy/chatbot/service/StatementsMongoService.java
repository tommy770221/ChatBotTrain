package com.tommy.chatbot.service;


import com.tommy.chatbot.domain.Statements;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/**
 * Created by Tommy on 2017/4/22.
 */
public interface StatementsMongoService extends MongoRepository<Statements, String>  {


    public Statements findById(String id);
    public Statements findByText(String text);


    @Query("{ 'in_response_to.text' : { $regex: ?0 } }")
    public List<Statements> findStatementsByRegexpResponse(String regexp);

}
