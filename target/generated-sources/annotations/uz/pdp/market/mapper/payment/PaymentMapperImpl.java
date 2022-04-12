package uz.pdp.market.mapper.payment;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.pdp.market.dto.payment.PaymentCreateDto;
import uz.pdp.market.dto.payment.PaymentDto;
import uz.pdp.market.dto.payment.PaymentUpdateDto;
import uz.pdp.market.entity.payment.Payment;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-12T10:24:02+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public PaymentDto toDto(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentDto paymentDto = new PaymentDto();

        return paymentDto;
    }

    @Override
    public List<PaymentDto> toDto(List<Payment> e) {
        if ( e == null ) {
            return null;
        }

        List<PaymentDto> list = new ArrayList<PaymentDto>( e.size() );
        for ( Payment payment : e ) {
            list.add( toDto( payment ) );
        }

        return list;
    }

    @Override
    public Payment fromCreateDto(PaymentCreateDto paymentCreateDto) {
        if ( paymentCreateDto == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setAmount( paymentCreateDto.getAmount() );
        payment.setDescription( paymentCreateDto.getDescription() );

        return payment;
    }

    @Override
    public Payment fromUpdateDto(PaymentUpdateDto paymentUpdateDto) {
        if ( paymentUpdateDto == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setId( paymentUpdateDto.getId() );
        payment.setAmount( paymentUpdateDto.getAmount() );
        payment.setDescription( paymentUpdateDto.getDescription() );

        return payment;
    }
}
