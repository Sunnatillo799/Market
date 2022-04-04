package uz.pdp.market.controller.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.market.controller.AbstractController;
import uz.pdp.market.dto.auth.AuthUserDto;
import uz.pdp.market.dto.auth.RegisterDto;
import uz.pdp.market.dto.auth.SessionDto;
import uz.pdp.market.dto.customer.CustomerCreateDto;
import uz.pdp.market.response.Response;
import uz.pdp.market.service.auth.AuthUserService;

import javax.servlet.http.PushBuilder;

@RestController
public class AuthController extends AbstractController<AuthUserService> {

    public AuthController(AuthUserService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/auth/token", method = RequestMethod.POST)
    public ResponseEntity<SessionDto> getToken(@RequestBody AuthUserDto authUserDto) {
        return service.getToken(authUserDto);
    }

    @RequestMapping(value = PATH + "/auth/register", method = RequestMethod.POST)
    public Response register(@RequestBody RegisterDto registerDto) {
        Boolean register = service.register(registerDto);
        Response response = new Response();
        if (register) {
            response.setCode(200);
            response.setMessage("Successfully register");
        } else {
            response.setCode(403);
            response.setMessage("Failed register");
        }
        return response;
    }

    @RequestMapping(value = PATH + "/auth/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        service.delete(id);
        Response response = new Response();
        response.setMessage("Successfully deleted user");
        response.setCode(200);
        return ResponseEntity.ok().body(response);
    }
}
