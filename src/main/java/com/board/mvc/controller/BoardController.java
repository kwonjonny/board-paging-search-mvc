package com.board.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/board/")
public class BoardController {
    
    // GET : Create
    @GetMapping("create")
    public String getCreate() {
        log.info("GET | BoardCreate");
        return "create";
    }

    // GET : List
    @GetMapping("list")
    public String getList() {
        log.info("GET | BoardList");
        return "/board/list";
    }

    // GET : Read
    @GetMapping("read")
    public String getRead() {
        log.info("GET | BoardRead");
        return "/board/read";
    }

    // GET : Update 
    @GetMapping("update")
    public String getUpdate() {
        log.info("GET | BoardRead");
        return "/board/update";
    }

}
