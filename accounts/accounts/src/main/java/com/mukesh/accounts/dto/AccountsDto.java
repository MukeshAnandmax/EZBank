package com.mukesh.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
@Data
public class AccountsDto {

    @Schema(
            description = "AccountNumber of the Accounts",example = "9876543210"
    )
    @NotEmpty(message = "AccountNumber can't ne null or empty")
    @Pattern(regexp = "($|[0-9]{10})",message = "AccountNumber number must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "AccountType of the Accounts",example = "Savings"
    )
    @NotEmpty(message = "AccountType can't ne null or empty")
    private  String accountType;

    @Schema(
            description = "BranchAddress of the Accounts",example = "123 MG lane NewYork"
    )
    @NotEmpty(message = "BranchAddress can't ne null or empty")
    private  String branchAddress;
}
