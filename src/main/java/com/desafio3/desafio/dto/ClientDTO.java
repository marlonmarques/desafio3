package com.desafio3.desafio.dto;

import java.time.LocalDate;

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


    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
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
