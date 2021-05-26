package com.practice.helloquerydsl.boardComment.dto;

import com.practice.helloquerydsl.board.dto.BoardDto;
import com.practice.helloquerydsl.user.dto.UserDto;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardCommentDto {
    private Long id;
    private String content;
    private BoardDto board;
    private UserDto user;
    private Boolean deleteAt;
    private LocalDateTime registDateTime;
    private LocalDateTime updateDateTime;
}
