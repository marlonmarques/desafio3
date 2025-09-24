package com.desafio3.desafio.dto;

import java.time.LocalDate;

import com.desafio3.desafio.entities.Client;

import jakarta.validation.constraints.*;

public class ClientDTO {

    private Long id;
    @NotBlank(message = "Campo requerido")
    private String name;
    private String cpf;
    private Double income;
    private LocalDate birthDate;
    private Integer children;


    public ClientDTO() {
    }


    public ClientDTO(Client entity) {
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        income = entity.getIncome();
        birthDate = entity.getBirthDate();
        children = entity.getChildren();
    }


    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public Double getIncome() {
        return this.income;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public Integer getChildren() {
        return this.children;
    }


}
