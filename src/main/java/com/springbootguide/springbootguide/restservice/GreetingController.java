package com.springbootguide.springbootguide.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    /*
    - Jackson 라이브러리를 사용하여 instance 를 JSON 포맷으로 자동 정렬
    - Jackson 라이브러리는 기본적으로 Spring Web Starter 에 포함
    - 기존 MVC 컨트롤러와 RESTful 웹 서비스 컨트롤러으 주요 차이점은 HTTP response body 의 생성 방법
        - Server-side HTML 렌더링을 수행하는 대신, 'Greeting' Object 의 데이터를 HTTP response 에 직접 JSON 으로 작성
        - Jackson2HttpMessageConverter 에 의해 JSON 포맷으로 자동 Convert

    - @RestController - View 대신 Domain 을 반환하는 컨트롤러 (@Controller, @ResponseBody 를 포함하는 기능)
    - @GetMapping - /greeting 에 대한 HTTP GET 요청이 greeting() 메서드에 매핑되도록 함
    - @RequestParam - 쿼리스트링 매개 변수 이름의 값을 greeting() 메서드의 이름 매개변수로 바인딩, 요청에 매개변수가 없는 경우 기본값으로 "World" 셋팅
     */
}
