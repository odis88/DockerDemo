package com.ssn.prototype.servicelink.repo;

import com.ssn.prototype.servicelink.entity.Link;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinkRepo extends MongoRepository<Link, String> {

    Link findByLongLink(String longLink);
    Link findByShortLink(String shortLink);
}
