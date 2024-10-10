package com.study.backend.article.dto.res;

import com.study.backend.article.domain.Article;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ArticleDetailResDto {
    private Long id;
    private String title;
    private String content;

    @Builder
    private ArticleDetailResDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static ArticleDetailResDto toDto(Article article) {
        return new ArticleDetailResDto(article.getId(), article.getTitle(), article.getContent());
    }
}
