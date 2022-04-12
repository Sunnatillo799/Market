package uz.pdp.market.controller.stores;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.market.controller.AbstractController;
import uz.pdp.market.dto.stores.StoresCreateDto;
import uz.pdp.market.dto.stores.StoresUpdateDto;
import uz.pdp.market.entity.stores.Stores;
import uz.pdp.market.response.Response;
import uz.pdp.market.service.stores.StoresService;

import java.util.List;

@RestController
public class StoresController extends AbstractController<StoresService> {
    public StoresController(StoresService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/stores/create", method = RequestMethod.POST)
    public ResponseEntity<Response> create(@RequestBody StoresCreateDto storesCreateDto) {
        return ResponseEntity.ok(service.create(storesCreateDto));
    }

    @RequestMapping(value = PATH + "/stores/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @RequestMapping(value = PATH + "/stores/update", method = RequestMethod.PUT)
    public ResponseEntity<Response> update(StoresUpdateDto storesUpdateDto) {
        return ResponseEntity.ok(service.update(storesUpdateDto));
    }

    @RequestMapping(value = PATH + "/stores/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Stores>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @RequestMapping(value = PATH + "/stores/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Stores> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

}
