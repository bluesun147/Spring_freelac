package com.example.freelec.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
// 스프링 시큐리티에서는 권한 코드에 항상 ROLE_이 앞에 있어야 함.
public enum Role { // enum 타입
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}