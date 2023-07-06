package br.com.omotor.produtosapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReturnMessage {

    private String message;

    private Object body;
}
