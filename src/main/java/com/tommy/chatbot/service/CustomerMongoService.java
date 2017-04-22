package com.tommy.chatbot.service;

import com.tommy.chatbot.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tommy on 2017/4/22.
 */
@Repository
public interface CustomerMongoService extends MongoRepository<Customer, String> {

}
