package com.june.guestbook.service;

import com.june.guestbook.dto.GuestbookDTO;
import com.june.guestbook.dto.PageRequestDTO;
import com.june.guestbook.dto.PageResultDTO;
import com.june.guestbook.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GuestbookServiceTests {

    @Autowired
    private GuestbookService service;

    @Test
    public void testResgister(){

        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("Sample Title.....")
                .content("Sample Content....")
                .writer("user0")
                .build();

        System.out.println(service.register(guestbookDTO));
    }

    @Test
    public void testList(){

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .type("tc")
                .keyword("수정")
                .build();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);

        System.out.println("PREV: " + resultDTO.isPrev());
        System.out.println("NEXT: " + resultDTO.isNext());
        System.out.println("TOTAL : " + resultDTO.getTotalPage());
        System.out.println("------------------------------------------");
        for(GuestbookDTO guestbookDTO : resultDTO.getDtoList()){
            System.out.println(guestbookDTO);
        }

        System.out.println("==========================================");
        resultDTO.getPageList().forEach(i-> System.out.println(i));
    }
}
