package com.study.backend.article.service.impl;

import com.study.backend.article.domain.Article;
import com.study.backend.article.dto.req.AddArticleReqDto;
import com.study.backend.article.dto.req.UpdateArticleReqDto;
import com.study.backend.article.dto.res.ArticleDetailResDto;
import com.study.backend.article.repository.ArticleRepository;
import com.study.backend.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    @Transactional
    public ArticleDetailResDto create(AddArticleReqDto reqDto) {

        Article article = articleRepository.save(AddArticleReqDto.toEntity(reqDto));

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
    public ArticleDetailResDto findOne(Long id) {
        Article article = findById(id);

        return ArticleDetailResDto.toDto(article);
    }

    @Override
    @Transactional
    public ArticleDetailResDto update(Long id, UpdateArticleReqDto reqDto) {
        Article article = findById(id);
        article.update(reqDto.getTitle(), reqDto.getContent());
        return ArticleDetailResDto.toDto(article);
    }


    private Article findById(Long id){
        return articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Article not found"));
    }


}
