package bsm.bto.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity //Spring Security를 활성화
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { //
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/api/**").authenticated() // /api/** 경로로 시작하는 모든 요청에 대해 인증이 필요하도록 설정
                        .anyRequest().permitAll() // 나머지 모든 요청은 인증 없이 접근할 수 있도록 허용
                )
                .oauth2Login(withDefaults()); // OAuth2 로그인을 활성화
        return http.build(); //SecurityFilterChain 객체를 빌드하여 반환합니다.
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}