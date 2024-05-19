package com.mukesh.accounts.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {

    @NotEmpty(message = "AccountNumber can't ne null or empty")
    @Pattern(regexp = "($|[0-9]{10})",message = "AccountNumber number must be 10 digits")
    private Long accountNumber;

    @NotEmpty(message = "AccountType can't ne null or empty")
    private  String accountType;

    @NotEmpty(message = "BranchAddress can't ne null or empty")
    private  String branchAddress;
}
