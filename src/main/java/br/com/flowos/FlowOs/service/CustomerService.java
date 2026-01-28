package br.com.flowos.FlowOs.service;


import br.com.flowos.FlowOs.dto.CustomerDto;
import br.com.flowos.FlowOs.model.Customer;
import br.com.flowos.FlowOs.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository repository;

    @Transactional
    public CustomerDto adicionar(Customer customer) {
        if(repository.existsByCpf(customer.getCpf())){
            throw new IllegalArgumentException("Cpf ja existe na base!");
        }
        Customer customerSave = repository.save(customer);
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customerSave.getId());
        customerDto.setNome(customerSave.getName());
        return customerDto;
    }

    public Optional<Customer> buscarCustomer(Long id) {
       return repository.findById(id);
    }

    @Transactional
    public boolean deletar(Long id) {
        if( !buscarCustomer(id).isPresent()){return false;}
        repository.deleteById(id);
        return true;
    }
}
