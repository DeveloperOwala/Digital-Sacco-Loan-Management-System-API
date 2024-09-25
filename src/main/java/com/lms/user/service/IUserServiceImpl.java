package com.lms.user.service;

import com.lms.exception.BadRequestException;
import com.lms.security.model.CustomUserDetails;
import com.lms.security.service.JwtService;
import com.lms.user.dto.CurrentUserDTO;
import com.lms.user.dto.LoginDTO;
import com.lms.user.dto.UserDTO;
import com.lms.user.model.User;
import com.lms.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IUserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDTO login(LoginDTO loginDTO) {

        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        if (!authenticate.isAuthenticated()) {
            throw new BadCredentialsException("Wrong username or password");
        }
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            throw new BadRequestException("User not found");
        }


        CustomUserDetails customerUserDetails = new CustomUserDetails(user);
        String accessToken = jwtService.generateToken(customerUserDetails);
        String refreshToken = jwtService.generateRefreshToken(customerUserDetails);
        return mapUserToUseDTO(user, accessToken, refreshToken);
    }

    @Override
    public String createUser(UserDTO userDTO) {
        boolean userExists = userRepository.findByUsername(userDTO.getUsername()).isPresent();
        if (userExists) {
            throw new BadRequestException("User already exists");
        }

        String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
        User user = User.builder()
                .password(encryptedPassword)
                .username(userDTO.getUsername())
                .name(userDTO.getName()).build();


        userRepository.save(user);

        return "User registered successfully";


    }


    public static CurrentUserDTO mapUserToUseDTO(User user, String accessToken, String refreshToken) {
        CurrentUserDTO currentUserDTO = new CurrentUserDTO();
        currentUserDTO.setId(user.getId());
        currentUserDTO.setUsername(user.getUsername());
        currentUserDTO.setName(user.getName());
        currentUserDTO.setAccessToken(accessToken);
        currentUserDTO.setRefreshToken(refreshToken);
        return currentUserDTO;
    }


}





