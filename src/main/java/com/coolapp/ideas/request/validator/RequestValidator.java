package com.coolapp.ideas.request.validator;

import com.coolapp.ideas.exceptions.EmptyFieldException;
import com.coolapp.ideas.exceptions.EmptyRequestException;
import com.coolapp.ideas.exceptions.InvalidRequestException;
import com.coolapp.ideas.request.IdeaRequest;
import com.coolapp.ideas.request.MediaSourceType;

/**
 * @author psingh
 */
public class RequestValidator {
	public static void validate(IdeaRequest ideaRequest) {
		if (ideaRequest == null) {
			throw new EmptyRequestException();
		}

		final var mediaSource = ideaRequest.getMediaSource();
		if (mediaSource == null) {
			throw new EmptyFieldException("mediaSource");
		}

		if (MediaSourceType.TEXT.equals(mediaSource.getMediaSourceType())
			&& mediaSource.getText() == null) {
			throw new EmptyFieldException("text");
		}

		if (MediaSourceType.IMAGE_URL.equals(mediaSource.getMediaSourceType())
			&& mediaSource.getImageUrl() == null) {
			throw new EmptyFieldException("imageUrl");
		}

		if(MediaSourceType.FILE_UPLOAD_ID.equals(mediaSource.getMediaSourceType())
			&& mediaSource.getFileUploadId() == null) {
			throw new EmptyFieldException("fileUploadId");
		}
	}
}
