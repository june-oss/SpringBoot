package com.june.board.service;

import com.june.board.repository.BoardRepository;
import com.june.board.dto.BoardDTO;
import com.june.board.entity.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService{

    private final BoardRepository repository;

    @Override
    public Long register(BoardDTO dto) {

        log.info(dto);

        Board board = dtoToEntity(dto);

        log.info("board : " +board);

        repository.save(board);

        log.info(board);
        return board.getBno();
    }


}
