package com.MessageNetworkexample.MessageNetworkdemo;

import com.MessageNetworkexample.MessageNetworkdemo.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class MessageNetworkdemoApplication implements CommandLineRunner {


//	private final JwtTokenProvider tokenProvider;

	public static void main(String[] args) {
		SpringApplication.run(MessageNetworkdemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
	}
}
