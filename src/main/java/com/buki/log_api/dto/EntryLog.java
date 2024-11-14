package com.buki.log_api.dto;

import com.buki.log_api.common.constant.EventType;
import com.buki.log_api.common.constant.PlatformType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntryLog {
    private PlatformType platform;
    private LocalDateTime timestamp;
    private EventType eventType = EventType.ENTRY;
    private String ipAddress;
}
