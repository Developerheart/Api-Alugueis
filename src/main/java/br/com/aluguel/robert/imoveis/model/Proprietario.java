package br.com.aluguel.robert.imoveis.model;

import br.com.aluguel.robert.imoveis.enums.EstadoCivil;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "PROPRIETARIO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Proprietario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CPF")
	private String cpf;

	@Column(name = "NOME_PROPRIETARIO")
	private String nome;

	@Column(name = "DATA_NASCIMENTO")
	private LocalDate dataNascimento;

	@Column(name = "ESTADO_CIVIL")
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Proprietario that = (Proprietario) o;
		return cpf != null && Objects.equals(cpf, that.cpf);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
