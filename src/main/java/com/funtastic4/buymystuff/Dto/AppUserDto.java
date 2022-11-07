package com.funtastic4.buymystuff.Dto;

import com.funtastic4.buymystuff.enums.Role;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppUserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String county;
    private String city;
    private String street;
    private String zipCode;
    private String avatar;
    private Role role;
    private List<OrderDto> orders;
}
