package com.coolapp.ideas.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Model for MongoRespository. Idea document.
 * @author psingh
 */
@Getter
@Builder
@ToString
@Document(collection= "ideas" )
public class Idea {
	@Id private String id;
	private Media media;
	@Indexed(background = true)
	private LocalDateTime createdDate;
	@Builder.Default
	private String collectionId = "root"; //default collection
}
