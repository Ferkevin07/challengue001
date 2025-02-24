package com.ntt_data.service003.model.dto;

public record BaseReponse(String[] errorsMessages) {

    public boolean hasError(){
        return errorsMessages!= null && errorsMessages.length > 0;
    }
}
