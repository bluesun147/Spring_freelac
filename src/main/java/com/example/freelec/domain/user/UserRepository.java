package com.example.freelec.domain.user;

import com.example.freelec.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

// @Repository 추가할 필요 없음.
// Entity 클래스와 기본 Entity Repository는 함께 위치해야 함.
// 도메인 별로 프로젝트 분리해도 Entity와 기본 Repository는 함꼐 위치해야 하므로 도메인 패키지에서 함께 관리
public interface UserRepository extends JpaRepository<User, Long> { // <엔티티 클래스, pk 타입>
    // data jpa에서 제공되지 않는 메서드는 퀴리로 작성 가능
    Optional<User> findbyEmail(String email); // 이메일 통해 이미 가입한 사용자인지 판단
}