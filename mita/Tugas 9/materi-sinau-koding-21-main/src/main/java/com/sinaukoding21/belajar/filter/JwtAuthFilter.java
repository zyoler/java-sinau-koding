package com.sinaukoding21.belajar.filter;

import com.sinaukoding21.belajar.config.JwtTokenUtil;
import com.sinaukoding21.belajar.model.Admin;
import com.sinaukoding21.belajar.repositoy.AdminRepository;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        String username = null;
        String token = null;

        if (header != null && header.startsWith("Bearer ")){
            token = header.replace("Bearer ", "");

            try{
                username = jwtTokenUtil.getUsernameFromToken(token);
            }catch (IllegalArgumentException e){
                logger.error("Erorr mendapatkan username from token");
            }catch (ExpiredJwtException e){
                logger.warn("Token Expired");
            }catch (SignatureException e){
                logger.error("username atau password tidak sesuai");
            }
        } else {
            logger.warn("header null / tidak menemukan Bearer");
        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            Admin admin = adminRepository.findByUsername(username);

            if(jwtTokenUtil.validateToken(token, admin)){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(admin, null, new ArrayList<>());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
