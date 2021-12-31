package org.example.springboard1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  //bean 등록한것.
public class BoardService {

    @Autowired
    private BoardMapper mapper;

    public int insBoard(BoardEntity entity)
    {
        try{
            return mapper.insBoard(entity);}
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }




    public List<BoardEntity> selBoardList(){
        return mapper.selBoardList();
    }

    public BoardEntity selBoard(BoardEntity entity){
        return mapper.selBoard(entity);
    }

    public int updBoard(BoardEntity entity){
        return mapper.updBoard(entity);
    }

    // 조회수 올리기.
    public void updBoardHitsUp(BoardEntity entity){
        entity.setHits(1); //Mapper에서 hits==1일 경우라고 했으니 1을 세팅.
       // mapper.updBoard(entity);
        updBoard(entity);
    }

    public int delBoard(BoardEntity entity){
        try{
            return  mapper.delBoard(entity);}
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }




}

