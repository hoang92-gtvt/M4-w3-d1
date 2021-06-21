package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected java.lang.Class<?>[] getRootConfigClasses() {
        return new java.lang.Class[]{AppConfiguration.class};
    }

    @Override
    protected java.lang.Class<?>[] getServletConfigClasses() {
        return new java.lang.Class[0];
    }

    @Override
    protected java.lang.String[] getServletMappings() {
        return new java.lang.String[]{"/"};
    }
}
