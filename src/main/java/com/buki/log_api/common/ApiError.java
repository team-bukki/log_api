package com.buki.log_api.common;

import lombok.*;

@Data
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    private String code;
    private String message;
}
