package com.coolapp.ideas.model;

import com.coolapp.ideas.request.MediaSourceType;

import lombok.RequiredArgsConstructor;

/**
 * @author psingh
 */
@RequiredArgsConstructor
public enum MediaType {
	IMAGE_URL("image_url"),
	FILE_URL("file_url"), //For media/files that are uploaded
	TEXT("text");

	private final String mediaSourceType;

	public static MediaType fromRequestMediaSourceType(MediaSourceType mediaSourceType) {
		if (mediaSourceType == null) {
			return null;
		}

		return switch (mediaSourceType) {
			case TEXT -> TEXT;
			case IMAGE_URL -> IMAGE_URL;
			case FILE_UPLOAD_ID -> FILE_URL;
		};
	}
}
