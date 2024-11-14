package com.buki.log_api.controller;


import com.buki.log_api.common.ApiResponse;
import com.buki.log_api.dto.EntryLog;
import com.buki.log_api.request.LogEntryRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/logs")
public class LogController {

    @PostMapping
    public ApiResponse<Boolean> makeLog(@RequestBody LogEntryRequest logEntryRequest, HttpServletRequest request) {
        log.info("Logging page entry");

        LocalDateTime now = LocalDateTime.now();
        String ipAddress = getRemoteAddr(request);

        EntryLog entryLog = EntryLog.builder()
                .platform(logEntryRequest.platform())
                .timestamp(now)
                .ipAddress(ipAddress)
                .build();

        System.out.println(entryLog);
        // repository 이용해 log 저장

        return ApiResponse.success(true);
    }

    @GetMapping("/{log_id}")
    public ApiResponse<?> getLog(@PathVariable("log_id") Long logId) {
        log.info("Getting log with id: {}", logId);

        // repository 이용해 log 조회

        return ApiResponse.success();
    }

    // load balancer를 통해 들어온 경우 X-FORWARDED-FOR 헤더를 사용
    private String getRemoteAddr(HttpServletRequest request) {
        return request.getHeader("X-FORWARDED-FOR") != null ?
                request.getHeader("X-FORWARDED-FOR") : request.getRemoteAddr();
    }
}
