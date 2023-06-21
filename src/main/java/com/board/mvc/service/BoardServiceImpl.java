package com.board.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.mvc.dto.BoardDTO.BoardCreateDTO;
import com.board.mvc.dto.BoardDTO.BoardDTO;
import com.board.mvc.dto.BoardDTO.BoardListDTO;
import com.board.mvc.dto.BoardDTO.BoardUpdateDTO;
import com.board.mvc.dto.PageDTO.PageRequestDTO;
import com.board.mvc.dto.PageDTO.PageResponseDTO;
import com.board.mvc.mappers.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
    
    // 의존성 주입 
    private final BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    // Board Create ServiceImpl
    @Override
    @Transactional
    public Integer boardCreate(BoardCreateDTO boardCreateDTO) {
        return boardMapper.boardCreate(boardCreateDTO);
    }

    // Board read ServiceImpl
    @Override
    @Transactional
    public BoardDTO boardRead(Integer pno) {
        return boardMapper.boardRead(pno);
    }

    // Board List ServiceImpl
    @Override
    @Transactional
    public PageResponseDTO<BoardListDTO> boardList(PageRequestDTO pageRequestDTO) {
        List<BoardListDTO> List = boardMapper.boardList(pageRequestDTO);
        Integer total = boardMapper.total(pageRequestDTO);
        return PageResponseDTO.<BoardListDTO>withAll()
                .list(List)
                .total(total)
                .build();
    }

    // Board Delete ServiceImpl
    @Override
    @Transactional
    public void boardDelete(Integer pno) {
        boardMapper.boardDelete(pno);;
    }

    // Board Update ServiceImpl
    @Override
    @Transactional
    public Integer boardUpdate(BoardUpdateDTO boardUpdateDTO) {
        return boardMapper.boardUpdate(boardUpdateDTO);
    }
}
