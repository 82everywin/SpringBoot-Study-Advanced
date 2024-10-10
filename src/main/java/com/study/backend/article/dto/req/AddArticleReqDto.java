package com.study.backend.article.dto.req;

import com.study.backend.article.domain.Article;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AddArticleReqDto {
    private String title;
    private String content;

    @Builder
    private AddArticleReqDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static Article toEntity(AddArticleReqDto article) {
        return Article.builder()
                .title(article.getTitle())
                .content(article.getContent())
                .build();
    }
}
