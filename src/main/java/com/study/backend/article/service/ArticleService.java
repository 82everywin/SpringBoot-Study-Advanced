package com.study.backend.article.service;


import com.study.backend.article.domain.Article;
import com.study.backend.article.dto.req.AddArticleReqDto;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    // 게시글 생성
    Article create(AddArticleReqDto reqDto);

    // 게시글 전체 조회
    List<Article> findAll();

    // 게시글 단일 조회
    Article findById(Long id);
}
