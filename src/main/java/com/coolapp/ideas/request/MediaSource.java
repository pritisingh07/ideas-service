package com.coolapp.ideas.request;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author psingh
 */
@Getter
@Builder
@ToString
public class MediaSource {
	private MediaSourceType mediaSourceType;
	private byte[] imageData;
	private String imageUrl;
	private String text;
	private String fileUploadId;
}
