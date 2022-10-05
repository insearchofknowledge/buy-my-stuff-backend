package com.funtastic4.buymystuff.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="users")
@Getter
@Setter
@ToString
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String city;
    private String address;
    private String avatar;

    @ManyToOne
    @JoinColumn(name= "roleId")
    private AppRole role;

}
