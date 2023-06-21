package com.board.mvc.service;

import com.board.mvc.dto.BoardDTO.BoardCreateDTO;
import com.board.mvc.dto.BoardDTO.BoardDTO;
import com.board.mvc.dto.BoardDTO.BoardListDTO;
import com.board.mvc.dto.BoardDTO.BoardUpdateDTO;
import com.board.mvc.dto.PageDTO.PageRequestDTO;
import com.board.mvc.dto.PageDTO.PageResponseDTO;

public interface BoardService {
    
    // Board Create Service
    Integer boardCreate(BoardCreateDTO boardCreateDTO);

    // Board Read Service
    BoardDTO boardRead(Integer pno);

    // Board List Service
    PageResponseDTO<BoardListDTO> boardList(PageRequestDTO pageRequestDTO);

    // Board Delete Service
    void boardDelete(Integer pno);

    // Board Update Service
    Integer boardUpdate(BoardUpdateDTO boardUpdateDTO);
    
}
