package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/spring")
@Tag(name = "태그 이름..2", description = "태그 설명..2")
public class Test2Controller {

    @GetMapping("/abc3")
    @Operation(summary = "컨트롤러메소드 요약..", description = "컨트롤러메소드 설명..")
    public String test2() {
        return "abc";
    }
}
