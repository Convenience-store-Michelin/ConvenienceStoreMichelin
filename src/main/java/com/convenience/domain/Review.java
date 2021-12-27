package com.convenience.domain;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id @GeneratedValue()
    private Long id;

    private String title;
    private String content;
    private String author;

    private LocalDateTime createDate;
    private LocalDateTime modDate;

    @PrePersist
    public void createdAt(){
        final LocalDateTime now = LocalDateTime.now();
        this.createDate = now;
        this.modDate = now;
    }

}
