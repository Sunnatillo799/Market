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
import uz.pdp.market.dto.auth.AuthUserDto;
import uz.pdp.market.dto.auth.RegisterDto;
import uz.pdp.market.dto.auth.SessionDto;
import uz.pdp.market.dto.customer.CustomerCreateDto;
import uz.pdp.market.entity.auth.AuthUser;
import uz.pdp.market.properties.ServerProperties;
import uz.pdp.market.repository.auth.AuthUserRepository;
import uz.pdp.market.repository.language.LanguageRepository;
import uz.pdp.market.repository.role.RoleRepository;
import uz.pdp.market.repository.status.StatusRepository;
import uz.pdp.market.service.BaseService;

import java.io.ByteArrayInputStream;
import java.util.Optional;

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

    public Boolean register(RegisterDto registerDto) {
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
                .build();
        authUserRepository.save(authUser);
        return true;
    }

    public void delete(Long id) {
        Optional<AuthUser> authUser = authUserRepository.findByIdAndDeletedFalse(id);
        authUserRepository.delete(authUser.get());
    }

    public void get(Long id) {
        authUserRepository.getById(id);
    }

    public Boolean add(CustomerCreateDto customerCreateDto) {

        return true;
    }
}
