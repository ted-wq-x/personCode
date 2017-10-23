package com.example.demo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author BlueT
 * 2017/10/22 12:48
 */
public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
