package ezenweb.service;

import ezenweb.domain.BoardEntity;
import ezenweb.domain.BoardRepository;
import ezenweb.dto.BoardDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // 저장
    @Transactional
    public boolean boardsave(BoardDto boardDto){
        boardRepository.save(boardDto.toentity());
        return true;
    }

    // 모두 호출
    @Transactional
    public JSONArray getlist(){
        List<BoardEntity> boards = boardRepository.findAll();
        JSONArray jsonArray = new JSONArray();
        for(BoardEntity entity : boards){
            JSONObject object = new JSONObject();
            object.put("bno" , entity.getBno());
            object.put("btitle" , entity.getBtitle());
            object.put("bcontent" , entity.getBcontent());
        }
        return jsonArray;
    }

    // 개별 호출
    @Transactional
    public JSONObject get(int bno){
        Optional<BoardEntity> optional = boardRepository.findById(bno);
        BoardEntity entity = optional.get();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("bno" , entity.getBno());
        jsonObject.put("btitle" , entity.getBtitle());
        jsonObject.put("bcontent" , entity.getBcontent());
        return jsonObject;
    }

    // 수정
    public boolean update(BoardDto boardDto){

        Optional<BoardEntity> optional = boardRepository.findById(boardDto.getBno());
        BoardEntity boardEntity = optional.get();
        boardEntity.setBtitle(boardDto.getBtitle());
        boardEntity.setBcontent(boardDto.getBcontent());
        return true;

    }

    // 삭제
    public boolean delete(int bno){

        BoardEntity boardEntity = boardRepository.findById(bno).get();
        boardRepository.delete(boardEntity);
        return true;

    }
}



















