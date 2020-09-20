package HomeRent.config.auth;

import HomeRent.user.CustomUserService;
import lombok.RequiredArgsConstructor;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //private final CustomOAuth2UserService customOAuth2UserService;

    private final CustomUserService customUserService;

    // PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        //return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //return new StringEncryptor().decrypt(String password);
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상 통과하도록 설정 등록 )
        web.ignoring().antMatchers("/dist/**", "/css/**", "/images/**", "/js/**", "/font/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "/users/login", "/h2-console/**").permitAll()
                    .antMatchers("/api/**").hasRole("USER")
                    .antMatchers("/api/**").hasRole("ADMIN")
                    .antMatchers("/api/**").hasRole("ROOT")
                    .antMatchers("/users/list", "/users", "/roles").hasRole("ROOT")
                    .anyRequest().authenticated()
                .and() // 로그인 설정
                    .formLogin()
                    .loginPage("/users/login")
                    .defaultSuccessUrl("/")
                    .usernameParameter("email")
                    .permitAll()
                .and()
                    .logout()
                    .logoutSuccessUrl("/");
//                .and()
//                    .oauth2Login()
//                    .userInfoEndpoint()
//                    .userService(customOAuth2UserService);
    }
// 로그인 인증 처리 부분
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(customUserService);
        auth.userDetailsService(customUserService).passwordEncoder(passwordEncoder());
    }
}
