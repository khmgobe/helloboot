package tobyspring.helloboot.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

class HelloControllerTest {


    @Test
    void api_테스트를_한다()  {

        // given
        TestRestTemplate rest = new TestRestTemplate();

        // when
        ResponseEntity<String> res = rest.getForEntity("http://localhost:8080/hello?name={name}", String.class, "Spring");

        // then
        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);

        Assertions.assertThat(res.getBody()).isEqualTo("Hello, Spring");
    }

    @Test
    void api_실패의_경우를_테스트를_한다()  {

        // given
        TestRestTemplate rest = new TestRestTemplate();

        // when
        ResponseEntity<String> res = rest.getForEntity("http://localhost:8080/hello?name={name}", String.class);

        // then
        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }


    @Test
    void Hello_Controller를_테스트_한다()  {

        // given
        HelloController helloController = new HelloController(name -> name);

        // when
        String result = helloController.hello("Test");

        // then
        Assertions.assertThat(result).isEqualTo("Test");
    }


    @Test
    void Hello_Controller_의_실패상황을_테스트_한다()  {

        // given
        HelloController helloController = new HelloController(name -> name);

        // when  // then
        Assertions.assertThatThrownBy(() -> {
            helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);

    }
}