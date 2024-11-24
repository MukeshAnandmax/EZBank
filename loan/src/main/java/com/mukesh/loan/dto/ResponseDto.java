package com.mukesh.loan.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
@Schema(
        name = "Response",
        description = "Schema to hold Response information"
)
@Data
@AllArgsConstructor
public class ResponseDto {
    @Schema(
            description = "statusCode of the Response",example = "200"
    )
    private String statusCode;

    @Schema(
            description = "status message of the Response",example = "Request Processed Successfully"
    )
    private String statusMsg;
}
