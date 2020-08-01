package com.ankur.inventory.configuration;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.UUID;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final AdminServerProperties adminServer;

    private static final String USERNAME="ankur";

    /**
     * This is the encoded password for 'ankur'. See PasswordEncoderTests.java
     */
    private static final String ENCODED_PASSWORD = "$2a$10$Bx9dal1WI.sjlMi4indgwex/YvlUsfYmO0pv0xVa2q4hGJp73FBou";
    private static final String USER_ROLE="USER";
    private static final String ADMIN_ROLE="ADMIN";

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public WebSecurityConfig(AdminServerProperties adminServer) {
        this.adminServer = adminServer;
    }



//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .passwordEncoder(passwordEncoder)
//                .withUser(USERNAME)
//                .password(ENCODED_PASSWORD)
//                .roles(USER_ROLE, ADMIN_ROLE);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler =
                new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(this.adminServer.getContextPath() + "/");

        http
                .authorizeRequests()
                .antMatchers(this.adminServer.getContextPath() + "/assets/**").permitAll()
                .antMatchers(this.adminServer.getContextPath() + "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage(this.adminServer.getContextPath() + "/login")
                .successHandler(successHandler)
                .and()
                .logout()
                .logoutUrl(this.adminServer.getContextPath() + "/logout")
                .and()
                .httpBasic()
                .and()
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .ignoringRequestMatchers(
                        new AntPathRequestMatcher(this.adminServer.getContextPath() +
                                "/instances", HttpMethod.POST.toString()),
                        new AntPathRequestMatcher(this.adminServer.getContextPath() +
                                "/instances/*", HttpMethod.DELETE.toString()),
                        new AntPathRequestMatcher(this.adminServer.getContextPath() + "/actuator/**"))
                .and()
                .rememberMe()
                .key(UUID.randomUUID().toString())
                .tokenValiditySeconds(1209600);
    }
}
