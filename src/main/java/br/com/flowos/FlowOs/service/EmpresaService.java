package br.com.flowos.FlowOs.service;

import br.com.flowos.FlowOs.dto.EmpresaRequestDto;
import br.com.flowos.FlowOs.dto.EmpresaResponseDTO;
import br.com.flowos.FlowOs.model.Empresa;
import br.com.flowos.FlowOs.repository.EmpresaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Transactional
    public EmpresaResponseDTO criar(EmpresaRequestDto dto) {
        Empresa empresa = new Empresa();
        empresa.setCnpj(dto.getCnpj());
        empresa.setNome(dto.getNome());
        empresa.setTelefone(dto.getTelefone());
        empresa.setEmail(dto.getEmail());
        empresa.setEndereco(dto.getEndereco());

        Empresa salva = empresaRepository.save(empresa);
        EmpresaResponseDTO empresaResponseDTO = new EmpresaResponseDTO();
        empresaResponseDTO.setId(salva.getId());
        empresaResponseDTO.setNome(salva.getNome());
        return empresaResponseDTO;
    }
}
