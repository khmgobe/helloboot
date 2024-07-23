package tobyspring.helloboot.service.usecase;

import org.springframework.stereotype.Component;

@Component
public interface SimpleHelloUseCase {

    String sayHello(String name);

    int countOf(String name);
}
