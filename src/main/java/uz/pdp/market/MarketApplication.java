package uz.pdp.market;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.pdp.market.entity.auth.AuthUser;
import uz.pdp.market.entity.role.Role;
import uz.pdp.market.properties.OpenApiProperties;
import uz.pdp.market.properties.ServerProperties;
import uz.pdp.market.repository.auth.AuthUserRepository;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties({
        OpenApiProperties.class,
        ServerProperties.class
})
@OpenAPIDefinition
@RequiredArgsConstructor
public class MarketApplication {
    private final AuthUserRepository authuserRepository;
    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(MarketApplication.class, args);
    }

/*    @Bean
    CommandLineRunner runner() {
        return (args) -> {
            authuserRepository.deleteAll();
            String encode = passwordEncoder.encode("123");

            AuthUser admin = AuthUser.childBuilder()
                    .username("admin")
                    .password(encode)
                    .firstName("Sunnatillo")
                    .lastName("Sulxonov")
                    .phone("+998999975799")
//                    .role())
                    .build();
            authuserRepository.save(admin);
        };
    }*/
}
