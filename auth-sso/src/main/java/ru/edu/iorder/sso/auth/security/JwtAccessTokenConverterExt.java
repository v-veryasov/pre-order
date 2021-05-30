package ru.edu.iorder.sso.auth.security;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.Map;

public class JwtAccessTokenConverterExt extends JwtAccessTokenConverter {

    private static final String ID = "id";
    private static final String USER_NAME = "user_name";

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        addAdditionalInfo((DefaultOAuth2AccessToken) accessToken, (UserDetail) authentication.getPrincipal());
        return super.enhance(accessToken, authentication);
    }

    private void addAdditionalInfo(DefaultOAuth2AccessToken accessToken, UserDetail principal) {
        Map<String, Object> mapInfo = new HashMap<>();
        mapInfo.put(ID, principal.getId());
        mapInfo.put(USER_NAME, principal.getUsername());
        accessToken.setAdditionalInformation(mapInfo);

    }
} 