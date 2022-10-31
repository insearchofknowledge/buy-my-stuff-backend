package com.funtastic4.buymystuff.Dto;

import com.funtastic4.buymystuff.enums.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AppUserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String city;
    private String address;
    private String avatar;
    private Role role;

    private List<OrderDto> orders;
}
