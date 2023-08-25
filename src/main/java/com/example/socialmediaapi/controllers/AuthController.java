package com.example.socialmediaapi.controllers;


import com.example.socialmediaapi.dto.UserDTO;
import com.example.socialmediaapi.models.User;
import com.example.socialmediaapi.security.JWTUtil;
import com.example.socialmediaapi.util.UserDetailsValidator;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;
    private final UserDetailsValidator userDetailsValidator;
    private final JWTUtil jwtUtil;

    private final ModelMapper modelMapper;

    public AuthController(RegistrationService registrationService, UserDetailsValidator userDetailsValidator, JWTUtil jwtUtil, ModelMapper modelMapper) {
        this.registrationService = registrationService;
        this.userDetailsValidator = userDetailsValidator;
        this.jwtUtil = jwtUtil;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/registration")
    public String registration(@RequestBody @Valid UserDTO userDTO,
                               BindingResult bindingResult) {
        User user = convertToUser(userDTO);
        userValidator.validate(user, bindingResult)
    }

    private User convertToUser(UserDTO userDTO) {
        return this.modelMapper.map(userDTO, User.class);
    }
}
