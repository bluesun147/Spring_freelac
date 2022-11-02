package com.example.freelec.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 기능별로 dto 다 따로 만들어야 함.

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
   private String title;
   private String content;

   @Builder
    public PostsUpdateRequestDto(String title, String content) {
       this.title = title;
       this.content = content;
   }
}