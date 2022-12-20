package com.javatechie.webflux.router;


import com.javatechie.webflux.handler.CustomerHandler;
import com.javatechie.webflux.handler.CustomerStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private CustomerHandler customerHandler;

    @Autowired
    private CustomerStreamHandler handler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route().GET("/router/customers", customerHandler::loadCustomers)
                .GET("/router/customers/stream", handler::getCustomers)
                .GET("/router/customer/{input}", customerHandler::findCustomer)
                .POST("/router/customer/save", customerHandler::saveCustomer)
                .build();
    }
}
