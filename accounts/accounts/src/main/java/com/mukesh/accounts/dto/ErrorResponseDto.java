package com.mukesh.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "ErrorResponse",
        description = "Schema to hold ErrorResponse information"
)
@Data@AllArgsConstructor
public class ErrorResponseDto {

    @Schema(
            description = "API Path invoked by client"
    )
    private String apiPath;

    @Schema(
            description = "ErrorCode of the ErrorResponse"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "ErrorMessage of the ErrorResponse"
    )
    private String errorMessage;

    @Schema(
            description = "Time of the Error"
    )
    private LocalDateTime errorTime;
}
