package com.example.auto24backend.security;

import com.example.auto24backend.database.Account;
import com.example.auto24backend.repository.AccountRepository;
import com.example.auto24backend.service.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    AuthenticationFilter(final RequestMatcher requiresAuth) {
        super(requiresAuth);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws AuthenticationException, IOException, ServletException {

        String token= StringUtils.isNotEmpty(httpServletRequest.getHeader(AUTHORIZATION))? httpServletRequest.getHeader(AUTHORIZATION) : "";
        token = StringUtils.removeStart(token, "Bearer").trim();
        String findByToken = token;
        Optional<Account> account = accountRepository.findByToken(findByToken);
        accountService.accountFinder(account);
        Authentication requestAuthentication = new UsernamePasswordAuthenticationToken(token, token);
        return getAuthenticationManager().authenticate(requestAuthentication);

    }

    @Override
    protected void successfulAuthentication(final HttpServletRequest request, final HttpServletResponse response,
                                            final FilterChain chain, final Authentication authResult) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);
        chain.doFilter(request, response);
    }
}
