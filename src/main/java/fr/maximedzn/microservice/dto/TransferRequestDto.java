package fr.maximedzn.microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequestDto {
    private Long codeFrom;
    private Long codeTo;
    private double balance;
}
