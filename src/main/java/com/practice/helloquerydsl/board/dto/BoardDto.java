package com.practice.helloquerydsl.board.dto;

import com.practice.helloquerydsl.boardComment.dto.BoardCommentDto;
import com.practice.helloquerydsl.user.entity.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private Long id;
    private String title;
    private String content;
    private String articleType;
    private User user;
    private List<BoardCommentDto> boardComments;
    private Boolean deleteAt;
    private LocalDateTime registDateTime;
    private LocalDateTime updateDateTime;

    private LocalDateTime from;
    private LocalDateTime to;
}
