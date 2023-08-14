package com.coolapp.ideas.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.coolapp.ideas.model.Idea;
import com.coolapp.ideas.model.Media;
import com.coolapp.ideas.model.MediaType;
import com.coolapp.ideas.request.MediaSource;
import com.coolapp.ideas.repositories.IdeaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Service to interact with 'Idea' documents in Mongo
 * @author psingh
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class IdeaService {
	private final IdeaRepository ideaRepository;
	public Idea createIdea(MediaSource mediaSource, String collectionId) {
		final var idea = Idea.builder()
			.id(UUID.randomUUID().toString())
			.media(Media.builder()
				.mediaType(MediaType.fromRequestMediaSourceType(mediaSource.getMediaSourceType()))
				.text(mediaSource.getText())
				.fileUrl("https://file.stored.here") //TODO: add logic of storing file in a S3 bucket and returning its url.
				.imageUrl(mediaSource.getImageUrl())
				.build())
			.collectionId(collectionId)
			.createdDate(LocalDateTime.now())
			.build();
		log.info("Creating new document Idea with media type: {}", idea.getMedia().getMediaType().name());
		return ideaRepository.save(idea);
	}

	public List<Idea> getAllIdeas() {
		log.info("Retrieving all Ideas");
		return ideaRepository.findAll();
	}
}
