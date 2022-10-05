package com.funtastic4.buymystuff.controller;

import com.funtastic4.buymystuff.model.AppUser;
import com.funtastic4.buymystuff.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
public class LoginController {
    AppUserRepository appUserRepository;

    PasswordEncoder passwordEncoder;
    @RequestMapping("/api/user")
    public Principal user(Principal user){
        return user;
    }
    @PostMapping("/api/user")
    public AppUser createUser(@RequestBody AppUser appUser){
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserRepository.save(appUser);
        return appUser;
    }
}
