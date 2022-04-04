package uz.pdp.market.controller.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.market.controller.AbstractController;
import uz.pdp.market.dto.customer.CustomerCreateDto;
import uz.pdp.market.entity.customer.Customer;
import uz.pdp.market.response.Response;
import uz.pdp.market.service.customer.CustomerService;

@RestController
public class CustomerController extends AbstractController<CustomerService> {

    public CustomerController(CustomerService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/customer/add", method = RequestMethod.POST)
    public ResponseEntity<Response> add(@RequestBody CustomerCreateDto customerCreateDto) {
        Boolean bool = service.add(customerCreateDto);
        if (bool) {
            return ResponseEntity.ok(new Response("This customer already exist", 409));
        }
        return ResponseEntity.ok(new Response("Customer successfully added", 200));
    }

    @RequestMapping(value = PATH + "/customer/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Successfully deleted");
    }

}
