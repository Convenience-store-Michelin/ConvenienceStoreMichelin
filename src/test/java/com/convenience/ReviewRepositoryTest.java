package com.convenience;

import com.convenience.domain.Review;
import com.convenience.domain.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ReviewRepositoryTest {

    @Autowired ReviewRepository reviewRepository;
/*

    @After
    public void cleanup(){
        reviewRepository.deleteAll();
    }
*/

    @Test
    void 게시글저장(){
        //given
        String category = "카테고리1";
        String author = "김주현";
        String title = "제목입니다.";
        String content = "내용이에요!";

        reviewRepository.save(Review.builder()
                .category(category)
                .author(author)
                .title(title)
                .content(content)
                .build()
        );
        //when
        List<Review> reviewList = reviewRepository.findAll();
        //then
        Review findReview = reviewList.get(0);
        assertThat(findReview.getAuthor()).isEqualTo(author);
        assertThat(findReview.getTitle()).isEqualTo(title);
        assertThat(findReview.getContent()).isEqualTo(content);
    }
}
