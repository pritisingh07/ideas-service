package com.coolapp.ideas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coolapp.ideas.model.Idea;
import com.coolapp.ideas.request.IdeaRequest;
import com.coolapp.ideas.request.validator.RequestValidator;
import com.coolapp.ideas.services.IdeaService;

/**
 * Controller for coolapp Ideas and Collections creation and management.
 * @author psingh
 */
@RestController
@RequestMapping("/coolapp")
public class CoolAppController {
	@Autowired
	private IdeaService ideaService;

	@GetMapping("/ideas")
	public ResponseEntity<List<Idea>> getAllIdeas() {
		return new ResponseEntity<>(ideaService.getAllIdeas(), HttpStatus.OK);
	}

	@PostMapping("/ideas")
	public ResponseEntity<Idea> createIdea(@RequestBody IdeaRequest ideaRequest) {
		RequestValidator.validate(ideaRequest);
		return new ResponseEntity<>(ideaService.createIdea(ideaRequest.getMediaSource(), ideaRequest.getCollectionId()), HttpStatus.CREATED);
	}
}
