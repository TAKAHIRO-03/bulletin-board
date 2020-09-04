package com.springvuesample.service;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * IDをString型で受け取って、Long型に返します。
 * 
 */

public class StringToLongConverter {
    static Long parseIdParam(final String pathId) throws IllegalArgumentException {
        if (!pathId.matches("^[0-9]*$") || StringUtils.isBlank(pathId)) {
            throw new IllegalArgumentException();
        }

        return Long.valueOf(pathId);
    }
}
