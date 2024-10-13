package com.study.backend.article.controller;

import com.study.backend.article.domain.Article;
import com.study.backend.article.dto.req.AddArticleReqDto;
import com.study.backend.article.dto.req.UpdateArticleReqDto;
import com.study.backend.article.dto.res.ArticleDetailResDto;
import com.study.backend.article.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/articles")
public class ArticleController {

    private final ArticleService articleService;

    @Operation(summary = "게시글 등록", description = "게시글을 등록합니다.")
    @PostMapping
    public ResponseEntity<ArticleDetailResDto> create(@RequestBody AddArticleReqDto reqDto){

        return ResponseEntity.status(CREATED).body(articleService.create(reqDto));
    }

    @Operation(summary = "게시글 전체 조회", description = "게시글을 전체 조회합니다.")
    @GetMapping
    public ResponseEntity<List<ArticleDetailResDto>> getAll(){

        return ResponseEntity.status(OK).body(articleService.findAll());
    }

    @Operation(summary = "게시글 단일 조회", description = "게시물 Id를 경로변수로 하여, 게시글을 단일 조회합니다.")
    @GetMapping("/{id}")
    public ResponseEntity<ArticleDetailResDto> getOne(@PathVariable Long id){

        return ResponseEntity.status(OK).body(articleService.findOne(id));
    }

    @Operation(summary = "게시글 수정", description = "게시물 Id를 경로변수로 하여 조회하고, 수정합니다.")
    @PutMapping("/{id}")
    public ResponseEntity<ArticleDetailResDto> update(@PathVariable Long id, @RequestBody UpdateArticleReqDto reqDto){
        return ResponseEntity.status(OK).body(articleService.update(id, reqDto));
    }
}
