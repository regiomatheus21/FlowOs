package br.com.flowos.FlowOs.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class EmpresaRequestDto {
    private String cnpj;
    private String telefone;
    private String endereco;
    private String nome;
    private String email;
}
