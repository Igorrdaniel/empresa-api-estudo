package br.com.igorfv.estudoapi.service;

import br.com.igorfv.estudoapi.DTOs.EmpresaDto;
import br.com.igorfv.estudoapi.exception.NegocioException;
import br.com.igorfv.estudoapi.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Transactional
    public EmpresaDto salvar(EmpresaDto empresaDto){
        return empresaRepository.save(empresaDto);
    }

    @Transactional
    public void excluir(Long empresaId){
        empresaRepository.deleteById(empresaId);
    }
}
