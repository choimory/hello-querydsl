package com.practice.helloquerydsl.board;

import com.practice.helloquerydsl.board.dto.BoardDto;
import com.practice.helloquerydsl.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BoardController {
    private final BoardService boardService;

    public List<BoardDto> getBoards(BoardDto param, Pageable pageable){
        return boardService.getBoardsDynamically(param, pageable);
    }
}
