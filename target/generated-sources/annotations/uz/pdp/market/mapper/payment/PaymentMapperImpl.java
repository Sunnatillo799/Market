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
    date = "2022-04-04T22:48:27+0500",
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

        return payment;
    }

    @Override
    public Payment fromUpdateDto(PaymentUpdateDto paymentUpdateDto) {
        if ( paymentUpdateDto == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setId( paymentUpdateDto.getId() );

        return payment;
    }
}
