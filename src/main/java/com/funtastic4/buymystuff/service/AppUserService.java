package com.funtastic4.buymystuff.service;

import com.funtastic4.buymystuff.model.AppUser;
import com.funtastic4.buymystuff.model.AppUserPrincipal;
import com.funtastic4.buymystuff.repository.AppUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Get user from database
        Optional<AppUser> appUserOptional = appUserRepository.findAppUserByEmail(email);
        if (appUserOptional.isEmpty()) {
            log.error("The user is: " + appUserOptional.get().getEmail());
            throw new UsernameNotFoundException(String.format("User with email not found") + email);
        }
        return new AppUserPrincipal(appUserOptional.get());
    }
}

