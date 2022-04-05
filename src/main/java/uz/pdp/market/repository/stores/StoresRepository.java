package uz.pdp.market.repository.stores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.market.entity.stores.Stores;
import uz.pdp.market.repository.AbstractRepository;

@Repository
public interface StoresRepository extends JpaRepository<Stores, Long>, AbstractRepository {
}
