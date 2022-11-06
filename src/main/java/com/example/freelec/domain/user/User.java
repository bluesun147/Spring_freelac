package com.example.freelec.domain.user;

import com.example.freelec.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
// 유저 엔티티
public class User extends BaseTimeEntity { // 자동 생성 시간 위해 상속
    @Id // 해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk 생성 규칙,
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING) // enum 값 어떤 형태로 저장할 지 결정. 기본 int로 저장되면 무슨 값인지 모르므로 String으로 하자
    @Column(nullable = false)
    private Role role; // Role이 enum 클래스

    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
