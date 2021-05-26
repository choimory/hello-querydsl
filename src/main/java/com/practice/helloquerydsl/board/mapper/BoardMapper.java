package com.practice.helloquerydsl.board.mapper;

import com.practice.helloquerydsl.board.dto.BoardDto;
import com.practice.helloquerydsl.board.entity.Board;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface BoardMapper {
    BoardDto toDto(Board board);
    List<BoardDto> toDto(List<Board> boards);
    List<BoardDto> toDto(Page<Board> boards);

    Board toEntity(BoardDto boardDto);
    List<Board> toEntity(List<BoardDto> boardDtos);
    List<Board> toEntity(Page<BoardDto> boardDtos);
}
