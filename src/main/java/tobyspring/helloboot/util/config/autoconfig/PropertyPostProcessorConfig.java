package tobyspring.helloboot.util.config.autoconfig;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import tobyspring.helloboot.util.config.MyAutoConfiguration;
import tobyspring.helloboot.util.config.MyConfigurationProperties;

import java.util.Map;
import java.util.Objects;

import static org.springframework.core.annotation.AnnotationUtils.*;

@MyAutoConfiguration
public class PropertyPostProcessorConfig {

    @Bean
    BeanPostProcessor beanPostProcessor(Environment environment) {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

                MyConfigurationProperties annotation = findAnnotation(bean.getClass(), MyConfigurationProperties.class);

                if(Objects.isNull(annotation)) {
                    return bean;
                }

                Map<String, Object> attrs = getAnnotationAttributes(annotation);
                String  prefix = (String) attrs.get("prefix");

                return Binder.get(environment).bindOrCreate("", bean.getClass());
            }
        };
    }
}

