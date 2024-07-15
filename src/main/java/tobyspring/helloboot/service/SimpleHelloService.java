package tobyspring.helloboot.service;

import org.springframework.stereotype.Service;
import tobyspring.helloboot.service.usecase.SimpleHelloUseCase;

@Service
public class SimpleHelloService implements SimpleHelloUseCase {

    @Override
    public String sayHello(String name) {

        return "Hello, "+ name;
    }
}
