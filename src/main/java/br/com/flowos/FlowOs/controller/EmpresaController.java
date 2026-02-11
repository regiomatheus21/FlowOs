package br.com.flowos.FlowOs.controller;

import br.com.flowos.FlowOs.dto.EmpresaRequestDto;
import br.com.flowos.FlowOs.dto.EmpresaResponseDTO;
import br.com.flowos.FlowOs.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/empresas")
public class EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping()
    public ResponseEntity<EmpresaResponseDTO> criar (@RequestBody @Valid EmpresaRequestDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.criar(dto));
    }
}
