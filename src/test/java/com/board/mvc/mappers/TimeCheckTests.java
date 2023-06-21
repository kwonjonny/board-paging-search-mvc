package com.board.mvc.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class TimeCheckTests {
    
    // 의존성 주입 => TimeCheckMapper
    @Autowired(required = false)
    private TimeCheckMapper timeCheckMapper;

    // timeCheck 를 위한 test 
    @Test
    public void timeCheckTest() {
        log.info("========== Start Time Check ==========");
        log.info(timeCheckMapper.getTime());
        log.info("========== End Time Check ==========");
    }


}
