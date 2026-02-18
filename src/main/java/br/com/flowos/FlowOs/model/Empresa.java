package br.com.flowos.FlowOs.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    @SequenceGenerator(name = "seq",sequenceName = "sequencia",allocationSize = 1)
    private Long id;

    private String cnpj;
    private String telefone;
    private String endereco;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
}
