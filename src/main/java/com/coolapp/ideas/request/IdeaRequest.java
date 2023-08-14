package com.coolapp.ideas.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author psingh
 */
@Getter
@Setter
@ToString
public class IdeaRequest {
	private MediaSource mediaSource;
	private String collectionId;
}
