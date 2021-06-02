package com.practice.helloquerydsl.boardComment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.practice.helloquerydsl.board.entity.Board;
import com.practice.helloquerydsl.common.entity.CommonDateTimeEntity;
import com.practice.helloquerydsl.user.entity.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardComment extends CommonDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255, nullable = false)
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    private Board board;
    @OneToOne
    private User user;
    @Column
    private Boolean deleteAt;
}
