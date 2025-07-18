package com.koreait.testboard.repository;

import com.koreait.testboard.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void insert(Board board);
    Board findById(int id);
    List<Board> findAll(int offset);
    void update(Board board);
    void delete(int id);
}
