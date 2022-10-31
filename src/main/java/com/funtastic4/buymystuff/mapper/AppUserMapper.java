package com.funtastic4.buymystuff.mapper;

import com.funtastic4.buymystuff.Dto.AppUserDto;
import com.funtastic4.buymystuff.model.AppUser;
import org.springframework.stereotype.Service;

@Service
public class AppUserMapper implements Mapper<AppUser, AppUserDto> {

    @Override
    public AppUserDto convertToDto(AppUser entity) {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setId(entity.getId());
        appUserDto.setFirstName(entity.getFirstName());
        appUserDto.setLastName(entity.getLastName());
        appUserDto.setEmail(entity.getEmail());
//        appUserDto.setPassword(entity.getPassword());
        appUserDto.setCity(entity.getCity());
        appUserDto.setAddress(entity.getAddress());
        appUserDto.setAvatar(entity.getAvatar());
        appUserDto.setRole(entity.getRole());

        return appUserDto;
    }

    @Override
    public AppUser convertToEntity(AppUserDto dto) {
        AppUser appUser = new AppUser();
        appUser.setId(dto.getId());
        appUser.setFirstName(dto.getFirstName());
        appUser.setLastName(dto.getLastName());
        appUser.setEmail(dto.getEmail());
        appUser.setPassword(dto.getPassword());
        appUser.setCity(dto.getCity());
        appUser.setAddress(dto.getAddress());
        appUser.setAvatar(dto.getAvatar());

        return appUser;
    }
}
