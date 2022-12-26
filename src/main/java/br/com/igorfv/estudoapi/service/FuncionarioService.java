package br.com.igorfv.estudoapi.service;

import br.com.igorfv.estudoapi.DTOs.EmpresaDto;
import br.com.igorfv.estudoapi.DTOs.FuncionarioDto;
import br.com.igorfv.estudoapi.exception.NegocioException;
import br.com.igorfv.estudoapi.repository.EmpresaRepository;
import br.com.igorfv.estudoapi.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private EmpresaRepository empresaRepository;

    @Transactional
    public FuncionarioDto salvar(FuncionarioDto funcionarioDto){
        EmpresaDto empresa = empresaRepository.findById(funcionarioDto.getEmpresa().getId())
                .orElseThrow(() -> new NegocioException("Empresa não encontrada"));

        funcionarioDto.setEmpresa(empresa);


        return funcionarioRepository.save(funcionarioDto);
    }

    @Transactional
    public void excluir(Long funcionarioId){
        funcionarioRepository.deleteById(funcionarioId);
    }

}
