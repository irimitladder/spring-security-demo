package irimi.springsecuritydemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder usersAuthenticationManagerBuilder) throws Exception {
        /*
        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        usersAuthenticationManagerBuilder.inMemoryAuthentication()
                .withUser(userBuilder.username("John").password("000").roles("EMPLOYEE"))
                .withUser(userBuilder.username("Ashok").password("111").roles("EMPLOYEE", "MANAGER"))
                .withUser(userBuilder.username("Numerius").password("222").roles("EMPLOYEE", "ENGINEER"));
         */
        usersAuthenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity httpConfig) throws Exception {
        httpConfig.authorizeRequests()
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/system/**").hasRole("ENGINEER")
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .and().formLogin().loginPage("/userAuthentication").loginProcessingUrl("/processUserAuthentication").permitAll()
                .and().logout().permitAll()
                .and().exceptionHandling().accessDeniedPage("/accessDenied");
    }
}
