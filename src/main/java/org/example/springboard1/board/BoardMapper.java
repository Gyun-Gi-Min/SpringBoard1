package org.example.springboard1.board;

import org.apache.ibatis.annotations.Mapper;
import org.example.springboard1.board.model.BoardEntity;
import org.example.springboard1.board.model.BoardVo;

import java.util.List;

@Mapper
public interface BoardMapper {
    //public abstract 들어감 앞에...

    int insBoard(BoardEntity entity);
    List<BoardVo> selBoardList();
    BoardVo selBoard(BoardEntity entity);
    int updBoard(BoardEntity entity);
    int delBoard(BoardEntity entity);

}
