package com.board.mvc.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.board.mvc.dto.BoardDTO.BoardCreateDTO;

@Mapper
public interface BoardMapper {

    // Board Create 
    Integer boardCreate(BoardCreateDTO boardCreateDTO);
}
