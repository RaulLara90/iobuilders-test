package com.iobuilder.bank.infrastructure.contoller;

import com.iobuilder.bank.domain.user.model.UserDto;
import com.iobuilder.bank.infrastructure.config.exceptions.ConflictException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserController {

    @ApiOperation(value = "Creation of an user", notes = "", response = UserDto.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UserDto.class),
            @ApiResponse(code = 409, message = "CONFLICT"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")})
    @PostMapping(value = "/users",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) throws ConflictException;
}
