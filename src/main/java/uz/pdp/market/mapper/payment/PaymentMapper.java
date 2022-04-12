package uz.pdp.market.mapper.payment;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.market.dto.payment.PaymentCreateDto;
import uz.pdp.market.dto.payment.PaymentDto;
import uz.pdp.market.dto.payment.PaymentUpdateDto;
import uz.pdp.market.entity.payment.Payment;
import uz.pdp.market.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface PaymentMapper extends BaseMapper<Payment, PaymentDto, PaymentCreateDto, PaymentUpdateDto> {
    @Override
    PaymentDto toDto(Payment payment);

    @Override
    List<PaymentDto> toDto(List<Payment> e);

    @Override
    Payment fromCreateDto(final PaymentCreateDto paymentCreateDto);

    @Override
    Payment fromUpdateDto(final PaymentUpdateDto paymentUpdateDto);
}
