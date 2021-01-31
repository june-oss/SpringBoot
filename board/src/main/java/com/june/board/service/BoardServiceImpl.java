package com.june.board.service;

import com.june.board.dto.PageRequestDTO;
import com.june.board.dto.PageResultDTO;
import com.june.board.entity.Member;
import com.june.board.repository.BoardRepository;
import com.june.board.dto.BoardDTO;
import com.june.board.entity.Board;
import com.june.board.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService{

    private final BoardRepository repository;
    private final ReplyRepository replyRepository;
    @Override
    public Long register(BoardDTO dto) {

        log.info(dto);

        Board board = dtoToEntity(dto);

        log.info("board : " +board);

        repository.save(board);

        log.info(board);
        return board.getBno();
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO){
        log.info(pageRequestDTO);

        Function<Object[], BoardDTO> fn = (en -> entityToDTO( (Board)en[0], (Member)en[1], (Long)en[2]) );

//        Page<Object[]> result = repository.getBoardWithReplyCount(pageRequestDTO.getPageable(Sort.by("bno").descending()));
        Page<Object[]> result = repository.searchPage(
                pageRequestDTO.getType(),
                pageRequestDTO.getKeyword(),
                pageRequestDTO.getPageable(Sort.by("bno").descending())
        );

        return new PageResultDTO<>(result, fn);
    }

    @Override
    public BoardDTO get(Long bno){

        Object result = repository.getBoardByBno(bno);

        Object[] arr = (Object[]) result;

        return entityToDTO((Board) arr[0], (Member) arr[1], (Long) arr[2]);
    }

    @Transactional
    @Override
    public void removeWithReplies(Long bno){

        replyRepository.deleteByBno(bno);

        repository.deleteById(bno);
    }

    @Transactional
    @Override
    public void modify(BoardDTO boardDTO){
//        log.info("first:"+boardDTO);
        Board board = repository.getOne(boardDTO.getBno());

        if(board != null){
//            log.info(boardDTO.getTitle());
//            log.info(boardDTO.getContent());

            board.changeTitle(boardDTO.getTitle());
            board.changeContent(boardDTO.getContent());

//            log.info("modify : " + board);
            repository.save(board);
        }
    }
}
