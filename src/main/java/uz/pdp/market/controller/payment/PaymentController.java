package uz.pdp.market.controller.payment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.market.controller.AbstractController;
import uz.pdp.market.dto.payment.PaymentCreateDto;
import uz.pdp.market.response.Response;
import uz.pdp.market.service.payment.PaymentService;

import javax.xml.bind.ValidationException;

@RestController
public class PaymentController extends AbstractController<PaymentService> {

    public PaymentController(PaymentService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/payment/create", method = RequestMethod.POST)
    public ResponseEntity<Response> create(@RequestBody PaymentCreateDto paymentCreateDto) throws ValidationException {
        return service.create(paymentCreateDto);
    }

}
