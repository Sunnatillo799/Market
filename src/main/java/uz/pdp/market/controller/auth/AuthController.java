package uz.pdp.market.controller.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.market.config.security.SecurityUtils;
import uz.pdp.market.controller.AbstractController;
import uz.pdp.market.dto.auth.AuthUserDto;
import uz.pdp.market.dto.auth.RegisterDto;
import uz.pdp.market.dto.auth.SessionDto;
import uz.pdp.market.dto.file.FileUploadDto;
import uz.pdp.market.entity.auth.AuthUser;
import uz.pdp.market.entity.fileUpload.FileUpload;
import uz.pdp.market.response.Response;
import uz.pdp.market.service.auth.AuthUserService;

import java.io.IOException;
import java.util.Optional;

@RestController
public class AuthController extends AbstractController<AuthUserService> {


    @Autowired
    public AuthController(AuthUserService service) {
        super(service);
    }

    @RequestMapping(value = PATH + "/auth/token", method = RequestMethod.POST)
    public ResponseEntity<SessionDto> getToken(@RequestBody AuthUserDto authUserDto) {
        return service.getToken(authUserDto);
    }


    @RequestMapping(value = PATH + "/currentUser", method = RequestMethod.GET)
    public Optional<String> getCurrentUsername() {
        return SecurityUtils.getCurrentUsername();
    }

    @RequestMapping(value = PATH + "/auth/userDetails/{id}", method = RequestMethod.GET)
    public ResponseEntity<AuthUser> getUserDetails(@PathVariable Long id) {
        return service.userDetails(id);
    }

    @RequestMapping(value = PATH + "/auth/file", method = RequestMethod.POST)
    public ResponseEntity<Response> fileUpload(@RequestParam(value = "file") MultipartFile multipartFile) {
        return ResponseEntity.ok(new Response("File", 200));
    }

    @PreAuthorize(value = "hasAnyAuthority('Admin')")
    @Operation(
            responses = {
                    @ApiResponse(responseCode = "401", description = "Unauthorized")
            }
    )
    @RequestMapping(value = PATH + "/auth/register", method = RequestMethod.POST)
    public Response register(@RequestBody RegisterDto registerDto, @RequestParam MultipartHttpServletRequest request) throws IOException {
        return service.register(registerDto, request);
    }

    @PreAuthorize(value = "hasAnyAuthority('Admin')")
    @Operation(
            responses = {
                    @ApiResponse(responseCode = "401", description = "Unauthorized")
            }
    )
    @RequestMapping(value = PATH + "/auth/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body(new Response("Successfully deleted user", 200));
    }

    @PreAuthorize(value = "hasAnyAuthority('Admin')")
    @Operation(
            responses = {
                    @ApiResponse(responseCode = "401", description = "Unauthorized")
            }
    )
    @RequestMapping(value = PATH + "/auth/updateRole/{userId}/{roleId}", method = RequestMethod.PUT)
    public ResponseEntity<Response> updateRole(@PathVariable Long userId, @PathVariable Long roleId) {
        return ResponseEntity.ok(service.updateRole(userId, roleId));
    }
}
