package com.study.backend.article.controller;

import com.study.backend.article.domain.Article;
import com.study.backend.article.dto.req.AddArticleReqDto;
import com.study.backend.article.dto.res.ArticleDetailResDto;
import com.study.backend.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;
    
    @PostMapping
    public ResponseEntity<ArticleDetailResDto> create(@RequestBody AddArticleReqDto reqDto){

        Article article = articleService.create(reqDto);

        return ResponseEntity.status(CREATED).body(ArticleDetailResDto.toDto(article));
    }


    @GetMapping
    public ResponseEntity<List<ArticleDetailResDto>> getAll(){

        List<ArticleDetailResDto> resDtos = articleService.findAll().stream().map(ArticleDetailResDto::toDto).toList();

        return ResponseEntity.status(OK).body(resDtos);
    }
}
