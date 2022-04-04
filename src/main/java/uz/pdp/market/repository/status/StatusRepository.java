package uz.pdp.market.repository.status;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.market.entity.status.Status;
import uz.pdp.market.repository.AbstractRepository;

public interface StatusRepository extends JpaRepository<Status, Long>, AbstractRepository {
}
