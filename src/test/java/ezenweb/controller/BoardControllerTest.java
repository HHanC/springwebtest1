package ezenweb.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class BoardControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getlist() throws Exception {
        mvc.perform(get("/getlist")).andDo(print());
    }

    @Test
    void get2() throws Exception {

        mvc.perform(get("/get")
                        .param("bno" , "2")
                        .param("btitle" , "안녕하세요.")
                        .param("bcontent" , "게시물 작성 하고 싶습니다.")
                )
                .andDo(print());

    }

    @Test
    void testSave() throws Exception {

        mvc.perform(post("/save")
                        .param("btitle" , "안녕하세요.")
                        .param("bcontent" , "게시물 작성 하고 싶습니다."))
                .andDo(print());

    }

    @Test
    void testUpdate() throws Exception {

        mvc.perform(put("/update")
                        .param("bno" , "2")
                        .param("btitle" , "안녕!")
                        .param("bcontent" , "반갑다!")
                )
                .andDo(print());

    }

    @Test
    void delete1() throws Exception {

        mvc.perform(delete("/delete")
                        .param("bno" , "2"))
                .andDo(print());

    }
}