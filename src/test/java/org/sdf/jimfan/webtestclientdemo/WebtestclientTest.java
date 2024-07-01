package org.sdf.jimfan.webtestclientdemo;

import org.sdf.jimfan.webtestclientdemo.dto.HelloDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class WebtestclientTest {

    @Autowired
    private WebTestClient webTestClient;
    
    @Test
    void shouldGetHelloMessage() {
        this.webTestClient
            .get()
            .uri("/api/hello")
            .header(HttpHeaders.CONTENT_TYPE, "application/json")
            .exchange()
            .expectStatus().isOk()
            .expectBody(HelloDTO.class).isEqualTo(new HelloDTO("Hello World!"));
    }
}
