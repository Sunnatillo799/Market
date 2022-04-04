package uz.pdp.market.service.customer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uz.pdp.market.dto.customer.CustomerCreateDto;
import uz.pdp.market.entity.customer.Customer;
import uz.pdp.market.mapper.customer.CustomerMapper;
import uz.pdp.market.repository.customer.CustomerRepository;
import uz.pdp.market.service.AbstractService;
import uz.pdp.market.validator.customer.CustomerValidator;

import javax.transaction.Transactional;

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
}
