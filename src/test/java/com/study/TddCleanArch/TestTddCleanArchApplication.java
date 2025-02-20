package com.study.TddCleanArch;

import org.springframework.boot.SpringApplication;

public class TestTddCleanArchApplication {

	public static void main(String[] args) {
		SpringApplication.from(TddCleanArchApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
