package com.buki.log_api.common;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private ApiError error;

    // success response with no data
    public static ApiResponse<?> success() {
        return ApiResponse.builder()
                .success(true)
                .message("Success")
                .build();
    }

    // success response with data
    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.success("Success", data);
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .build();
    }

    public static ApiResponse<?> error(ApiError error) {
        return ApiResponse.error(error, error.getMessage());
    }

    public static ApiResponse<?> error(ApiError error, String message) {
        return ApiResponse.builder()
                .success(false)
                .message(message)
                .error(error)
                .build();
    }
}

