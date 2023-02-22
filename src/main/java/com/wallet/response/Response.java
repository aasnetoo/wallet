package com.wallet.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    // Essa classe irá tratar todas as respostas da nossa API
    private T data; //resposta do upload, um wallet, um user -- SUCESSO NO DATA, ERRO NA LISTA DE ERRORS.
    private List<String> errors; //Qualquer erro que ocorra vamos colocar dentro de errors

    public List<String> getErrors(){
        if (this.errors == null){
            this.errors = new ArrayList<>();
        }
        return errors;
    }
}
