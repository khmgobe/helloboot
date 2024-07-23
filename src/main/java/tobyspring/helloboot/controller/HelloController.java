package tobyspring.helloboot.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tobyspring.helloboot.service.SimpleHelloService;
import tobyspring.helloboot.service.usecase.SimpleHelloUseCase;

@RestController
public class HelloController {

    private final SimpleHelloUseCase simpleHelloUseCase;

    public HelloController(SimpleHelloUseCase simpleHelloUseCase) {
        this.simpleHelloUseCase = simpleHelloUseCase;
    }

    @GetMapping("/hello")
    public String hello(String name) {

        if(name == null || name.trim().length() == 0)  {
            throw new IllegalArgumentException();
        }

        return simpleHelloUseCase.sayHello(name);
    }

    @GetMapping("/count")
    public String count(String name) {
        return name + " : " + simpleHelloUseCase.countOf(name);
    }
}