package com.can.springbootmongodb.repository;

import com.can.springbootmongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User,Integer> {
}
