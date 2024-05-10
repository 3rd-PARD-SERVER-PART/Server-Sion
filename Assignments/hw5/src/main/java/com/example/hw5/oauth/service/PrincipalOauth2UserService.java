package com.example.hw5.oauth.service;

import com.example.hw5.user.dto.UserDto;
import com.example.hw5.user.entity.User;
import com.example.hw5.user.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    private final UserRepo userRepo;

    @Autowired
    public PrincipalOauth2UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        log.info("Google에서 받아온 user req : " + oAuth2UserRequest);
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        log.info("Google에서 받아온 정보: " + oAuth2User);
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");

        // 사용자 정보를 UserDto.Create로 변환하여 저장
        UserDto.Create userDto = new UserDto.Create();
        userDto.setName(name);
        userDto.setEmail(email);

        // UserDto.Create를 Entity로 변환하여 저장
        User user = User.toEntity(userDto);
        userRepo.save(user);

        return oAuth2User;
    }
}
