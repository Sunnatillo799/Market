package uz.pdp.market.mapper.customer;

import org.mapstruct.Mapper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import uz.pdp.market.dto.customer.CustomerCreateDto;
import uz.pdp.market.dto.customer.CustomerDto;
import uz.pdp.market.dto.customer.CustomerUpdateDto;
import uz.pdp.market.entity.customer.Customer;
import uz.pdp.market.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface CustomerMapper extends BaseMapper<Customer, CustomerDto, CustomerCreateDto, CustomerUpdateDto> {

    @Override
    CustomerDto toDto(Customer customer);

    @Override
    List<CustomerDto> toDto(List<Customer> e);

    @Override
    Customer fromCreateDto(CustomerCreateDto customerCreateDto);

    @Override
    Customer fromUpdateDto(CustomerUpdateDto customerUpdateDto);
}