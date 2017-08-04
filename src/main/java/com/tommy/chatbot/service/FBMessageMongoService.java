package com.tommy.chatbot.service;

import com.tommy.chatbot.domain.FBMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tommy on 2017/5/1.
 */
@Repository
public interface FBMessageMongoService extends MongoRepository<FBMessage,String>{


}
