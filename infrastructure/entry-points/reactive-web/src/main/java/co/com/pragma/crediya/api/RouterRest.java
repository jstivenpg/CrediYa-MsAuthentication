package co.com.pragma.crediya.api;

import co.com.pragma.crediya.api.docs.UserControllerDocs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterRest implements UserControllerDocs {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(UserHandler userHandler) {
        return RouterFunctions.route()
                 .POST("/api/v1/users",
                        RequestPredicates.contentType(MediaType.APPLICATION_JSON),
                        userHandler::listenSaveUser).build();
    }
}
