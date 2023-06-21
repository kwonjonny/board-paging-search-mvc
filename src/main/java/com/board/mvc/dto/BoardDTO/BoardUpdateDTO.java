package com.board.mvc.dto.BoardDTO;

import java.time.LocalDate;

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
public class BoardUpdateDTO {
    private Integer tno;
    private String title;
    private String content;
    private String writer;
    private LocalDate updateDate;
}
