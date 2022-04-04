package uz.pdp.market.repository.role;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.market.entity.role.Role;
import uz.pdp.market.repository.AbstractRepository;

public interface RoleRepository extends JpaRepository<Role,Long>, AbstractRepository {
}
