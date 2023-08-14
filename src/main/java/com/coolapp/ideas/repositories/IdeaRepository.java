package com.coolapp.ideas.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.coolapp.ideas.model.Idea;

/**
 * @author psingh
 */
@Repository
public interface IdeaRepository extends MongoRepository<Idea, String> {

}
