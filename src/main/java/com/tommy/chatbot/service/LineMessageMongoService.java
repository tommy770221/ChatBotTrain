package com.tommy.chatbot.service;

import com.tommy.chatbot.domain.LineMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Tommy on 2017/4/23.
 */
public interface LineMessageMongoService extends MongoRepository<LineMessage,String> {
}
