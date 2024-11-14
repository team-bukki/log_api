package com.buki.log_api.request;

import com.buki.log_api.common.constant.PlatformType;

public record LogEntryRequest(PlatformType platform) {
}
