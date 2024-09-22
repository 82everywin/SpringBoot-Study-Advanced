package com.study.backend.article.service;


import com.study.backend.article.domain.Article;
import com.study.backend.article.dto.req.AddArticleReqDto;

public interface ArticleService {

    Article create(AddArticleReqDto reqDto);

}
