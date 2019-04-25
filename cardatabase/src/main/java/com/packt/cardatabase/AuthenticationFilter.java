package com.packt.cardatabase;

import com.packt.cardatabase.service.AuthenticationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

// This class will handle authentication in all other endpoints except /login.
public class AuthenticationFilter extends GenericFilterBean {
    // The AuthenticationFilter uses the addAuthentication method from our service
    // class to get a token from the request Authorization header

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication =
                AuthenticationService.getAuthentication((HttpServletRequest)request);

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}
