package tobyspring.helloboot.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tobyspring.helloboot.service.usecase.SimpleHelloUseCase;

import java.util.Objects;

@RestController
public class HelloController implements ApplicationContextAware {

    private final SimpleHelloUseCase simpleHelloUseCase;
    private ApplicationContext applicationContext;

    public HelloController(SimpleHelloUseCase simpleHelloUseCase) {
        this.simpleHelloUseCase = simpleHelloUseCase;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        return simpleHelloUseCase.sayHello(Objects.requireNonNull(name));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}