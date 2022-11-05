package com.example.freelec.domain;

// JPA Auditing으로 생성 시간, 수정 시간 자동화
// LocalDate

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // jpa entity들이 BaseTimeEntity를 상속할 경우 필드들(createdDate, modifiedDate)도 컬럼으로 인식하도록
@EntityListeners(AuditingEntityListener.class) // 클래스에 auditing 기능 포함시킴
public class BaseTimeEntity {
    @CreatedDate // 엔티티 생성, 저장 시 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 엔티티 값 변경 시 시간 자동 저장
    private LocalDateTime modifiedDate;
}