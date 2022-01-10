package com.convenience.domain.common;

import lombok.Getter;
import org.apache.tomcat.jni.Local;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //BaseEntity를 상속한 엔티티들은 아래 필드들을 컬럼으로 인식
@EntityListeners(value = {AuditingEntityListener.class}) //Auditing(자동으로 값 매핑) 기능 추가
public abstract class BaseTimeEntity {
    @CreatedDate
    @Column(name="createDate", updatable = false)
    private LocalDateTime createDate;
    @LastModifiedDate
    @Column(name="modDate", updatable = true)
    private LocalDateTime modDate;
}
