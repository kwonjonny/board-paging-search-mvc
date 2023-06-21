package com.board.mvc.mappers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class BoardMapperTests {

    private static final String TEST_TITLE = "TestTitleMapper";
    private static final String TEST_WRITER = "TestWriterMapper";
    private static final String TEST_CONTENT = "TestContentMapper";
    private static final Long TEST_TNO = 34209267L;

    // 의존성 주입 
    @Autowired
    private BoardMapper boardMapper;

    // BoardMapper Create Test
    @Test
    @Transactional
    @DisplayName("게시판 생성 테스트")
    public void boardMapperCreateTest() {
        log.info("========== Start Board Mapper Create ==========");

        

        log.info("========== End Board Mapper Create ==========");
    }
    
    
}
