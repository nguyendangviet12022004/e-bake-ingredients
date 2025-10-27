package com.swd.e_bake_ingredients.config.security;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import com.swd.e_bake_ingredients.entity.auth.Account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OidcAccountUser implements OidcUser {
    private Account account;
    private OidcUserInfo userInfo;
    private OidcIdToken idToken;
    private Map<String, Object> attributes;

    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.account.getRole().toString()));
    }

    @Override
    public String getName() {
        return this.account.getEmail();
    }

    @Override
    public Map<String, Object> getClaims() {
        return attributes;
    }

    @Override
    public OidcIdToken getIdToken() {
        return this.idToken;
    }

    @Override
    public OidcUserInfo getUserInfo() {
        return this.userInfo;
    }

}
