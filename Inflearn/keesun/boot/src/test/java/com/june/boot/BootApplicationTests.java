package com.june.boot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


@SpringBootTest
class BootApplicationTests {

	@Autowired
	Environment environment;

	@Test
	void contextLoads() {
		Assertions.assertEquals("hyeonjun", environment.getProperty("hyeonjung.name"));
	}

}
