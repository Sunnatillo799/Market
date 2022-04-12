package uz.pdp.market.repository.sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.market.entity.sales.Sales;
import uz.pdp.market.repository.AbstractRepository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long>, AbstractRepository {
}
