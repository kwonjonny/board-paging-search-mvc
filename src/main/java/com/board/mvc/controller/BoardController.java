package com.board.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.mvc.dto.BoardDTO.BoardCreateDTO;
import com.board.mvc.dto.BoardDTO.BoardDTO;
import com.board.mvc.dto.BoardDTO.BoardListDTO;
import com.board.mvc.dto.BoardDTO.BoardUpdateDTO;
import com.board.mvc.dto.PageDTO.PageRequestDTO;
import com.board.mvc.dto.PageDTO.PageResponseDTO;
import com.board.mvc.service.BoardService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/board/")
public class BoardController {

    // 의존성 주입 
    private final BoardService boardService;

    // Autworied 의존성 주입 명시 
    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }
    
    // GET : Create
    @GetMapping("create")
    public String getCreate() {
        log.info("GET | BoardCreate");
        return "board/create";
    }

    // GET : List
    @GetMapping("list")
    public String getList(PageRequestDTO pageRequestDTO, Model model) {
        log.info("GET | BoardList");
        PageResponseDTO<BoardListDTO> boardListDTO = boardService.boardList(pageRequestDTO);
        model.addAttribute("boardListDTO", boardListDTO);
        return "board/list";
    }

    // GET : Read
    @GetMapping("read/{tno}")
    public String getRead(@PathVariable("tno") Integer tno, Model model, PageRequestDTO pageRequestDTO) {
        log.info("GET | BoardRead");
        BoardDTO boardDTO = boardService.boardRead(tno);
        model.addAttribute("boardDTO", boardDTO);
        return "/board/read";
    }

    // GET : Update 
    @GetMapping("update/{tno}")
    public String getUpdate(@PathVariable("tno") Integer tno, Model model, PageRequestDTO pageRequestDTO) {
        log.info("GET | BoardRead");
        BoardDTO boardDTO = boardService.boardRead(tno);
        model.addAttribute("boardDTO", boardDTO);
        return "/board/update";
    }

    // POST : Create
    @PostMapping("create")
    public String postCreate(BoardCreateDTO boardCreateDTO, RedirectAttributes redirectAttributes) {
        Integer insertCount = boardService.boardCreate(boardCreateDTO);
        redirectAttributes.addFlashAttribute("message", insertCount +"번으로 게시글이 등록되었습니다.");
        return "redirect:/board/list";
    }

    // POST : Update
    @PostMapping("update")
    public String postUpdate(BoardUpdateDTO boardUpdateDTO, RedirectAttributes redirectAttributes) {
        boardService.boardUpdate(boardUpdateDTO);
        redirectAttributes.addFlashAttribute("message", "수정 작업이 완료되었습니다.");
        return "redriect:/board/read" + boardUpdateDTO.getTno();
    }

    // POST : Delete 
    @PostMapping("delete/{tno}")
    public String postDelete(@PathVariable("tno") Integer tno, RedirectAttributes redirectAttributes) {
        boardService.boardDelete(tno);
        redirectAttributes.addFlashAttribute("message", "삭제 작업이 완료되었습니다.");
        return "redirect:/board/list";
    }
}
