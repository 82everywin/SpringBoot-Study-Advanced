package com.study.backend.article.service.impl;

import com.study.backend.article.domain.Article;
import com.study.backend.article.dto.req.AddArticleReqDto;
import com.study.backend.article.repository.ArticleRepository;
import com.study.backend.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public Article create(AddArticleReqDto reqDto) {
        Article article = Article.builder()
                .title(reqDto.getTitle())
                .content(reqDto.getContent())
                .build();

        return articleRepository.save(article);
    }

    @Override
    public List<Article> findAll() {
        List<Article> articles = articleRepository.findAll();

        return articles;
    }

    @Override
    public Article findById(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Article not found"));

        return article;
    }
}
