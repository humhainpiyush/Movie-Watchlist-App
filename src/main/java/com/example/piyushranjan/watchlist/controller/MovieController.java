package com.example.piyushranjan.watchlist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.piyushranjan.watchlist.entity.Movie;
import com.example.piyushranjan.watchlist.service.DatabaseService;

import jakarta.validation.Valid;

@RestController
public class MovieController {
	
	@Autowired
	DatabaseService databaseService;
	
	@GetMapping("/watchlistItemForm")
	public ModelAndView showWatchlistForm(@RequestParam(required=false) Integer id) {
		String viewName = "watchlistItemForm";
		Map<String, Object> model = new HashMap<>();
		
		if(id == null) {
			model.put("watchlistItem", new Movie());
		} else {
			model.put("watchlistItem", databaseService.getMovieById(id));
		}
//		Movie dummyMovie = new Movie();
//		dummyMovie.setTitle("dummy");
//		dummyMovie.setRating(0);
//		dummyMovie.setPriority("Low");
//		dummyMovie.setComment("John doe");
//		
//		model.put("watchlistItem", dummyMovie);
		
		
		return new ModelAndView(viewName, model);
	}
	
	@PostMapping("/watchlistItemForm")
	public ModelAndView submitWatchlistForm(@Valid @ModelAttribute("watchlistItem") Movie movie, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			// if error/s exist/s, redisplay the form and let user enter again
			return new ModelAndView("watchlistItemForm");
		}
		Integer id = movie.getId();
		
		if(id == null) {
			
			databaseService.create(movie);
		} else {
			databaseService.update(movie, id);
		}
		
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/watchlist");
		
		return new ModelAndView(redirectView);
	}
	
	@GetMapping("/watchlist")
	public ModelAndView getWatchlist() {
		
		String viewName = "watchlist";
		Map<String, Object> model = new HashMap<>();
		List<Movie> moviesList = databaseService.getAllMovies();
		
		model.put("watchlistrows", moviesList);
		model.put("noofmovies", moviesList.size());
		
		return new ModelAndView(viewName, model);
	}
}
