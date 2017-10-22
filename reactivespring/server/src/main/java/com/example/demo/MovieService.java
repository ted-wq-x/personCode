package com.example.demo;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.Date;

/**
 * @author BlueT
 * 2017/10/22 12:51
 */
@Service
public class MovieService {
    @Resource
    private MovieRepository mv;

    public Flux<Movie> findAll(){
        return mv.findAll();
    }

    public Mono<Movie> findById(String id){
        return mv.findById(id);
    }

    public Flux<MovieEvent> events(String id) {
        return Flux.<MovieEvent>generate(sink -> sink.next(new MovieEvent(id, new Date())))
                .delayElements(Duration.ofSeconds(1L));
    }
}
