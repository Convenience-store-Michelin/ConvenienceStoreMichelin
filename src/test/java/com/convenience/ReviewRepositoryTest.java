package com.convenience;

import com.convenience.domain.Review;
import com.convenience.domain.repository.ReviewRepository;
import net.bytebuddy.asm.MemberRemoval;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
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
    public void 게시글저장(){
        //given
        String author = "김주현";
        String title = "제목입니다.";
        String content = "내용이에요!";

        reviewRepository.save(Review.builder()
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
