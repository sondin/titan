package com.ai.titan.config;

//import com.ai.titan.service.PermissionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
public class SecurityConfig  {
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        // return NoOpPasswordEncoder.getInstance();// 密码不加密
//        return new BCryptPasswordEncoder();// 密码加密
//    }
//
//    //注入UserDetailsService
//    @Autowired
//    private PermissionService userDetailsService;
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // 在内存中配置2个用户
//        /*auth.inMemoryAuthentication()
//                .withUser("admin").password("123456").roles("admin")
//                .and()
//                .withUser("user").password("123456").roles("user");// 密码不加密*/
//
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("$2a$10$fB2UU8iJmXsjpdk6T6hGMup8uNcJnOGwo2.QGR.e3qjIsdPYaS4LO").roles("admin")
//                .and()
//                .withUser("user").password("$2a$10$3TQ2HO/Xz1bVHw5nlfYTBON2TDJsQ0FMDwAS81uh7D.i9ax5DR46q").roles("user");// 密码加密
//    }

//    @Bean                                                     //新添加，令牌库
//    public SecurityFilterChain filterChain(HttpSecurity http, PersistentTokenRepository tokenRepository) throws Exception {
//
////        // 其它配置需要添加 ...
////        //remember Me
////        http.rememberMe()
////                // .tokenValiditySeconds(120)     //单位：秒。默认2周
////                // .rememberMeCookieDomain("/")   //设置cookie的域
////                .tokenRepository(tokenRepository)
////                .userDetailsService(userDetailsService);
////
//        return http.build();
//    }

}