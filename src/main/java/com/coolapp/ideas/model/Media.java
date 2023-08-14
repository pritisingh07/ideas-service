package com.coolapp.ideas.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author psingh
 */
@Getter
@Builder
@ToString
public class Media {
	private MediaType mediaType;
	private String imageUrl;
	private String fileUrl;
	private String text;
}
