package io.divetrip.stream.exception;

import io.divetrip.stream.enumeration.DiveTripError;
import lombok.Getter;

@Getter
public class DiveTripException extends RuntimeException {

    private final DiveTripError diveTripError;
    private final String[] args;

    public DiveTripException(DiveTripError diveTripError) {
        super(diveTripError.getMessage());
        this.diveTripError = diveTripError;
        args = new String[0];
    }

    public DiveTripException(DiveTripError diveTripError, String... args) {
        super(diveTripError.getMessage());
        this.diveTripError = diveTripError;
        this.args = args;
    }

}
