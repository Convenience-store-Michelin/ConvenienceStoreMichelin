package com.convenience.web.dto;


import com.convenience.domain.Review;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
public class ReviewDto {
    private String category;
    private String title;
    private String content;
    private String author;

    public Review toEntity(){
        return Review.builder()
                .category(category)
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

    @Builder
    public ReviewDto(String category, String title, String content, String author){
        this.category = category;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}