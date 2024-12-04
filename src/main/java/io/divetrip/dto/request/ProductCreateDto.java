package io.divetrip.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductCreateDto {
    /* 다이버 ID */
    @NotNull
    private UUID diverId;

    /* 여행 숙소 ID */
    @NotNull
    private UUID tripLodgingId;


}
