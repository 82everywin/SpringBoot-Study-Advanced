package com.study.backend.article.service.impl;

import com.study.backend.article.domain.Article;
import com.study.backend.article.dto.req.AddArticleReqDto;
import com.study.backend.article.dto.res.ArticleDetailResDto;
import com.study.backend.article.repository.ArticleRepository;
import com.study.backend.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    @Transactional
    public ArticleDetailResDto create(AddArticleReqDto reqDto) {

        Article article = articleRepository.save(Article.builder()
                                   .title(reqDto.getTitle())
                                    .content(reqDto.getContent())
                                    .build());

        return ArticleDetailResDto.toDto(article);
    }

    @Override
    @Transactional
    public List<ArticleDetailResDto> findAll() {
        List<Article> articles = articleRepository.findAll();

        return articles.stream()
                .map(ArticleDetailResDto::toDto).toList();
    }

    @Override
    @Transactional
    public ArticleDetailResDto findById(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Article not found"));

        return ArticleDetailResDto.toDto(article);
    }

    @Transactional
    public ArticleDetailResDto update(AddArticleReqDto reqDto) {}
}
