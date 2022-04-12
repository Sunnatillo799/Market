package uz.pdp.market.controller.sales;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.market.controller.AbstractController;
import uz.pdp.market.dto.sales.SalesCreateDto;
import uz.pdp.market.response.Response;
import uz.pdp.market.service.sales.SalesService;

@RestController
public class SalesController extends AbstractController<SalesService> {

    public SalesController(SalesService service) {
        super(service);
    }

    public ResponseEntity<Response> create(@RequestBody SalesCreateDto salesCreateDto){
        return service.create(salesCreateDto);
    }

}
