package com.funtastic4.buymystuff.controller;

import com.funtastic4.buymystuff.Dto.AppUserDto;
import com.funtastic4.buymystuff.model.AppUser;
import com.funtastic4.buymystuff.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
public class AppUserController {

    AppUserService appUserService;
    PasswordEncoder passwordEncoder;

    @RequestMapping("/api/user")
    public Principal user(Principal user) {
        return user;
    }

//    @PostMapping("/api/user")
//    public ResponseEntity<?> createUser(@RequestBody AppUser appUser) {
//        appUserService.createAppUser(appUser);
//        return new ResponseEntity<>( "User successfully created.",HttpStatus.CREATED);
//    }

    @PostMapping("/api/user")
    public ResponseEntity<?> createUser(@RequestBody AppUserDto appUserDto){
        appUserService.createAppUser(appUserDto);
        return new ResponseEntity<>("User successfully created.",HttpStatus.CREATED);
    }
}
