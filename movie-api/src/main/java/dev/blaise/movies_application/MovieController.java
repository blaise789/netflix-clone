package dev.blaise.movies_application;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private  MovieService movieService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Movies> getAllMovies(){
        return movieService.allMovies();
    }
    @GetMapping("/{imdbId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Movies> getSingleMovie(@PathVariable String imdbId){
        return  movieService.getMovieByImbd(imdbId
        );
    }

}
