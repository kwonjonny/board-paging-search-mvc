package com.board.mvc;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
class MvcApplicationTests {

	// 의존성 주입 
	@Autowired
	private DataSource dataSource;

	// dataBase 연결을 위한 테스트 
	@Test
	public void dbConnectionTest() {
		try (Connection connection = dataSource.getConnection()){
			log.info("is ready database connection");
		} catch (Exception e) {
			log.info("not ready database connection");
			e.printStackTrace();
		}
	}
}
