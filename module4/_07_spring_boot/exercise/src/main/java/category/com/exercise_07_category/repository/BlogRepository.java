package category.com.exercise_07_category.repository;

import category.com.exercise_07_category.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "SELECT * FROM blog WHERE status_delete <> 1", nativeQuery = true)
    List<Blog> findAllBlog();

    @Query(value = "SELECT * FROM blog WHERE id = :idBlog", nativeQuery = true)
    Blog findById(@Param("idBlog") int id);

    @Modifying
    @Query(value = "UPDATE blog SET status_delete = 1 WHERE id = :idBlog", nativeQuery = true)
    void deleteById(@Param("idBlog") int id);

    @Modifying
    @Query(value = "INSERT INTO blog(status_delete, tittle, blog_detail_id, category_id)" +
            " VALUE (0, :tittle, :blogDetailId, :categoryId)",
            nativeQuery = true)
    void create(@Param("tittle") String tittle,
                @Param("blogDetailId") int blogDetailId,
                @Param("categoryId") int categoryId);

    @Modifying
    @Query(value = "UPDATE blog SET tittle = :tittleBlog WHERE  id = :idBlog", nativeQuery = true)
    void edit(@Param("tittleBlog") String tittle, @Param("idBlog") int idBlog);
}
