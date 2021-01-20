package com.june.board.service;

import com.june.board.dto.BoardDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){

        BoardDTO dto = BoardDTO.builder()
                .title("Test.....")
                .content("Test......")
                .writerEmail("user44@aaa.com")
                .build();

        Long bno = boardService.register(dto);
    }

}
