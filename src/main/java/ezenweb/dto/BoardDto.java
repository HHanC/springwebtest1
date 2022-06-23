package ezenweb.dto;

import ezenweb.domain.BoardEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class BoardDto {

    private int bno;
    private String btitle;
    private String bcontent;

    public BoardEntity toentity(){
        return BoardEntity.builder()
                .bno(this.bno)
                .btitle(this.btitle)
                .bcontent(this.bcontent)
                .build();
    }


}
