package com.june.board.repository.search;

import com.june.board.entity.Board;
import com.june.board.entity.QBoard;
import com.june.board.entity.QMember;
import com.june.board.entity.QReply;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Log4j2
public class SearchBoardRepositoryImpl extends QuerydslRepositorySupport implements SearchBoardRepository{

    public SearchBoardRepositoryImpl(){
        super(Board.class);
    }

    @Override
    public Board search1() {

        log.info("Search1...............");

        QBoard board = QBoard.board;
        QReply reply = QReply.reply;
        QMember member = QMember.member;

        JPQLQuery<Board> jpqlQuery = from(board);
        jpqlQuery.leftJoin(member).on(board.writer.eq(member));
        jpqlQuery.leftJoin(reply).on(reply.board.eq(board))

        jpqlQuery.select(board).where(board.bno.eq(1L));

        log.info("-------------------------");
        log.info(jpqlQuery);
        log.info("-------------------------");

        List<Board> result = jpqlQuery.fetch();

        return null;
    }
}
