package com.board.mvc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.board.mvc.dto.BoardDTO.BoardCreateDTO;
import com.board.mvc.dto.BoardDTO.BoardDTO;
import com.board.mvc.dto.BoardDTO.BoardListDTO;
import com.board.mvc.dto.BoardDTO.BoardUpdateDTO;
import com.board.mvc.dto.PageDTO.PageRequestDTO;
import com.board.mvc.dto.PageDTO.PageResponseDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class BoardServiceTests {
    
    // 의존성 주입 
    @Autowired
    private BoardService boardService;

    private static final String TEST_TITLE = "JunitServiceTest";
    private static final String TEST_WRITER = "JunitServiceTest";
    private static final String TEST_CONTENT = "JunitServiceTest";
    private static final Integer TEST_TNO = 34209267;

    // BeforeEach 사용을 위한 BoardCreateDTO, BoardUpdateDTO 정의 
    private BoardCreateDTO boardCreateDTO;
    private BoardUpdateDTO boardUpdateDTO;

    // BoardService Create Test Set Up 
    // BoardService Update Test Set Up 
    @BeforeEach
    public void setUp() {
        boardCreateDTO = BoardCreateDTO.builder()
        .title(TEST_TITLE)
        .writer(TEST_WRITER)
        .content(TEST_CONTENT)
        .build();

        boardUpdateDTO = BoardUpdateDTO.builder()
        .tno(TEST_TNO)
        .title(TEST_TITLE)
        .writer(TEST_WRITER)
        .content(TEST_CONTENT)
        .build();
    }

    // BoardService Create Test 
    @Test
    @Transactional
    @DisplayName("게시판 생성 테스트 서비스")
    public void createBoardserviceTest() {
        log.info("========== Start Board Service Create ==========");
        Integer insertCount = boardService.boardCreate(boardCreateDTO);
        assertEquals(1, insertCount, "Insert should be successful");
        log.info("========== End Board Service Create ==========");
    }

    // BoardService Read Test 
    @Test
    @Transactional
    @DisplayName("게시판 읽기 테스트 서비스")
    public void readBoardServiceTest() {
        log.info("========== Start Board Service Read ==========");
        log.info(boardService.boardRead(TEST_TNO));
        log.info("========== End Board Service Read ==========");
    }

    @Test
    public void testBoardListSearch() {
        log.info("========== Start Board Service list =========");
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
            .searchType("title")
            .keyword("권성준님1234")
            .build();
        PageResponseDTO<BoardListDTO> response = boardService.boardList(pageRequestDTO); 

        // list 로그 
        log.info(response);
        // 가져온 게시물들이 검색 조건에 부합하는지 확인
        for (BoardListDTO board : response.getList()) {
        assertTrue(board.getTitle().contains("권성준님1234"), "Title should contain '권성준님1234'");
        }
        log.info("========== End Board Service List ==========");
    }


    // BoardService Delete Test 
    @Test
    @Transactional
    @DisplayName("게시판 삭제 테스트 서비스")
    public void deleteBoardServiceTest() {
        log.info("========== Start Board Delete Test ==========");
        boardService.boardDelete(TEST_TNO);
        BoardDTO deleteBoard = boardService.boardRead(TEST_TNO);
        assertNull(deleteBoard, "Deleted Board should be null");
        log.info("========== End Board Delete Test ==========");
    }

    // BoardService Update Test 
    @Test
    @Transactional
    @DisplayName("게시판 업데이트 테스트 서비스")
    public void updateBoardServiceTest() {
        log.info("========== Start Board Update Test ==========");
        boardService.boardUpdate(boardUpdateDTO);
        BoardDTO updatedBoard = boardService.boardRead(TEST_TNO);
        assertNotNull(updatedBoard, "Updated Board should not be null");
        assertEquals(TEST_TITLE, updatedBoard.getTitle(), "Title should be updated");
        log.info("========== End Board Update Test ==========");
    }
}
