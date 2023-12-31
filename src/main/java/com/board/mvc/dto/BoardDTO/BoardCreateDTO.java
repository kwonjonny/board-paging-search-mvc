package com.board.mvc.dto.BoardDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardCreateDTO {
    private Integer tno;
    private String title;
    private String content;
    private String writer;
}
