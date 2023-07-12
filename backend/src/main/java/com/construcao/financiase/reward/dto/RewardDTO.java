package com.construcao.financiase.reward.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RewardDTO {

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String description;

    @NotNull
    @Positive
    @Min(value = 1)
    private Integer minValue;

    @NotNull
    @Future
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate expectedDeliveryDate;

}
