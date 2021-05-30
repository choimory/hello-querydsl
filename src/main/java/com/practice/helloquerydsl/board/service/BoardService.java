package com.practice.helloquerydsl.board.service;

import com.practice.helloquerydsl.board.dto.BoardDto;
import com.practice.helloquerydsl.board.mapper.BoardMapper;
import com.practice.helloquerydsl.board.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    public List<BoardDto> getBoardsDynamically(BoardDto param, Pageable pageable){
        return boardMapper.toDto(boardRepository.getBoardsDynamically(boardMapper.toEntity(param), pageable, param.getFrom(), param.getTo()));
    }
}
