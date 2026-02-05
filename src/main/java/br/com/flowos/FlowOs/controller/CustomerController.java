package br.com.flowos.FlowOs.controller;

import br.com.flowos.FlowOs.dto.CustomerDto;
import br.com.flowos.FlowOs.model.Customer;
import br.com.flowos.FlowOs.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> adicinar (@Valid @RequestBody Customer customer){
        CustomerDto customerDto= customerService.adicionar(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> buscarCustomer(@PathVariable Long id){
      return customerService.buscarCustomer(id)
              .map(ResponseEntity::ok)
              .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id){
        customerService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
