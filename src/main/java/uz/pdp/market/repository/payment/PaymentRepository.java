package uz.pdp.market.repository.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.market.entity.payment.Payment;
import uz.pdp.market.repository.AbstractRepository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>, AbstractRepository {
}
