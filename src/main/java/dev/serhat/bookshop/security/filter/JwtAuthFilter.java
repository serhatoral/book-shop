package dev.serhat.bookshop.security.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import dev.serhat.bookshop.exception.CustomErrorResponse;
import dev.serhat.bookshop.security.JwtValidator;
import dev.serhat.bookshop.service.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;


@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtValidator jwtValidator;
    private final UserDetailsService userDetailsService;

    public JwtAuthFilter(JwtValidator jwtValidator, UserDetailsServiceImpl userDetailsService) {
        this.jwtValidator = jwtValidator;

        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        String token =  null;
        String userName = null;

        if(authHeader != null && authHeader.startsWith("Bearer ")){
            token = authHeader.substring(7);

            if(jwtValidator.isTokenExpired(token)){
                response.setStatus(401);
                response.setContentType("application/json");

                CustomErrorResponse errorResponse = new CustomErrorResponse();
                errorResponse.setError("Jwt is Expired");
                errorResponse.setStatus(401);
                errorResponse.setTimestamp(LocalDateTime.now());


                //response.getWriter().write(new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(errorResponse));
                response.getWriter().write(new ObjectMapper().findAndRegisterModules().writeValueAsString(errorResponse));
                return;
            }else
                userName = jwtValidator.extractUser(token);
        }


        if(userName != null && SecurityContextHolder.getContext().getAuthentication() ==null){

            UserDetails user = userDetailsService.loadUserByUsername(userName);

            if(jwtValidator.validateToken(token,user)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }

        }
        filterChain.doFilter(request,response);
    }
}
