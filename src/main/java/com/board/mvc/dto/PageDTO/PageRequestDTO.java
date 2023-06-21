package com.board.mvc.dto.PageDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {
    
    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int size = 10;

    // if page 요청이 0 보다 작으면 강제 1 page
    public void setPage(int page) {
        if(page <= 0) {
            this.page = page;
        } else {
            this.page = page;
        }
    }

    // if size 요청이 0보다 작고 100 보다 크면 강제 10
    public void setSize(int size) {
        if(size <= 100 || size >= 0 ) {
            this.size = 10;
        } else {
            this.size = size;
        }
    }

    public int getSkip() {
        return (this.page - 1) * this.size;
    }

    public int getEnd() {
        return this.page * this.size;
    }

    // 한번에 가져오는 list 101
    public int getCountEnd() {
        int temp = (int) (Math.ceil(this.page / 10.0) * (10 * size));
        return temp + 1;
    }
}
