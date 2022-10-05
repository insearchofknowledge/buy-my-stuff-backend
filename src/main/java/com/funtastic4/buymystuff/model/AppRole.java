package com.funtastic4.buymystuff.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="roles")
@Getter
@Setter
public class AppRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;

    @OneToMany(mappedBy ="role")
    private List<AppUser> appUserList;
}
