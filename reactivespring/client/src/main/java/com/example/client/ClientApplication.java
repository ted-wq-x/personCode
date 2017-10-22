package com.example.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;
import lombok.extern.java.Log;

@Log
@SpringBootApplication
public class ClientApplication {
	@Bean
	WebClient webClient(){
		return WebClient
				.create("http://localhost:8080/movies")
				.mutate()
				.filter(ExchangeFilterFunctions.basicAuthentication("wq", "123456"))
				.build();
	}

	@Bean
	CommandLineRunner demo(WebClient client) {
		return strings ->
				client
						.get()
						.uri("")
						.retrieve()
						.bodyToFlux(Movie.class)
						.filter(movie -> movie.getTitle().equalsIgnoreCase("AEon Flux"))
						.flatMap(movie ->
								client.get()
										.uri("/{id}/events", movie.getName())
										.retrieve()
										.bodyToFlux(MovieEvent.class))
						.subscribe(movieEvent -> log.info(movieEvent.toString()));
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
}

@Data
@AllArgsConstructor
class MovieEvent {
	private String movieId;
	private Date date;
}

@Data
@AllArgsConstructor
class Movie {
	private String name;
	private String title;
}