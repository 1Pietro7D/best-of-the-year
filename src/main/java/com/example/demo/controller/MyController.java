package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Movie;
import com.example.demo.Song;

@Controller
@RequestMapping ("/") // localhost:8080/home grestisce le CRUD -- a differenza di GetMapping, RequestMapping richiede "/"
public class MyController {
	String name = "Pietro";
	/*
	@GetMapping()
	@ResponseBody // bad practice
	public String index() {
		return "<a href=\"http://localhost:8080/home/movies\"> Movies <a/>"
				+ "<span>-    -<span>"
				+ "<a href=\"http://localhost:8080/home/songs\"> Songs <a/>";
	} 	
	*/
	@GetMapping // su questa rotta localhost:8080/home/index che va specificato INVECE su http://localhost:8080/ compare come statico
	public String view(Model modelIndex) {
		modelIndex.addAttribute("name", name);
		return "index"; //questo pesca index.html su template
	}
	
	@GetMapping("/movies")
	public String showMovies(Model modMovies) {
		List<Movie> movies = getBestMovies();
		modMovies.addAttribute("movies", movies);
		return "movies";
	}
	@GetMapping("/movie/{id}")
	public String showMovieDetails(Model modMovie, @PathVariable("id") int id) { // provato a mettere id come stringa.. disastro per provare un parseInt
		List<Movie> movies = getBestMovies();
		 Movie movie = movies.stream().filter(m -> m.getId() == id).findFirst().orElse(null); // GUARDA, FILTRA, IL 1° CHE TROVA altrimenti NULL
		    modMovie.addAttribute("movie", movie);
		    return "movie";
	}
	

	@GetMapping("/songs")
	public String showSongs(Model modSongs) {
		List<Song> songs = getBestSongs();
		modSongs.addAttribute("songs", songs);
		return "songs";
	}
	@GetMapping("/song/{id}")
	public String showSongDetails(Model modSong, @PathVariable("id") int id) {
	    List<Song> songs = getBestSongs();
	    Map<Integer, Song> songMap = songs.stream().collect(Collectors.toMap(Song::getId, s -> s)); // MAPPATURA della lista   "s -> s" lambda expression or "Function.identity()"
	    Song song = songMap.get(id);
	    modSong.addAttribute("song", song);
	    return "song";
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
