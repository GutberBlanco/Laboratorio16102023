package bo.edu.ucb.msclientpago.dao.repository;



import bo.edu.ucb.msclientpago.dao.entity.PaymentDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<PaymentDAO, Long> {
    List<PaymentDAO> findByIdUser(Long userId);
}
