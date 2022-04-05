package uz.pdp.market.controller.role;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.market.controller.AbstractController;
import uz.pdp.market.dto.role.RoleCreateDto;
import uz.pdp.market.dto.role.RoleUpdateDto;
import uz.pdp.market.entity.role.Role;
import uz.pdp.market.response.Response;
import uz.pdp.market.service.role.RoleService;

import java.util.List;

@RestController
public class RoleController extends AbstractController<RoleService> {

    public RoleController(RoleService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/role/add", method = RequestMethod.POST)
    public ResponseEntity<Response> add(@RequestBody RoleCreateDto roleCreateDto) {
        return service.add(roleCreateDto);
    }

    @RequestMapping(value = PATH + "/role/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(new Response("Successfully", 204));
    }

    @RequestMapping(value = PATH + "/role/update", method = RequestMethod.PUT)
    public ResponseEntity<Response> update(@RequestBody RoleUpdateDto roleUpdateDto) {
        service.update(roleUpdateDto);
        return ResponseEntity.ok(new Response("Successfully updated", 205));
    }

    @RequestMapping(value = PATH + "/role/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Role>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

}
