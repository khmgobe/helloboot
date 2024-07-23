package tobyspring.helloboot.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tobyspring.helloboot.domain.Hello;
import tobyspring.helloboot.repository.HelloRepository;
import tobyspring.helloboot.service.usecase.SimpleHelloUseCase;
import tobyspring.helloboot.util.HelloDecorator;
import static org.assertj.core.api.Assertions.assertThat;

class SimpleHelloServiceTest {


    @Test
    void 서비스를_테스트한다()  {

        // given
        SimpleHelloService helloService = new SimpleHelloService(helloRepositoryStub);

        // when
        String ret = helloService.sayHello("Test");

        // then
        assertThat(ret).isEqualTo("Hello, Test");
    }


    @Test
    void 데코레이터를_테스트_한다()  {

        // given
        HelloDecorator decorator = new HelloDecorator(helloUseCase);

        // when
        String result = decorator.sayHello("Test");

        // then
        Assertions.assertThat(result).isEqualTo("*Test*");
    }

    private static SimpleHelloUseCase helloUseCase = new SimpleHelloUseCase() {
        @Override
        public String sayHello(String name) {
            return "";
        }

        @Override
        public int countOf(String name) {
            return 0;
        }
    };


    private static HelloRepository helloRepositoryStub = new HelloRepository() {
        @Override
        public Hello findHello(String name) {
            return null;
        }

        @Override
        public void increaseCount(String name) {

        }
    };
}