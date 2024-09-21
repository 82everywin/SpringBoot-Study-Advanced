package com.study.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration //설정 클래스이므로 빈 등록
@EnableJpaAuditing // JPA Auditing 기능 활성화 -> 자동으로 값을 등록함 (기본키, 시간)
public class JpaAuditingConfig {
}
