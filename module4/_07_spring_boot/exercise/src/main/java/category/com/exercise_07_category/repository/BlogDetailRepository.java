package category.com.exercise_07_category.repository;

import category.com.exercise_07_category.model.BlogDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface BlogDetailRepository extends JpaRepository<BlogDetail, Integer> {

    @Query(value = "SELECT * FROM blog_detail", nativeQuery = true)
    List<BlogDetail> findAllBlogDetail();

    @Query(value = "SELECT * FROM blog_detail WHERE id = :idDetail", nativeQuery = true)
    BlogDetail findByIdBlogDetail(@Param("idDetail") int id);

    @Modifying
    @Query(value = "UPDATE blog_detail SET content = :contentBlog WHERE  id = :idBlog", nativeQuery = true)
    void edit(@Param("contentBlog") String content, @Param("idBlog") int idBlog);

    @Modifying
    @Query(value = "INSERT INTO blog_detail(content) VALUE (:content)", nativeQuery = true)
    void create(@Param("content") String content);
}
