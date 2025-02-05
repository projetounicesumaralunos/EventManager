package br.com.gestao_eventos.layers.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.gestao_eventos.layers.providers.JWTClientProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityClientFilter extends OncePerRequestFilter {

    @Autowired
    private JWTClientProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
                SecurityContextHolder.getContext().setAuthentication(null);
                String header = request.getHeader("Authorization");

                if(request.getRequestURI().startsWith("/client")){

                    if (header != null) {
                        var token = this.jwtProvider.validateToken(header);
    
                        if (token == null) {
                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                            return;
                        }
                        request.setAttribute("client_id", token.getSubject());
                        System.out.println(" ==============TOKEN=============== " );
                        var roles = token.getClaim("roles");
                    }

                }

                filterChain.doFilter(request, response);
                
    }


    
}
