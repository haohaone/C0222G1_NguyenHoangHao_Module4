package category.com.exercise_07_category.repository;

import category.com.exercise_07_category.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
