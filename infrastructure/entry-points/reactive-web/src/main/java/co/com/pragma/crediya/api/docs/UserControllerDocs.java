package co.com.pragma.crediya.api.docs;

import co.com.pragma.crediya.api.UserHandler;
import co.com.pragma.crediya.api.dto.CreateUserDTO;
import co.com.pragma.crediya.api.dto.ResponseUserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

public interface UserControllerDocs {
    @RouterOperations({
            @RouterOperation(
                    path = "/api/v1/users",
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.POST,
                    beanClass = UserHandler.class,
                    beanMethod = "listenSaveUser",
                    operation = @Operation(
                            operationId = "createUser",
                            summary = "create user",
                            description = "create an new user",
                            requestBody = @RequestBody(required = true, content = @Content(schema = @Schema(implementation = CreateUserDTO.class))),
                            responses = {
                                    @ApiResponse(responseCode = "201", description = "User created",
                                            content = @Content(schema = @Schema(implementation = ResponseUserDTO.class))),
                                    @ApiResponse(responseCode = "400", description = "Invalidate request"),
                                    @ApiResponse(responseCode = "409", description = "User already exists")
                            }
                    )
            )
    })
    public RouterFunction<ServerResponse> routerFunction(UserHandler handler);
}
