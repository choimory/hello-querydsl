package com.practice.helloquerydsl.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100, unique = true)
    private String userId;
    @Column(nullable = false, length = 100, unique = true)
    private String nickname;
    @Column(nullable = false, unique = true)
    private String email;
    @Column
    private Boolean isActivate;
    @Column
    private LocalDate birthDay;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime registDateTime;
}
