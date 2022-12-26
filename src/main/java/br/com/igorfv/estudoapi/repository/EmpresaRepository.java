package br.com.igorfv.estudoapi.repository;

import br.com.igorfv.estudoapi.DTOs.EmpresaDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<EmpresaDto, Long> {

}
