package io.divetrip.enumeration;

import io.divetrip.exception.DiveTripException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DiveTripError {
    // common
    INVALID_INPUT_VALUE("E001", "invalid.input.value", 400),
    INVALID_TYPE_VALUE("E002", "invalid.type.value", 400),
    RESOURCE_NOT_FOUND("E003", "resource.not.found", 404),
    METHOD_NOT_ALLOWED("E004", "method.not.allowed", 405),
    INTERNAL_SERVER_ERROR("E005", "internal.server.error", 500);

    private final String code;
    private final String message;
    private final int status;

    /* exception method */
    public DiveTripException exception() {
        return new DiveTripException(this);
    }

    public DiveTripException exception(String... args) {
        return new DiveTripException(this, args);
    }

}
