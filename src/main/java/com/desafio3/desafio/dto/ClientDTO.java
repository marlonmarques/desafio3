package com.desafio3.desafio.dto;

import java.time.LocalDate;

import com.desafio3.desafio.entities.Client;

import jakarta.validation.constraints.*;

public class ClientDTO {

    private Long id;
    @NotBlank(message = "Campo requerido")
    private String name;
    @NotBlank(message = "Campo requerido")
    @Size(min = 11, max = 14, message = "CPF deve ter entre 11 e 14 caracteres")
    private String cpf;
    @NotNull(message = "Campo requerido")
    @Positive(message = "O salário deve ser um valor positivo")
    private Double income;
    @NotNull(message = "Campo requerido")
    @PastOrPresent(message = "A data de nascimento deve ser no passado ou presente")
    private LocalDate birthDate;
    @NotNull(message = "Campo requerido")
    @Min(value = 0, message = "O número de filhos deve ser um valor positivo")
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
