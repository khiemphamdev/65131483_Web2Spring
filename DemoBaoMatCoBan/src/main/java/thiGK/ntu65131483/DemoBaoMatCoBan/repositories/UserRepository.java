package thiGK.ntu65131483.DemoBaoMatCoBan.repositories;



import thiGK.ntu65131483.DemoBaoMatCoBan.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}