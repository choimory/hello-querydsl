package com.practice.helloquerydsl.board.repository;

import com.practice.helloquerydsl.board.entity.Board;
import com.practice.helloquerydsl.board.repository.custom.CustomBoardRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, CustomBoardRepository {
}
