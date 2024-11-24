package com.mukesh.accounts.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
@Data
public class CustomerDto {

    @Schema(
            description = "Name of the Customer",example = "Mukesh Anand"
    )
    @NotEmpty(message = "Name can't ne null or empty")
    @Size(min = 5,max = 30,message = "The Length of name field should be between 5 and 30")
    private String name;

    @Schema(
            description = "Email of the Customer",example = "Mukeshanand23@gmail.com"
    )
    @NotEmpty(message = "Email can't ne null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @Schema(
            description = "Mobile number of the Customer",example = "9906672642"
    )
    @Pattern(regexp = "($|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String mobileNumber;



    private  AccountsDto accountsDto;


}
