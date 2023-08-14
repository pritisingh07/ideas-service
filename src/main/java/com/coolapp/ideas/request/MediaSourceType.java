package com.coolapp.ideas.request;

import lombok.RequiredArgsConstructor;

/**
 * @author psingh
 */
@RequiredArgsConstructor
public enum MediaSourceType {
	IMAGE_URL("image_url"),
	FILE_UPLOAD_ID("file_id"),
	TEXT("text");

	private final String mediaSourceType;
}
