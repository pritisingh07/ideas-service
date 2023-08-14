package com.coolapp.ideas.services;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.coolapp.ideas.model.Idea;
import com.coolapp.ideas.model.Media;
import com.coolapp.ideas.model.MediaType;
import com.coolapp.ideas.request.MediaSourceType;
import com.coolapp.ideas.repositories.IdeaRepository;
import com.coolapp.ideas.request.MediaSource;

/**
 * @author psingh
 */
@ExtendWith(MockitoExtension.class)
public class IdeaServiceTest {
	@Mock
	IdeaRepository ideaRepository;
	@InjectMocks
	IdeaService service;
	@Captor
	ArgumentCaptor<Idea> ideaCaptor;

	private static Stream<Arguments> provideMedia() {
		return Stream.of(
			Arguments.of(
				MediaSource.builder()
					.mediaSourceType(MediaSourceType.TEXT)
					.text("text Idea")
					.build(),
				Media.builder()
					.mediaType(MediaType.TEXT)
					.text("text Idea")
					.fileUrl("https://file.stored.here") //Ideally, this should not be present. This is hardcoded in service right now
					.build()),
			Arguments.of(
				MediaSource.builder()
					.mediaSourceType(MediaSourceType.IMAGE_URL)
					.imageUrl("https://image.stored.here")
					.build(),
				Media.builder()
					.mediaType(MediaType.IMAGE_URL)
					.imageUrl("https://image.stored.here")
					.fileUrl("https://file.stored.here") //Ideally, this should not be present. This is hardcoded in service right now
					.build()),
			Arguments.of(
				MediaSource.builder()
					.mediaSourceType(MediaSourceType.FILE_UPLOAD_ID)
					.fileUploadId("mediaFileUpload123")
					.build(),
				Media.builder()
					.mediaType(MediaType.FILE_URL)
					.fileUrl("https://file.stored.here")
					.build())
		);
	}

	@ParameterizedTest
	@MethodSource("provideMedia")
	public void testCreateIdea(MediaSource mediaSource, Media media) {
		service.createIdea(mediaSource, null);
		Mockito.verify(ideaRepository).save(ideaCaptor.capture());
		final var idea = ideaCaptor.getValue();

		Assertions.assertNotNull(idea.getMedia());
		Assertions.assertEquals(media.getMediaType(), idea.getMedia().getMediaType());
		Assertions.assertEquals(media.getImageUrl(), idea.getMedia().getImageUrl());
		Assertions.assertEquals(media.getText(), idea.getMedia().getText());
		Assertions.assertEquals(media.getFileUrl(), idea.getMedia().getFileUrl());
	}
}
