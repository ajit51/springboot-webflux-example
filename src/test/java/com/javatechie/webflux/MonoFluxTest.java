package com.javatechie.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){
        Mono<?> stringMono = Mono.just("Spring Boot")
                .then(Mono.error(new RuntimeException("Exception occured in Mono")))
                .log();
        stringMono.subscribe(System.out::println, (e) -> System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux(){
        Flux<String> justStringFlux = Flux.just("Spring", "Spring Boot", "Hibernate", "Microservices")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception occured in Flux")))
                //.concatWithValues("Cloud")
                .log();

        justStringFlux.subscribe(System.out::println, (e) -> System.out.println(e.getMessage()));
    }
}
