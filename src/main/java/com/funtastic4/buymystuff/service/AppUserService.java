package com.funtastic4.buymystuff.service;

import com.funtastic4.buymystuff.enums.Role;
import com.funtastic4.buymystuff.model.AppUser;
import com.funtastic4.buymystuff.model.AppUserPrincipal;
import com.funtastic4.buymystuff.repository.AppUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AppUserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final AppUserRepository appUserRepository;

    public AppUserService(PasswordEncoder passwordEncoder, AppUserRepository appUserRepository) {
        this.passwordEncoder = passwordEncoder;
        this.appUserRepository = appUserRepository;
    }

    public void checkIfUserNameExists(String email){
        Optional<AppUser> appUserOptional =appUserRepository.findAppUserByEmail(email);
        if(appUserOptional.isPresent()){
            throw new IllegalStateException(String.format("Product with email: %s already exists.", email));
        }
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Get user from database
        Optional<AppUser> appUserOptional = appUserRepository.findAppUserByEmail(email);
        if (appUserOptional.isEmpty()) {
            log.error("The user is: " + appUserOptional.get().getEmail());
            throw new UsernameNotFoundException(String.format("User with email %s not found") + email);
        }
        return new AppUserPrincipal(appUserOptional.get());
    }

    public String createAppUser(AppUser appUser){
        checkIfUserNameExists(appUser.getEmail());
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setRole(Role.USER);
        appUserRepository.save(appUser);
        return "User created successfully.";
    }
}

