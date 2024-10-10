package com.study.backend.article.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateArticleReqDto {
    private String title;
    private String content;

    @Builder
    public UpdateArticleReqDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
