package kr.co.ckdgns.tmdb.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.ckdgns.tmdb.service.MovieService;
import kr.co.ckdgns.tmdb.service.TmdbService;

@Controller
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
    private TmdbService tmdbService;

    @GetMapping("/{movieId}")
    public String getMovieDetails(@PathVariable int movieId, Model model) throws IOException {
        String movieDetails = tmdbService.getMovieDetails(movieId);
        model.addAttribute("movieDetails", movieDetails);
        return "movie/movieDetails";
    }
    
    @Autowired
    private MovieService movieService;

    @GetMapping
    public String getMovies(Model model) {
        // Service를 통해 인기 영화 목록을 가져옴
        Map<String, Object> movies = movieService.getPopularMovies();

        // 모델에 영화 데이터를 추가하여 View로 전달
        model.addAttribute("movies", movies.get("results"));

        // movies.jsp로 이동
        return "movie/movies";
    }
	
}
