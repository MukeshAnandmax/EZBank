package com.mukesh.accounts.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class AccuntsDto {

    private Long accountNumber;
    private  String accountType;
    private  String branchAddress;
}
