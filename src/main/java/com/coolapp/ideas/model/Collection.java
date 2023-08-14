package com.coolapp.ideas.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Model for MongoRepository. Collection document.
 * @author psingh
 */
@Getter
@Setter
@ToString
@Document(collection = "collections")
public class Collection {
	//TODO: add collection related fields
	@Id private String id;
	@DBRef private List<Idea> ideas;
}
