package com.practice.helloquerydsl.board.repository.custom;

import com.practice.helloquerydsl.board.entity.Board;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomBoardRepository {
    List<Board> getBoardsDynamically(Board param, Pageable pageable, LocalDateTime from, LocalDateTime to);
}
