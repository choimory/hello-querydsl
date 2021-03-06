package com.practice.helloquerydsl.user.entity;

import com.practice.helloquerydsl.common.entity.CommonDateTimeEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends CommonDateTimeEntity {
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
}
