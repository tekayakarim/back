package com.pfe.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.pfe.main.entity.JwtUser;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URL;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate restTemplate;

    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

	@Test
	public void getUserEmployeShouldReturnEmploye() throws Exception {
		assertThat(this.restTemplate.getForObject(this.base+"/main/user/getCurrentUserEmploye",
				JwtUser.class));
	}

}
