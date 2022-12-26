package br.com.igorfv.estudoapi.repository;

import br.com.igorfv.estudoapi.DTOs.FuncionarioDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioDto, Long> {
}
