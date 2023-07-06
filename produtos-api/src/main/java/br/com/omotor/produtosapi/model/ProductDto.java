package br.com.omotor.produtosapi.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDto {

    @NotBlank
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private Integer quantity;

    @NotEmpty
    private Byte[] image;

}
