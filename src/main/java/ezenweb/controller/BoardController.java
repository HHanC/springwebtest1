package ezenweb.controller;

import ezenweb.dto.BoardDto;
import ezenweb.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class BoardController {

    //////////////////////////////////////////////////////////////

    @Autowired
    private BoardService boardService;

    //////////////////////////////////////////////////////////////////

    // 모두 호출
    @GetMapping("/getlist")
    public void getlist(HttpServletResponse response){
        try{
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(boardService.getlist());
        }catch(Exception e){}
    }

    // 개별 호출
    @GetMapping("/get")
    public void get(HttpServletResponse response , @RequestParam("bno") int bno){
        try{
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(boardService.get(bno));
        }catch(Exception e){}
    }

    // 저장
    @PostMapping("/save")
    @ResponseBody
    public boolean save(BoardDto boardDto){
        return boardService.boardsave(boardDto);
    }

    // 수정
    @PutMapping("/update")
    @ResponseBody
    public boolean update(BoardDto boardDto){
        return boardService.update(boardDto);
    }

    //삭제
    @DeleteMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestParam("bno") int bno ){
        return boardService.delete(bno);
    }

}





















