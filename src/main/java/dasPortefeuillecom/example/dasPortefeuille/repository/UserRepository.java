package dasPortefeuillecom.example.dasPortefeuille.repository;

import dasPortefeuillecom.example.dasPortefeuille.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailAndPhoneNumber(String email, String phoneNumber);
}
