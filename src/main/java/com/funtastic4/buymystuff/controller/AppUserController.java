package com.funtastic4.buymystuff.controller;

import com.funtastic4.buymystuff.Dto.AppUserDto;
import com.funtastic4.buymystuff.model.AppUser;
import com.funtastic4.buymystuff.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class AppUserController {

    AppUserService appUserService;
    PasswordEncoder passwordEncoder;

    @RequestMapping("")
    public Principal user(Principal user) {
        return user;
    }

//    @PostMapping("/api/user")
//    public ResponseEntity<?> createUser(@RequestBody AppUser appUser) {
//        appUserService.createAppUser(appUser);
//        return new ResponseEntity<>( "User successfully created.",HttpStatus.CREATED);
//    }

    @GetMapping("{userId}")
    public ResponseEntity<AppUserDto> getUserById(@PathVariable("userId") Long id) {
        AppUserDto appUserDto = appUserService.getAppUserById(id);

        return new ResponseEntity<>(appUserDto, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody AppUserDto appUserDto) {
        appUserService.createAppUser(appUserDto);
        return new ResponseEntity<>("User successfully created.", HttpStatus.CREATED);
    }
}
