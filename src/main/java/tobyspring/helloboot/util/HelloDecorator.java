package tobyspring.helloboot.util;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tobyspring.helloboot.service.usecase.SimpleHelloUseCase;

@Service
@Primary
public class HelloDecorator implements SimpleHelloUseCase {

    private final SimpleHelloUseCase simpleHelloUseCase;

    public HelloDecorator(SimpleHelloUseCase simpleHelloUseCase) {
        this.simpleHelloUseCase = simpleHelloUseCase;
    }

    @Override
    public String sayHello(String name) {
        return "*" + simpleHelloUseCase.sayHello(name) + "*";
    }
}
