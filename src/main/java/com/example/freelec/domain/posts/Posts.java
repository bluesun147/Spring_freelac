package com.example.freelec.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
// Posts 엔티티
@Getter
@NoArgsConstructor
@Entity
public class Posts {
    @Id // 해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk 생성 규칙,
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // 빌더 패턴 - 생성자에 인자 많을 때 사용
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    /*
    엔티티 내에 메소드 ??
    https://www.inflearn.com/questions/165818
    "Entity 객체 상태 변경을 Entity에서 하겠다는게 잘못된 일도 아니고,
    Entity가 아니라 다른곳에서 하겠다는 것 역시 잘못된 일이 아닙니다.
    어떻게 하든지 비즈니스 로직을 작성하는 코드가 자연스럽고
    테스트 하기 용이 하다면 어떻게 해도 괜찮습니다."
    */
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}