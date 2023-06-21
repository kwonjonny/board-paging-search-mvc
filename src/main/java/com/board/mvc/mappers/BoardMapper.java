package com.board.mvc.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.mvc.dto.BoardDTO.BoardCreateDTO;
import com.board.mvc.dto.BoardDTO.BoardDTO;
import com.board.mvc.dto.BoardDTO.BoardListDTO;
import com.board.mvc.dto.BoardDTO.BoardUpdateDTO;
import com.board.mvc.dto.PageDTO.PageRequestDTO;

// BoardMapper interface 
@Mapper
public interface BoardMapper {

    // Board Create 
    Integer boardCreate(BoardCreateDTO boardCreateDTO);

    // Board Read 
    BoardDTO boardRead(Integer pno);

    // Board List 
    List<BoardListDTO> boardList(PageRequestDTO pageRequestDTO);

    // Board Delete 
    void boardDelete(Integer pno);

    // Board Update
    Integer boardUpdate(BoardUpdateDTO boardUpdateDTO);

    // Board total 
    Integer total(PageRequestDTO pageRequestDTO);
    
}
