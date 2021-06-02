package com.practice.helloquerydsl.board.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.practice.helloquerydsl.board.type.ArticleType;
import com.practice.helloquerydsl.boardComment.entity.BoardComment;
import com.practice.helloquerydsl.common.entity.CommonDateTimeEntity;
import com.practice.helloquerydsl.user.entity.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Board extends CommonDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255, nullable = false)
    private String title;
    @Lob
    private String content;
    @Enumerated(EnumType.STRING)
    private ArticleType articleType;
    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<BoardComment> boardComments;
    @Column
    private Boolean deleteAt;
}
