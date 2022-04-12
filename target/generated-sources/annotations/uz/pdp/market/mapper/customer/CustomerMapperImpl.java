package uz.pdp.market.mapper.customer;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.pdp.market.dto.customer.CustomerCreateDto;
import uz.pdp.market.dto.customer.CustomerDto;
import uz.pdp.market.dto.customer.CustomerUpdateDto;
import uz.pdp.market.entity.customer.Customer;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-12T09:48:57+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto toDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        return customerDto;
    }

    @Override
    public List<CustomerDto> toDto(List<Customer> e) {
        if ( e == null ) {
            return null;
        }

        List<CustomerDto> list = new ArrayList<CustomerDto>( e.size() );
        for ( Customer customer : e ) {
            list.add( toDto( customer ) );
        }

        return list;
    }

    @Override
    public Customer fromCreateDto(CustomerCreateDto customerCreateDto) {
        if ( customerCreateDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( customerCreateDto.getName() );
        customer.setPhone( customerCreateDto.getPhone() );
        customer.setEmail( customerCreateDto.getEmail() );
        customer.setAddress( customerCreateDto.getAddress() );
        customer.setUsername( customerCreateDto.getUsername() );
        customer.setPassword( customerCreateDto.getPassword() );

        return customer;
    }

    @Override
    public Customer fromUpdateDto(CustomerUpdateDto customerUpdateDto) {
        if ( customerUpdateDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerUpdateDto.getId() );
        customer.setName( customerUpdateDto.getName() );
        customer.setPhone( customerUpdateDto.getPhone() );
        customer.setEmail( customerUpdateDto.getEmail() );
        customer.setAddress( customerUpdateDto.getAddress() );
        customer.setUsername( customerUpdateDto.getUsername() );
        customer.setPassword( customerUpdateDto.getPassword() );

        return customer;
    }
}
