package com.study.backend.article.service;


import com.study.backend.article.domain.Article;
import com.study.backend.article.dto.req.AddArticleReqDto;
import com.study.backend.article.dto.res.ArticleDetailResDto;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    // 게시글 생성
    ArticleDetailResDto create(AddArticleReqDto reqDto);

    // 게시글 전체 조회
    List<ArticleDetailResDto> findAll();

    // 게시글 단일 조회
    ArticleDetailResDto findById(Long id);
}
