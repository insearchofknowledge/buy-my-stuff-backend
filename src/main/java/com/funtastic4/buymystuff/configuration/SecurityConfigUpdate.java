package com.funtastic4.buymystuff.configuration;

import com.funtastic4.buymystuff.model.AppUserPrincipal;
import com.funtastic4.buymystuff.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfigUpdate  extends GlobalMethodSecurityConfiguration {
    @Autowired
    AppUserService appUserService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeRequests()
//                .antMatchers("/api/products/add").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.PUT,"/api/products").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.DELETE,"/api/products").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.PUT,"/api/categories").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.PUT,"/api/producers").hasAuthority("ADMIN")
                .anyRequest().permitAll();
        httpSecurity.formLogin();
        httpSecurity.httpBasic();
        httpSecurity.csrf().ignoringAntMatchers("/api/**");
        httpSecurity.cors().disable();
        httpSecurity.logout();
        httpSecurity.headers().frameOptions().disable(); // Useful for H2 console


        return httpSecurity.build();


    }

    //    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails admin = User.withUsername
//                ("admin")
//                .password(passwordEncoder.encode("Secret_123"))
////                .roles("ADMIN")
//                .authorities("ROLE_ADMIN","CREATOR")
//                .build();
//        UserDetails user = User
//                .withUsername("user")
//                .password(passwordEncoder.encode("Secret_123"))
//                .authorities("ROLE_USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin,user);
//    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(appUserService);
        return provider;
    }
}
