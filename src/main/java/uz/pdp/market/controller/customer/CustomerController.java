package uz.pdp.market.controller.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.market.controller.AbstractController;
import uz.pdp.market.dto.auth.SessionDto;
import uz.pdp.market.dto.customer.CustomerCreateDto;
import uz.pdp.market.dto.customer.CustomerUpdateDto;
import uz.pdp.market.entity.customer.Customer;
import uz.pdp.market.response.Response;
import uz.pdp.market.service.customer.CustomerService;

import java.util.List;

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

    @RequestMapping(value = PATH + "/customer/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Response> update(@PathVariable Long id, @RequestBody CustomerUpdateDto customerUpdateDto) {
        return service.update(id, customerUpdateDto);
    }


    @RequestMapping(value = PATH + "/customer/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Successfully deleted");
    }

@RequestMapping(value = PATH + "/customer/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> getById(@PathVariable Long id) {
        Customer customer = service.get(id);
        return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.status(404).body(null);
    }

    @RequestMapping(value = PATH + "/customer/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

}
