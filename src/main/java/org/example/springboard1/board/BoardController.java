package org.example.springboard1.board;


import org.example.springboard1.UserUtils;
import org.example.springboard1.board.model.BoardEntity;
import org.example.springboard1.board.model.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/board") //이걸 붙여주면 앞에 board를 항상 붙이는것. RequestMapping만 가능함.
public class BoardController {
    @Autowired //private인데도 주솟값 들어옴.4버전일때 씀.
    private BoardService service;



    @RequestMapping("/list") //void로 했을때 주소값 매핑. (추정한다... 경로를 맞춰줘야한다)
    //@GetMapping("/list")
    public void list(Model model){
        List<BoardVo> list = service.selBoardList();
        model.addAttribute("list",list);
    }
    @GetMapping("/detail")
    public void detail(Model model, BoardEntity entity){
        service.updBoardHitsUp(entity);
        model.addAttribute("data",service.selBoard(entity));
    }

    @GetMapping("/write")
    public void write(){ }

    @PostMapping("/write")
    public String writeProc(BoardEntity entity, RedirectAttributes reAttr){
        System.out.println(entity);
        int result = service.insBoard(entity);
        if(result == 0){
           // reAttr.addAttribute("msg","글 등록 실패!");
            reAttr.addFlashAttribute("msg","글 등록 실패ㅠㅠ");
            reAttr.addFlashAttribute("data",entity);
            return "redirect:/board/write";
        }
        return "redirect:/board/list";
    }

    @GetMapping ("/del")
    public String delProc(BoardEntity entity, RedirectAttributes reAttr){

        int result = service.delBoard(entity);
        if(result == 0 ){
            reAttr.addFlashAttribute("msg","글 삭제 실패~~");
            reAttr.addAttribute("iboard",entity.getIboard());//쿼리스트링 iboard=pk값
         //   JOptionPane.showMessageDialog(null, "내용"); //블로그 참고
            return "redirect:/board/detail";
        }

        return "redirect:/board/list";
    }


    @GetMapping("/mod")
    public void mod(Model model,BoardEntity entity){
         model.addAttribute("data",service.selBoard(entity));
    }

    @PostMapping("/mod")
    public String modProc (BoardEntity entity){
        int result = service.updBoard(entity);
        return "redirect:/board/detail?iboard="+entity.getIboard();
    }

}
