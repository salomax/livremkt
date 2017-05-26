package com.marketplace.security;

import com.google.appengine.repackaged.com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.appengine.repackaged.com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.appengine.repackaged.com.google.api.client.http.javanet.NetHttpTransport;
import com.google.appengine.repackaged.com.google.api.client.json.jackson.JacksonFactory;
import com.marketplace.SecurityConfig;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

/**
 * @author salomao.marcos@gmail.com
 * @since 26/05/17
 */
public class GoogleTokenServices extends RemoteTokenServices {

    private static final Logger log = Logger.getLogger(SecurityConfig.class.getName());

    private RestOperations restTemplate;

    private String clientId;

    private String clientSecret;

    public GoogleTokenServices() {
        this.restTemplate = new RestTemplate();
        ((RestTemplate) restTemplate).setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            // Ignore 400
            public void handleError(ClientHttpResponse response) throws IOException {
                if (response.getRawStatusCode() != 400) {
                    super.handleError(response);
                }
            }
        });
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Override
    public OAuth2Authentication loadAuthentication(String accessToken) throws AuthenticationException, InvalidTokenException {

        GooglePrincipal googlePrincipal = getPrincipal(accessToken);

        OAuth2Authentication authentication = new OAuth2Authentication(
                getOAuth2Request(),
                getUserAuthentication(googlePrincipal));

        return authentication;
    }

    private UsernamePasswordAuthenticationToken getUserAuthentication(GooglePrincipal googlePrincipal) {
        return new UsernamePasswordAuthenticationToken(googlePrincipal, googlePrincipal.getEmail(), Collections.<GrantedAuthority>emptySet());
    }

    private OAuth2Request getOAuth2Request() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put(AccessTokenConverter.CLIENT_ID, this.clientId);
        return new OAuth2Request(parameters, this.clientId, null, true, Collections.<String>emptySet(), Collections.<String>emptySet(), null, null, null);
    }

    private GooglePrincipal getPrincipal(String accessToken) {

        NetHttpTransport transport = new NetHttpTransport.Builder().build();

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, new JacksonFactory())
                .setAudience(Collections.singletonList(this.clientId))
                .build();

        GoogleIdToken idToken;
        GooglePrincipal.Builder user;

        try {

            idToken = verifier.verify(accessToken);

            if (idToken != null) {

                GoogleIdToken.Payload payload = idToken.getPayload();
                user = new GooglePrincipal.Builder();

                user.userId(payload.getSubject())
                    .email(payload.getEmail())
                    .emailVerified(Boolean.valueOf(payload.getEmailVerified()))
                    .name((String) payload.get("name"))
                    .pictureUrl((String) payload.get("picture"))
                    .locale((String) payload.get("locale"))
                    .familyName((String) payload.get("family_name"))
                    .givenName((String) payload.get("given_name"));

            } else {
                throw new InvalidTokenException("Token not valid");
            }

        } catch (Exception e) {
            log.warning(e.getMessage());
            throw new InvalidTokenException("Token not able to be validated", e);
        }

        return user.build();
    }

}