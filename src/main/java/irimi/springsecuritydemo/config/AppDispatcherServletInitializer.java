package irimi.springsecuritydemo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {

        // There are no any root config classes, only servlet ones
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class<?>[] servletConfigClasses = new Class[] {AppConfig.class};
        return servletConfigClasses;
    }

    @Override
    protected String[] getServletMappings() {
        String[] servletMappings = new String[] {"/"};
        return servletMappings;
    }
}
