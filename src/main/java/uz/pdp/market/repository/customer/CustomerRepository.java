package uz.pdp.market.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.market.entity.customer.Customer;
import uz.pdp.market.repository.AbstractRepository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, AbstractRepository {
    Boolean existsByEmailAndUsername(String email, String username);
}
