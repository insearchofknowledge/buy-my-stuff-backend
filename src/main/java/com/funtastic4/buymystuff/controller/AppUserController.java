package com.funtastic4.buymystuff.controller;

import com.funtastic4.buymystuff.Dto.AppUserDto;
import com.funtastic4.buymystuff.mapper.AppUserMapper;
import com.funtastic4.buymystuff.model.AppUser;
import com.funtastic4.buymystuff.model.AppUserPrincipal;
import com.funtastic4.buymystuff.repository.AppUserRepository;
import com.funtastic4.buymystuff.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class AppUserController {

    AppUserService appUserService;
    PasswordEncoder passwordEncoder;
    private final AppUserRepository appUserRepository;
    private final AppUserMapper appUserMapper;

//    @RequestMapping("")
//    public Principal user(Principal user) {
//        return user;
//    }

    @RequestMapping("")
    public AppUserDto user(Principal user) {
        AppUserDto appUserDto = appUserMapper.convertToDto(appUserRepository.findAppUserByEmail(user.getName()).get()); //.orElseThrow....
        return appUserDto;
    }

//    @PostMapping("/login")
//    public ResponseEntity<AppUserDto> login(@RequestParam ){
//        UsernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.)
//    }

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
