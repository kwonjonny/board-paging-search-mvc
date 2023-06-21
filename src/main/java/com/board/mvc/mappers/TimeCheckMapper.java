package com.board.mvc.mappers;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimeCheckMapper {
    
    // MyBatis timeCheck 를 위한 메소드 
    String getTime();

}
