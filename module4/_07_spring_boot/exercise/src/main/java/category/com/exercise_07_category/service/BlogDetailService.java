package category.com.exercise_07_category.service;

import category.com.exercise_07_category.model.BlogDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogDetailService {
    List<BlogDetail> findAll();

    BlogDetail findById(int id);

    void edit(String content, int id);

    BlogDetail findByIdBlogDetail(int id);

    void create(String content);
}
