package com.board.mvc.dto.PageDTO;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// GenericType 으로 다른 dto 에서도 재활용 가능 
@Getter
@Setter
@ToString
public class PageResponseDTO<E> {
    
    private List<E> list;
    private int total;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(List<E> list, int total) {
        this.list = list;
        this.total = total;
    }
}
