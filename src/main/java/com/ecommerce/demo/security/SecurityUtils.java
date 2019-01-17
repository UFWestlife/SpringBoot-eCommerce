package com.ecommerce.demo.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import com.ecommerce.demo.bean.User;
import com.ecommerce.demo.http.AuthenticationSuccessResponse;
import com.ecommerce.demo.http.Response;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.databind.ObjectMapper;


public class SecurityUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void sendResponse(HttpServletResponse httpServletResponse, int status, String message, Exception exception)
            throws IOException {
        Response response = new Response(exception == null ? true : false, status, message);
        flushResponse(httpServletResponse, response);
    }

    public static void sendAuthenticationSuccessResponse(HttpServletResponse httpServletResponse, int status, String message, Exception exception, User user)
            throws IOException {
        Response response = new AuthenticationSuccessResponse(exception == null ? true : false, status, message, user);
        System.out.println(response);
        flushResponse(httpServletResponse, response);
    }

    public static void flushResponse(HttpServletResponse httpServletResponse, Response response) throws IOException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setStatus(response.getCode());
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(mapper.writeValueAsString(response));
        writer.flush();
        writer.close();
    }

    public static boolean isAdmin(Collection<? extends GrantedAuthority> profiles) {
        boolean isAdmin = false;
        for(GrantedAuthority profle: profiles) {
            if(profle.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
            }
        };
        return isAdmin;
    }

}
