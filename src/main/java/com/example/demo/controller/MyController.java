package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Movie;
import com.example.demo.Song;

@Controller
@RequestMapping("/home") // localhost:8080/home grestisce le CRUD
public class MyController {
	String name = "Pietro";
	
	@GetMapping()
	@ResponseBody // bad practice
	public String index() {
		return "<a href=\"http://localhost:8080/home/movies\"> Movies <a/>"
				+ "<span>-    -<span>"
				+ "<a href=\"http://localhost:8080/home/songs\"> Songs <a/>";
	} 	
	
	@GetMapping("/index") // su questa rotta localhost:8080/home/index che va specificato INVECE su http://localhost:8080/ compare come statico
	public String view(Model modelIndex) {
		modelIndex.addAttribute("name", name);
		return "index"; //questo pesca index.html su template
	}
	
	@GetMapping("/movies")
	public String showMovies(Model modMovie) {
		List<Movie> movies = getBestMovies();
		modMovie.addAttribute("movies", movies);
		return "movies";
	}

	@GetMapping("/songs")
	public String showSongs(Model modSong) {
		List<Song> songs = getBestSongs();
		modSong.addAttribute("songs", songs);
		return "songs";
	}

	private List<Movie> getBestMovies() {
		List<Movie> movies = new ArrayList<>();

		Movie movie1 = new Movie(1, "Ace ventura");
		movies.add(movie1);
		Movie movie2 = new Movie(2, "Iron man");
		movies.add(movie2);
		Movie movie3 = new Movie(3, "Forrest Gump");
		movies.add(movie3);

		return movies; // return the List
	}

	private List<Song> getBestSongs() {
		List<Song> songs = new ArrayList<>();

		Song song1 = new Song(1, "Stone in focus");
		songs.add(song1);
		Song song2 = new Song(2, "A forest");
		songs.add(song2);
		Song song3 = new Song(3, "Cawfee");
		songs.add(song3);

		return songs; // return the List
	}


}
