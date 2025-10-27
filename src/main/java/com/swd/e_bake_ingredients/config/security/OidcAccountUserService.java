package com.swd.e_bake_ingredients.config.security;

import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.swd.e_bake_ingredients.constant.AccountProvider;
import com.swd.e_bake_ingredients.constant.AccountRole;
import com.swd.e_bake_ingredients.entity.auth.Account;
import com.swd.e_bake_ingredients.entity.auth.AccountProfile;
import com.swd.e_bake_ingredients.entity.auth.Customer;
import com.swd.e_bake_ingredients.entity.order.Cart;
import com.swd.e_bake_ingredients.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OidcAccountUserService extends OidcUserService {

    private final AccountRepository accountRepository;

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        var user = super.loadUser(userRequest);
        var attributes = user.getAttributes();
        var userInfo = user.getUserInfo();
        var idToken = user.getIdToken();

        // if account not exist, add to db
        var account = accountRepository.findByEmail(user.getEmail()).orElseGet(() -> {
            String email = user.getEmail();
            String firstName = user.getAttribute("given_name");
            String lastName = user.getAttribute("family_name");
            String phoneNumber = user.getPhoneNumber();

            Customer newAccount = Customer.builder()
                    .email(email)
                    .role(AccountRole.ROLE_CUSTOMER)
                    .provider(AccountProvider.GOOGLE)
                    .cart(new Cart())
                    .isActivate(true)
                    .profile(
                            AccountProfile.builder()
                                    .firstName(firstName)
                                    .lastName(lastName)
                                    .phoneNumber(phoneNumber)
                                    .build())
                    .build();

            return this.accountRepository.save(newAccount);
        });

        return OidcAccountUser.builder()
                .account(account)
                .attributes(attributes)
                .userInfo(userInfo)
                .idToken(idToken)
                .build();
    }
}
