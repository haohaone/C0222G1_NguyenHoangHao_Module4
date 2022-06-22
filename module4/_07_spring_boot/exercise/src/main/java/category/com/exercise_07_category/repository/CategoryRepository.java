package category.com.exercise_07_category.repository;

import category.com.exercise_07_category.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT * FROM category WHERE status_delete <> 1", nativeQuery = true)
    Page<Category> findAllCategory(Pageable pageable);

    @Query(value = "SELECT * FROM category WHERE status_delete <> 1", nativeQuery = true)
    List<Category> findAllCategory();

    @Query(value = "SELECT * FROM category WHERE id = :idCategory", nativeQuery = true)
    Category findById(@Param("idCategory") int id);

    @Modifying
    @Query(value = "UPDATE category SET status_delete = 1 WHERE id = :idCategory", nativeQuery = true)
    void delete(@Param("idCategory") int id);

    @Modifying
    @Query(value = "INSERT INTO category(category) VALUE (:category)", nativeQuery = true)
    void create(@Param("category") String category);

    @Modifying
    @Query(value = "UPDATE category SET category = :category WHERE id = :id", nativeQuery = true)
    void edit(@Param("category") String category, @Param("id") int id);

    @Query(value = "SELECT * FROM category WHERE status_delete <> 1 AND category LIKE :category", nativeQuery = true)
    Page<Category> search(@Param("category") String category, Pageable pageable);
}
