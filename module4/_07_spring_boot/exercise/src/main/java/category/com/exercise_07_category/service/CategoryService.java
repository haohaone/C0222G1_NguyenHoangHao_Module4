package category.com.exercise_07_category.service;

import category.com.exercise_07_category.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    List<Category> findAll();

    Category findById(int id);

    void delete(int id);

    void create(String category);

    void edit(String category, int id);

    Page<Category> search(String category, Pageable pageable);
}
