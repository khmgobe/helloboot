package tobyspring.helloboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tobyspring.helloboot.repository.HelloRepository;
import tobyspring.helloboot.service.usecase.SimpleHelloUseCase;

@Service
public class SimpleHelloService implements SimpleHelloUseCase {

    private final HelloRepository helloRepository;

    @Autowired
    public SimpleHelloService(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @Override
    public String sayHello(String name) {
        helloRepository.increaseCount(name);

        return "Hello, "+ name;
    }

    @Override
    public int countOf(String name) {
        return helloRepository.countOf(name);
    }
}
