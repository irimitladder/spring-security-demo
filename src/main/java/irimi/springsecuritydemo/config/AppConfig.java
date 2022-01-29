package irimi.springsecuritydemo.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="irimi.springsecuritydemo")
@PropertySource("classpath:db-connection.properties")
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public DataSource getSecurityDataSource() {
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
        try {
            securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
            securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
            securityDataSource.setUser(environment.getProperty("jdbc.userName"));
            securityDataSource.setPassword(environment.getProperty("jdbc.userPassword"));
            securityDataSource.setInitialPoolSize(getEnvironmentPropertyValueInteger("c3p0.poolSizeInitial"));
            securityDataSource.setMinPoolSize(getEnvironmentPropertyValueInteger("c3p0.poolSizeMin"));
            securityDataSource.setMaxPoolSize(getEnvironmentPropertyValueInteger("c3p0.poolSizeMax"));
            securityDataSource.setMaxIdleTime(getEnvironmentPropertyValueInteger("c3p0.timeIdleMax"));
        } catch (PropertyVetoException exception) {
            throw new RuntimeException(exception);
        }
        return securityDataSource;
    }

    private int getEnvironmentPropertyValueInteger(String environmentPropertyName) {
        String environmentPropertyValue = environment.getProperty(environmentPropertyName);
        int environmentPropertyValueInteger = Integer.parseInt(environmentPropertyValue);
        return environmentPropertyValueInteger;
    }
}
