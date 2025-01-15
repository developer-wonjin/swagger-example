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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shop")
@RequiredArgsConstructor
@Tag(name = "태그 이름..", description = "태그 설명..")
public class TestController {
    @PostMapping("/abc")
    @Operation(summary = "컨트롤러메소드 요약..", description = "컨트롤러메소드 설명..")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "1000",
                    description = "요청에 성공하였습니다.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "비밀번호 암호화에 실패하였습니다.",
                    content = @Content(schema = @Schema(implementation = BasicResponseDto.class))
            )
    })
    @Parameters({
            @Parameter(name = "email", description = "이메일", example = "chrome123@naver.com"),
            @Parameter(name = "companyAddress", description = "업체 주소", example = "인천시 미추홀구 용현동")
    })
    public BasicResponseDto testMethod(
            @Schema(description = "Path Value", example = "1")
            Long pathValue,

            @Parameter(name = "paramValue", description = "Parameter Value", example = "3", required = true)
            @RequestParam
            Long paramValue,

            @RequestBody @Valid
            MemberJoinRequestDto requestBody
    ) {
        String s = String.format("PathValue = %d , ParamValue = %s, Request Email : %s", pathValue, paramValue, requestBody.getEmail());
        BasicResponseDto response = new BasicResponseDto(true, "Example API Success",  s);
        return response;
    }

    @PostMapping("/abc2")
    @Operation(summary = "컨트롤러메소드 요약..", description = "컨트롤러메소드 설명..")
    public String testMethod2(String input) {
        return input;
    }
}
