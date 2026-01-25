package br.com.flowos.FlowOs.controller;

import br.com.flowos.FlowOs.model.Customer;
import br.com.flowos.FlowOs.service.CustomerService;
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
@RequestMapping("v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void adicinar (@RequestBody Customer customer){
        customerService.adicionar(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> buscarCustomer(@PathVariable Long id){
       Optional<Customer> customer = customerService.buscarCustomer(id);
       if(customer.isPresent()){
           return ResponseEntity.ok().body(customer.get());
       }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar (@PathVariable Long id){
        customerService.deletar(id);
    }


}
