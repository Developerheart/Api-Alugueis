package br.com.aluguel.robert.imoveis.repository;

import br.com.aluguel.robert.imoveis.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, String> {

	@Query(value = "SELECT * FROM Proprietario WHERE NOME LIKE :nome", nativeQuery = true)
	List<Proprietario> buscaPorNome(@Param("nome") String nome);
}
