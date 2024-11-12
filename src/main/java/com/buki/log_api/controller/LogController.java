package com.buki.log_api.controller;


import com.buki.log_api.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/log")
public class LogController {

    @GetMapping("/entry")
    public ApiResponse<Boolean> logEntry(){
        log.info("Logging page entry");
        return ApiResponse.success(true);
    }
}
