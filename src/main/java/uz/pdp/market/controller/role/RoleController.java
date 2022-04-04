package uz.pdp.market.controller.role;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.market.controller.AbstractController;
import uz.pdp.market.dto.role.RoleCreateDto;
import uz.pdp.market.response.Response;
import uz.pdp.market.service.role.RoleService;

@RestController
public class RoleController extends AbstractController<RoleService> {

    public RoleController(RoleService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/role/add", method = RequestMethod.POST)
    public ResponseEntity<Response> add(@RequestBody RoleCreateDto roleCreateDto) {
        return service.add(roleCreateDto);
    }

}
