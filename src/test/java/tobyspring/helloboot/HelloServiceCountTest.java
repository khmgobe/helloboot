package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tobyspring.helloboot.repository.HelloRepository;
import tobyspring.helloboot.service.usecase.SimpleHelloUseCase;

import java.util.stream.IntStream;

@HelloBootTest
public class HelloServiceCountTest {

    @Autowired
    SimpleHelloUseCase helloUseCase;

    @Autowired
    HelloRepository helloRepository;


    @Test
    void sayHelloIncreaseCount() {

        IntStream.rangeClosed(1, 10).forEach(count -> {


        helloUseCase.sayHello("Toby");
        Assertions.assertThat(helloRepository.countOf("Toby")).isEqualTo(count);
        });
    }
}
