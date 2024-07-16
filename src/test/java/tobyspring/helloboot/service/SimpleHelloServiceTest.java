package tobyspring.helloboot.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tobyspring.helloboot.util.HelloDecorator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.assertj.core.api.Assertions.assertThat;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface UnitTest{

}

class SimpleHelloServiceTest {


    @Test
    void 서비스를_테스트한다()  {

        // given
        SimpleHelloService helloService = new SimpleHelloService();

        // when
        String ret = helloService.sayHello("Test");

        // then
        assertThat(ret).isEqualTo("Hello, Test");
    }


    @Test
    void 데코레이터를_테스트_한다()  {

        // given
        HelloDecorator decorator = new HelloDecorator(name -> name);

        // when
        String result = decorator.sayHello("Test");

        // then
        Assertions.assertThat(result).isEqualTo("*Test*");
    }
}