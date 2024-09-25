package com.lms.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(name = "User", description = "Holds user details")
public class UserDTO {

    private Long id;

    @Schema(description = "Email of the customer", example = "hjfh@gmail.com")
    private String username;

    @Schema(description = "Password of the customer", example = "1221kldfklig")
    private String password;

    @Schema(description = "Role of the customer", example = "USER")
    private String role;


    @Schema(description = "Full name of the customer", example = "John Doe")
    private String name;


}
