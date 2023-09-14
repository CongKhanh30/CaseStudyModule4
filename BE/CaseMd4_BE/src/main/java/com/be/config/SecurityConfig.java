package com.be.config;
import com.be.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    IAccountService accountService;

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Autowired
    FilterAuthToken filterAuthToken;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
    // cấu hình phân quyền
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login", "/api/product**", "/apiAccount/creatAccount**", "/api/**").permitAll()
                .antMatchers("/api/imgProduct").permitAll()
                .antMatchers("/api/product/**").permitAll()
                .antMatchers("/api/categories").permitAll()
                .antMatchers("/api/sortPrice**").permitAll()
                .antMatchers("/api/productByCategory/**").permitAll()
                .antMatchers("/api/products/search/**").permitAll()
                .antMatchers("/api/productsShop/**").permitAll()
                .and().authorizeRequests().antMatchers("/user**").hasRole("USER")
                .and().authorizeRequests().antMatchers("/api/delete/**").hasRole("USER")
                .and().authorizeRequests().antMatchers("/shop/shop/**").hasRole("USER")
                .and().authorizeRequests().antMatchers("/api/saveProduct/**").hasRole("USER")
                .and().authorizeRequests().antMatchers("/admin**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().csrf().disable();
        http.addFilterBefore(filterAuthToken, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling();
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
    }
}
