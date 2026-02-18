package br.com.flowos.FlowOs.controller;

import br.com.flowos.FlowOs.dto.EmpresaRequestDto;
import br.com.flowos.FlowOs.dto.EmpresaResponseDTO;
import br.com.flowos.FlowOs.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<EmpresaResponseDTO> criar (@RequestBody EmpresaRequestDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.criar(dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmpresaResponseDTO> getById(@PathVariable Long id){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(empresaService.getById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        empresaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
