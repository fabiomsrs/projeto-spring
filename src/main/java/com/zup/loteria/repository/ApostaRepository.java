package com.zup.loteria.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.loteria.modelo.Aposta;

public interface ApostaRepository extends JpaRepository<Aposta, Long>{

	List<Aposta> findByEmailOrderByCreatedAtDesc(String email);

	List<Aposta> findByEmailAndNumero(String email, String numero);

}
