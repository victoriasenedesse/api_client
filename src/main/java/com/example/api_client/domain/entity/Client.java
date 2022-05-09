package com.example.api_client.domain.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address endereco;

    @Column(name="cpf")
    @NotBlank(message = "Cpf é obrigatório")
    @CPF()
    String cpf;

    @Column(name="nome")
    @NotBlank(message = "Nome é obrigatório")
    @Length(message="Nome com no máximo 50 caracteres.",max=50)
    String nome;

    @Column(name="sexo")
    @NotBlank(message = "Sexo é obrigatório")
    @Length(message="Sexo inválod (obs: responda apenas com F ou M).",max=1)
    String sexo;

    @Column(name="nascimento")
    @NotBlank(message = "Data de nascimento é obrigatória")
    String nascimento;
}
