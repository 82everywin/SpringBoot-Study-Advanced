package com.study.backend.article.controller;

import com.study.backend.article.domain.Article;
import com.study.backend.article.dto.req.AddArticleReqDto;
import com.study.backend.article.dto.res.ArticleDetailResDto;
import com.study.backend.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<ArticleDetailResDto> create(@RequestBody AddArticleReqDto reqDto){

        Article article = articleService.create(reqDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(ArticleDetailResDto.toDto(article));
    }
}
