package com.example.demo;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import javax.annotation.Resource;
import java.util.Date;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;


@SpringBootApplication
public class DemoApplication {


    //原有的controller方式
 /*   @RestController
	class MovieRestController {
		@Resource
		private MovieService ms;

		@GetMapping("/movies/{id}")
		public Mono byId(@PathVariable String id) {
			return ms.findById(id);
		}

		@GetMapping("/movies")
		public Flux all() {
			return ms.findAll();
		}

		@GetMapping(value = "/movies/{id}/events",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
		public Flux events(@PathVariable String id) {
			return ms.events(id);
		}
	}*/



    @Configuration
    class WebConfiguration {
        @Resource
        private MovieService ms;

        @Bean
        public RouterFunction<ServerResponse> routes() {
            return RouterFunctions
                    .route(GET("/movies/{id}"), request -> ServerResponse.ok() .body(ms.findById(request.pathVariable("id")), Movie.class).log())
                    .andRoute(GET("/movies"), request -> ServerResponse.ok().body(ms.findAll(), Movie.class))
                    .andRoute(GET("/movies/{id}/events"), request -> ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body( ms.events(request.pathVariable("id")), MovieEvent.class));
        }
    }

    @Configuration
    @EnableWebFluxSecurity
    class SecurityConfiguration{
        @Bean
       public MapReactiveUserDetailsService users(){
         return new MapReactiveUserDetailsService(User.withUsername("wq").password("123456").roles("ADMIN","USER").build(),
                   User.withUsername("scc").password("scc123").roles("USER").build());

       }
    }


    @Bean
    public ApplicationRunner runner(MovieRepository mr) {
        return args -> {
            Flux<Movie> movie = Flux.just("Silence of the Lambdas", "AEon Flux", "Back to the Future")
                    .flatMap(s -> mr.save(new Movie(null, s)));
            mr.deleteAll()
                    .thenMany(movie)
                    .thenMany(mr.findAll())
                    .subscribe(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}


@Document
@Data
@Builder
class Movie {
    @Id
    private String name;
    private String title;
}

@Data
@Builder
class MovieEvent {
    private String movieId;
    private Date date;
}

