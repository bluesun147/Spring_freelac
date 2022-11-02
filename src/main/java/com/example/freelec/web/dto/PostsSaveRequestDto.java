package com.example.freelec.web.dto;

import com.example.freelec.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    // 빌더 패턴
    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // Entity 클래스는 절대 res, req 클래스로 사용해서는 안됨.
    // 엔티티는 db와 맞닿은 핵심 클래스. 다 dto 따로 만들어서 사용하자!
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}