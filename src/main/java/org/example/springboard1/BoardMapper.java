package org.example.springboard1;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    //public abstract 들어감 앞에...

    int insBoard(BoardEntity entity);
    List<BoardEntity> selBoardList();
    BoardEntity selBoard(BoardEntity entity);
    int updBoard(BoardEntity entity);
    int delBoard(BoardEntity entity);

}
