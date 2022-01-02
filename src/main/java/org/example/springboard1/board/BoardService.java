package org.example.springboard1.board;


import org.example.springboard1.UserUtils;
import org.example.springboard1.board.model.BoardEntity;
import org.example.springboard1.board.model.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  //bean 등록한것.
public class BoardService {

    @Autowired
    private BoardMapper mapper;

    @Autowired
    private UserUtils userUtils;



    public int insBoard(BoardEntity entity) {
        int result = 0;
        try{
            entity.setWriter(userUtils.getLoginUserPk());
            result = mapper.insBoard(entity);}
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }


    public List<BoardVo> selBoardList(){
        return mapper.selBoardList();
    }

    public BoardVo selBoard(BoardEntity entity){
        return mapper.selBoard(entity);
    }

    public int updBoard(BoardEntity entity){
        entity.setWriter(userUtils.getLoginUserPk());
        try{
            return mapper.updBoard(entity);}
        catch(Exception e){
            e.printStackTrace();
        } return 0;


    }

    // 조회수 올리기.
    public void updBoardHitsUp(BoardEntity entity){
        entity.setHit(1); //Mapper에서 hits==1일 경우라고 했으니 1을 세팅.
       // mapper.updBoard(entity);
        mapper.updBoard(entity);
    }

    public int delBoard(BoardEntity entity){
        entity.setWriter(userUtils.getLoginUserPk());
        try{
            return  mapper.delBoard(entity);}
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }




}

