package tobyspring.helloboot.util.config.autoconfig;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import tobyspring.helloboot.util.config.MyAutoConfiguration;

@MyAutoConfiguration
public class TomcatWebServerConfig {

    @Bean
    public ServletWebServerFactory servletContainer() {
        return new TomcatServletWebServerFactory();
    }
}
