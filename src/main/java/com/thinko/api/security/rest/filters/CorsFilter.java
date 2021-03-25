package com.thinko.api.security.rest.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(0)
public class CorsFilter extends OncePerRequestFilter {
    private final Logger logger = LoggerFactory.getLogger(CorsFilter.class);

    @Value("${thinko.cors.allowOrigins}")
    private String corsAllowOrigins;

    @Value("${thinko.cors.allowMethods}")
    private String corsAllowMethods;

    @Value("${thinko.cors.allowHeaders}")
    private String corsAllowHeaders;

    @Value("${thinko.cors.exposeHeaders}")
    private String corsExposeHeaders;

    @Value("${thinko.cors.maxAge}")
    private String corsMaxAge;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        httpServletResponse.setHeader("Access-Control-Allow-Origin", corsAllowOrigins);
        httpServletResponse.setHeader("Access-Control-Allow-Methods", corsAllowMethods);
        httpServletResponse.setHeader("Access-Control-Max-Age", corsMaxAge);
        httpServletResponse.setHeader("Access-Control-Allow-Headers", corsAllowHeaders);
        httpServletResponse.setHeader("Access-Control-Expose-Headers", corsExposeHeaders);

        if(httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}
