package com.desafio3.desafio.service.excepitos;

public class ResourceNotFoundExcepiton extends RuntimeException {

    public ResourceNotFoundExcepiton(String msg){
        super(msg);
    }
}
