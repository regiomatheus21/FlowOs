package br.com.flowos.FlowOs.service;


import br.com.flowos.FlowOs.model.Customer;
import br.com.flowos.FlowOs.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository repository;

    public void adicionar(Customer customer) {
           repository.save(customer);
    }

    public Optional<Customer> buscarCustomer(Long id) {
       return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
