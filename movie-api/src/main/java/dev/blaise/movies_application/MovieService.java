package dev.blaise.movies_application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private  MovieRepository movieRepository;
    public List<Movies> allMovies(){
        return movieRepository.findAll();

    }
    public Optional<Movies> getMovieByImbd(String id){
        return movieRepository.findByImdbId(id);
    }
}
