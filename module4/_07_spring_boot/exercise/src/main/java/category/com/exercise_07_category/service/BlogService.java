package category.com.exercise_07_category.service;

import category.com.exercise_07_category.model.Blog;
import category.com.exercise_07_category.model.dto.BlogDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {

    List<Blog> findAll();

    Blog findById(int id);

    void delete(int id);

    void edit(String tittle, int id);

    void save(BlogDTO blogDTO);

    List<Blog> search(String name);
}
