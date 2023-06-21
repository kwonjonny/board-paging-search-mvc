package com.board.mvc.mappers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.board.mvc.dto.BoardDTO.BoardCreateDTO;
import com.board.mvc.dto.BoardDTO.BoardDTO;
import com.board.mvc.dto.BoardDTO.BoardUpdateDTO;
import com.board.mvc.dto.PageDTO.PageRequestDTO;
import com.board.mvc.dto.PageDTO.PageResponseDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class BoardMapperTests {

    // 의존성 주입 
    @Autowired
    private BoardMapper boardMapper;

    private static final String TEST_TITLE = "TestTitleMapper";
    private static final String TEST_WRITER = "TestWriterMapper";
    private static final String TEST_CONTENT = "TestContentMapper";
    private static final Integer TEST_TNO = 34209267;

    // BeforeEach 사용을 위한 BoardCreateDTO, BoardUpdateDTO 정의 
    private BoardCreateDTO boardCreateDTO;
    private BoardUpdateDTO boardUpdateDTO;

    // BoardMapper Create Test Set Up 
    @BeforeEach
    public void setUp() {
        boardCreateDTO = BoardCreateDTO.builder()
        .title(TEST_TITLE)
        .writer(TEST_WRITER)
        .content(TEST_CONTENT)
        .build();
    }

    // BoardMapper Update Test Set Up 
    @BeforeEach
    public void setUpdate() {
        boardUpdateDTO = BoardUpdateDTO.builder()
        .tno(TEST_TNO)
        .title(TEST_TITLE)
        .writer(TEST_WRITER)
        .content(TEST_CONTENT)
        .build();
    }

    // BoardMapper Create Test
    @Test
    @Transactional
    @DisplayName("게시판 생성 테스트")
    public void boardMapperCreateTest() {
        log.info("========== Start Board Mapper Create ==========");
        Integer insertCount = boardMapper.boardCreate(boardCreateDTO);
        Assertions.assertEquals(1, insertCount, "Board should be created successfully");
        log.info("========== End Board Mapper Create ==========");
    }

    // BoardMapper Read Test
    @Test
    @Transactional
    @DisplayName("게시판 읽기 테스트")
    public void boardMapperReadTest() {
        log.info("========== Start Board Mapper Read ==========");
        BoardDTO boardDTO = boardMapper.boardRead(TEST_TNO);
        log.info(boardDTO);
        log.info("========== Start Board Mapper Read ==========");
    }

    // BoardMapper List Test
    @Test
    @Transactional
    @DisplayName("게시판 리스트 테스트")
    public void boardMapperListTest() {
        log.info("========== Start Board Mapper List ==========");
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        log.info(boardMapper.boardList(pageRequestDTO));
        log.info("========== End Board Mapper List ==========");
    }

    // BoardMapper Delete Test
    @Test
    @Transactional
    @DisplayName("게시판 삭제 테스트")
    public void boardMapperDeleteTest() {
        log.info("========== Start Board Mapper Delete ==========");
        boardMapper.boardDelete(TEST_TNO);
        log.info("========== End Board Mapper Delete ==========");
    }
    
    // Board update Test
    @Test
    @Transactional
    @DisplayName("게시판 업데이트 테스트")
    public void boardMapperUpdateTest() {
        log.info("========== Start Board Mapper Update ==========");
        boardMapper.boardUpdate(boardUpdateDTO);
        BoardDTO updatedBoard = boardMapper.boardRead(TEST_TNO);
        Assertions.assertNotNull(updatedBoard, "Updated Board should not be null");
        log.info(updatedBoard);
        log.info("========== End Board Mapper Update ==========");
    }

    // Board Total Test 
    @Test
    @Transactional
    @DisplayName("게시판 Total Count 테스트")
    public void boardMapperTotalTest() {
        log.info("========== Start Board Mapper Total ==========");
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        Integer totalCount = boardMapper.total(pageRequestDTO);
        Assertions.assertNotNull(totalCount >= 0 , "Total count should be non-negative");
        log.info(totalCount);
        log.info("=========== End Board Mapper Total ==========");
    }
    

}
