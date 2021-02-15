package com.june.mreview.repository;

import com.june.mreview.entity.Member;
import com.june.mreview.entity.Movie;
import com.june.mreview.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class ReviewRepositoryTests {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void insertMovieReviews(){

        //200개의 리뷰를 등록
        IntStream.rangeClosed(1, 200).forEach(i ->{

            //영화번호
            Long mno = (long)(Math.random()*100) + 1;

            //리뷰어 번호
            Long mid = ((long)(Math.random()*100) + 1);
            Member member = Member.builder().mid(mid).build();

            Review movieReview = Review.builder()
                    .member(member)
                    .movie(Movie.builder().mno(mno).build())
                    .grade((int)(Math.random()*5) + 1)
                    .text("이 영화는 말이야....." + i)
                    .build();
            reviewRepository.save(movieReview);
        });
    }
}
