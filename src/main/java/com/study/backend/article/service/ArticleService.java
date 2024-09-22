package com.study.backend.article.service;


import com.study.backend.article.domain.Article;
import com.study.backend.article.dto.req.AddArticleReqDto;

import java.util.List;

public interface ArticleService {

    // 게시글 생성
    Article create(AddArticleReqDto reqDto);

    // 게시글 조회
    List<Article> findAll();
}
