package uz.pdp.market.service.role;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.market.dto.role.RoleCreateDto;
import uz.pdp.market.dto.role.RoleUpdateDto;
import uz.pdp.market.entity.role.Role;
import uz.pdp.market.mapper.role.RoleMapper;
import uz.pdp.market.repository.role.RoleRepository;
import uz.pdp.market.response.Response;
import uz.pdp.market.service.AbstractService;
import uz.pdp.market.validator.role.RoleValidator;

import java.util.List;

@Service
public class RoleService extends AbstractService<RoleRepository, RoleMapper, RoleValidator> {
    protected RoleService(RoleRepository repository, @Qualifier("roleMapperImpl") RoleMapper mapper, RoleValidator validator) {
        super(repository, mapper, validator);
    }

    public ResponseEntity<Response> add(RoleCreateDto roleCreateDto) {
        Role role = mapper.fromCreateDto(roleCreateDto);
        Role save = repository.save(role);
        if (!save.getName().isBlank()) return ResponseEntity.ok(new Response("Successfully added", 200));
        return ResponseEntity.ok(new Response("Forbidden", 403));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void update(RoleUpdateDto roleUpdateDto) {
        Role role = mapper.fromUpdateDto(roleUpdateDto);
        repository.save(role);
    }

    public List<Role> getAll() {
        return repository.findAll();
    }
}
