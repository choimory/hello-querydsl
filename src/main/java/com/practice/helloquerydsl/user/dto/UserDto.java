package com.practice.helloquerydsl.user.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String  userId;
    private String nickname;
    private String email;
    private Boolean isActivate;
    private LocalDate birthDay;
    private LocalDateTime registDateTime;
}
