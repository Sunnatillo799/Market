package uz.pdp.market.service.auth;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.market.dto.auth.AuthUserDto;
import uz.pdp.market.dto.auth.RegisterDto;
import uz.pdp.market.dto.auth.SessionDto;
import uz.pdp.market.dto.customer.CustomerCreateDto;
import uz.pdp.market.entity.auth.AuthUser;
import uz.pdp.market.entity.fileUpload.FileUpload;
import uz.pdp.market.entity.role.Role;
import uz.pdp.market.properties.ServerProperties;
import uz.pdp.market.repository.auth.AuthUserRepository;
import uz.pdp.market.repository.file.FileUploadRepository;
import uz.pdp.market.repository.language.LanguageRepository;
import uz.pdp.market.repository.role.RoleRepository;
import uz.pdp.market.repository.status.StatusRepository;
import uz.pdp.market.response.Response;
import uz.pdp.market.service.BaseService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthUserService implements UserDetailsService, BaseService {

    private final AuthUserRepository authUserRepository;
    private final ServerProperties serverProperties;
    private final ObjectMapper objectMapper;
    private final RoleRepository roleRepository;
    private final StatusRepository statusRepository;
    private final LanguageRepository languageRepository;
    private final PasswordEncoder passwordEncoder;
    private final FileUploadRepository fileUploadRepository;

    private static final String PATH = "upload";
    private Long fileId;

    public ResponseEntity<SessionDto> getToken(AuthUserDto authUserDto) {
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(serverProperties.getServerUrl() + "/api/login");
            byte[] bytes = objectMapper.writeValueAsBytes(authUserDto);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            httpPost.addHeader("Content-Type", "application/json");
            httpPost.setEntity(new InputStreamEntity(byteArrayInputStream));
            HttpResponse response = httpClient.execute(httpPost);
            JsonNode jsonNode = objectMapper.readTree(EntityUtils.toString(response.getEntity()));
            if (jsonNode.has("success") && jsonNode.get("success").asBoolean()) {
                JsonNode node = jsonNode.get("data");
                SessionDto sessionDto = objectMapper.readValue(node.toString(), SessionDto.class);
                return new ResponseEntity<>(sessionDto, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return null;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser user = authUserRepository.findByUsernameAndDeletedFalse(username).orElseThrow(() -> {
            throw new UsernameNotFoundException("User not found");
        });
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getAuthority())
                .accountLocked(false)
                .accountExpired(false)
                .disabled(false)
                .credentialsExpired(false)
                .build();
    }

    public Response register(RegisterDto registerDto, MultipartHttpServletRequest request) throws IOException {

        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        if (file != null) {
            String originalFilename = file.getOriginalFilename();
            String contentType = file.getContentType();
            String[] split = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
            String name = UUID.randomUUID() + "." + split[split.length - 1];
            long size = file.getSize();

            FileUpload fileUpload = new FileUpload(name, originalFilename, size, contentType);


            FileUpload saveFileUpload = fileUploadRepository.save(fileUpload);
            fileId = saveFileUpload.getId();
            Path path = Paths.get(PATH + "/" + name);
            Files.copy(file.getInputStream(), path);
        }


        Response response = new Response();
        try {
            AuthUser authUser = AuthUser.childBuilder()
                    .firstName(registerDto.getFirstName())
                    .lastName(registerDto.getLastName())
                    .password(passwordEncoder.encode(registerDto.getPassword()))
                    .username(registerDto.getUsername())
                    .email(registerDto.getEmail())
                    .role(roleRepository.getById(registerDto.getRole_id()))
                    .phone(registerDto.getPhone_number())
//                .status(statusRepository.getById(1L))
                    .language(languageRepository.getById(registerDto.getLanguage_id()))
                    .fileId(fileId)
                    .build();
            authUserRepository.save(authUser);

            response.setCode(200);
            response.setMessage("Successfully register");
        } catch (Exception e) {
            response.setCode(403);
            response.setMessage("Failed register");
        }
        return response;
    }

    public void delete(Long id) {
        Optional<AuthUser> authUser = authUserRepository.findByIdAndDeletedFalse(id);
        authUserRepository.delete(authUser.get());
    }

    public Boolean add(CustomerCreateDto customerCreateDto) {

        return true;
    }

    public Response updateRole(Long userId, Long roleId) {
        Optional<AuthUser> userOptional = authUserRepository.findById(userId);
        Optional<Role> roleOptional = roleRepository.findById(roleId);
        if (!userOptional.isPresent()) {
            return new Response("User not found", 404);
        }
        if (!roleOptional.isPresent()) {
            return new Response("Role not found", 404);
        }
        AuthUser authUser = userOptional.get();
        authUser.setRole(roleOptional.get());
        authUserRepository.save(authUser);

        return new Response("Successfully update", 205);
    }

    public ResponseEntity<AuthUser> userDetails(Long id) {
        Optional<AuthUser> byId = authUserRepository.findById(id);
        if (byId.isEmpty())
            ResponseEntity.status(404).body("User not found");

        AuthUser authUser = byId.get();
        return ResponseEntity.ok(authUser);
    }
}
