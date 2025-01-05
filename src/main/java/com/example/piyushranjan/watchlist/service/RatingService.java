package com.example.piyushranjan.watchlist.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class RatingService {

	String apiUrl = "http://www.omdbapi.com/?apikey=8079d55f&t=";
	
	public String getMovieRating(String title) {
		
		try {
			//Try to fetch the rating from omdb api
			RestTemplate template = new RestTemplate();
			//apiUrl + title
			
			ResponseEntity<ObjectNode> response = template.getForEntity(apiUrl + title, ObjectNode.class);
			
			ObjectNode jsonObject = response.getBody();
			
			return jsonObject.path("imdbRating").asText();
			
		} catch(Exception e) {
			//User entered rating will be taken
			System.out.println("Either movie name not available or API is down!!" + e.getMessage());
			
			return null;
		}
		
	}
}
