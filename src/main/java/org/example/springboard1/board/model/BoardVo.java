package org.example.springboard1.board.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVo extends BoardEntity {
    private String writerNm; //나머진 다 상속받으니 안적어도되는거
    private String profileImg;

}
