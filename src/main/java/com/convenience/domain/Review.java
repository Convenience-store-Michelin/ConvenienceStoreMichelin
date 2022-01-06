package com.convenience.domain;

import com.convenience.domain.common.BaseTimeEntity;
import lombok.*;
import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String category;
    private String title;
    private String content;
    private String author;

    @Builder
    public Review(Long id, String category, String title, String content, String author){
        this.id = id;
        this.category = category;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
