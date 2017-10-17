package com.go2going.reactivedemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Stream;

@SpringBootApplication
public class ReactivedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactivedemoApplication.class, args);
	}
}

@RestController
@Component
class IndexController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/user/{id}")
    public Mono<User> getUserById(@PathVariable Integer id) {
        return Optional.ofNullable(id).flatMap(integer -> userRepository.findById(id))
                .map(Mono::just).get();


    }
}

@Component
interface UserRepository extends CrudRepository<User, Integer> {
     Optional<User> findById( Integer id);

}


@Component
class SimpleCLR implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        Logger logger = Logger.getGlobal();



        Random random = new Random();
        Stream.of("王强", "孙晨晨", "程继辉", "李硕").
                forEach(name -> userRepository.save(new User(name, random.nextInt(100))));
        userRepository.findAll().forEach(System.out::println);
    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
class User {

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;
    @Column
    private Integer age;
}