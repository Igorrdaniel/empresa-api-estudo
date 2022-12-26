package br.com.igorfv.estudoapi.DTOs;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "Funcionario")
public class FuncionarioDto {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private EmpresaDto empresa;

    @NotBlank
    @Size(max = 60)
    private String nome;

    @NotBlank
    @Size(max = 60)
    private String sobrenome;

    @NotBlank
    @Email
    private String email;


}
