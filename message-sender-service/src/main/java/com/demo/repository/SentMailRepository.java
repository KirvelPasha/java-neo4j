package com.demo.repository;

import com.demo.model.SentMail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SentMailRepository extends MongoRepository<SentMail, String> {
    Optional<SentMail> findByMail(String mail);
}
