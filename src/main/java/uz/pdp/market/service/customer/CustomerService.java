package uz.pdp.market.service.customer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.market.dto.customer.CustomerCreateDto;
import uz.pdp.market.dto.customer.CustomerUpdateDto;
import uz.pdp.market.entity.customer.Customer;
import uz.pdp.market.mapper.customer.CustomerMapper;
import uz.pdp.market.repository.customer.CustomerRepository;
import uz.pdp.market.response.Response;
import uz.pdp.market.service.AbstractService;
import uz.pdp.market.validator.customer.CustomerValidator;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService extends AbstractService<CustomerRepository, CustomerMapper, CustomerValidator> {

    protected CustomerService(CustomerRepository repository, @Qualifier("customerMapperImpl") CustomerMapper mapper, CustomerValidator validator) {
        super(repository, mapper, validator);
    }


    public Boolean add(CustomerCreateDto customerCreateDto) {
        Customer customer = mapper.fromCreateDto(customerCreateDto);
        Boolean aBoolean = repository.existsByEmailAndUsername(customerCreateDto.getEmail(), customerCreateDto.getUsername());
        if (aBoolean)
            return true;
        repository.save(customer);
        return false;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Customer get(Long id) {
        Optional<Customer> byId = repository.findById(id);
        return byId.orElse(null);
    }

    public ResponseEntity<Response> update(Long id, CustomerUpdateDto customerUpdateDto) {
        Optional<Customer> customerOptional = repository.findById(id);
        if (customerOptional.isEmpty()) {
            return ResponseEntity.status(404).body((new Response("Customer not found", 404)));
        }
        Customer customerDto = mapper.fromUpdateDto(customerUpdateDto);
        Customer customer = customerOptional.get();

        customer.setAddress(customerDto.getAddress());
        customer.setEmail(customerDto.getEmail());
        customer.setName(customerDto.getName());
        customer.setPhone(customerDto.getPhone());
        customer.setPassword(customerDto.getPassword());
        customer.setUsername(customerDto.getUsername());
        return ResponseEntity.ok(new Response("Successfully update", 200));
    }

    public List<Customer> getAll() {
        return repository.findAll();
    }
}
