package com.lms.user.controller;

import com.lms.user.dto.ErrorResponseDTO;
import com.lms.user.dto.LoginDTO;
import com.lms.user.dto.ResponseDTO;
import com.lms.user.dto.UserDTO;
import com.lms.user.service.IUserService;
import com.lms.utils.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Tag(name = "APIs for user Registration",
        description = " ")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final IUserService userService;


    @Operation(summary = "Create new user  REST API", description = "Creates new user details.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "HTTP Status CREATED"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    }
    )
    @PostMapping
    public ResponseEntity<ResponseDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        log.info("Creating user: {}", userDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(Utils.STATUS_201, userService.createUser(userDTO)));
    }


    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO login(@Valid @RequestBody LoginDTO loginRequestDTO){
        return userService.login(loginRequestDTO);
    }


}
