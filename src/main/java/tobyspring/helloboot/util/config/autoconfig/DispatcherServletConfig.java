package tobyspring.helloboot.util.config.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;
import tobyspring.helloboot.util.config.MyAutoConfiguration;

@MyAutoConfiguration
public class DispatcherServletConfig {

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }
}
