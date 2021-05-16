package ru.edu.iorder.sso.auth.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.stereotype.Service;
import ru.edu.iorder.sso.auth.dto.MessageResponseDto;
import ru.edu.iorder.sso.auth.dto.UserDto;
import ru.edu.iorder.sso.auth.model.User;
import ru.edu.iorder.sso.auth.security.jwt.JwtUser;
import ru.edu.iorder.sso.auth.security.jwt.JwtUserFactory;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AppUserAuthService {

    private final ClientDetailsService clientDetailsService;
    private final AuthorizationServerTokenServices tokenServices;

    @Value("${security.oauth2.client.clientId}")
    private String clientId;

    public MessageResponseDto getToken(User appUser) {
        OAuth2AccessToken token = tokenServices.createAccessToken(createOAuth(appUser));

        return MessageResponseDto.builder()
                .userName(appUser.getUserName())
                .token(token.getValue())
                .build();
    }

    private OAuth2Authentication createOAuth(User user) {
        // Look up authorities, resourceIds and scopes based on clientId
        ClientDetails client = clientDetailsService.loadClientByClientId(clientId);

        Set<String> resourceIds = client.getResourceIds();
        Set<String> scopes = client.getScope();

        // Default values for other parameters
        Map<String, String> requestParameters = Collections.emptyMap();
        boolean approved = true;
        String redirectUrl = null;
        Set<String> responseTypes = Collections.emptySet();
        Map<String, Serializable> extensionProperties = Collections.emptyMap();

        // Create request
        OAuth2Request oauth2Request = new OAuth2Request(requestParameters, clientId, client.getAuthorities(), approved, scopes,
                resourceIds, redirectUrl, responseTypes, extensionProperties);

        JwtUser details = JwtUserFactory.create(user);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
        return new OAuth2Authentication(oauth2Request, authenticationToken);

    }
}
