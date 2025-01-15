package com.example.demo.controller;

import com.example.demo.dto.BasicResponseDto;
import com.example.demo.dto.MemberJoinRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/shop")
@RequiredArgsConstructor
@Tag(name = "태그 이름..", description = "태그 설명..")
public class TestController {
    @PostMapping("/abc")
    @Operation(summary = "api이름", description = "api설명")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "응답코드 번호",
                    description = "응답코드 설명",
                    content = @Content(mediaType = "응답미디어타입")
            ),
            @ApiResponse(
                    responseCode = "응답코드 번호",
                    description = "응답코드 설명",
                    content = @Content(schema = @Schema(implementation = BasicResponseDto.class))
            )
    })
    @Parameters({
            @Parameter(name = "oneOf요청파라미터명", description = "oneOf설명", example = "oneOf예시값", required = true),
    })
    public BasicResponseDto testMethod(
            @Schema(name = "요청파라미터명", description = "설명", example = "예시값")
            Long pathValue,

            @Parameter(name = "요청파라미터명", description = "요청값", example = "예시값", required = true)
            @RequestParam
            Long paramValue,

            @RequestBody @Valid
            MemberJoinRequestDto requestBody
    ) {
        BasicResponseDto response = new BasicResponseDto(true, "Example API Success", "hello");
        return response;
    }
}

