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
        appUserDto.setPhoneNumber(entity.getPhoneNumber());
        appUserDto.setCounty(entity.getCounty());
        appUserDto.setCity(entity.getCity());
        appUserDto.setStreet(entity.getStreet());
        appUserDto.setZipCode(entity.getZipCode());
        appUserDto.setAvatar(entity.getAvatar());
        appUserDto.setRole(entity.getRole());

        return appUserDto;
    }

    @Override
    public AppUser convertToEntity(AppUserDto dto) {
        AppUser appUser = new AppUser();
        appUser.setFirstName(dto.getFirstName());
        appUser.setLastName(dto.getLastName());
        appUser.setEmail(dto.getEmail());
        appUser.setPhoneNumber(dto.getPhoneNumber());
        appUser.setPassword(dto.getPassword());
        appUser.setCounty(dto.getCounty());
        appUser.setCity(dto.getCity());
        appUser.setStreet(dto.getStreet());
        appUser.setZipCode(dto.getZipCode());
        appUser.setAvatar(dto.getAvatar());

        return appUser;
    }
}
