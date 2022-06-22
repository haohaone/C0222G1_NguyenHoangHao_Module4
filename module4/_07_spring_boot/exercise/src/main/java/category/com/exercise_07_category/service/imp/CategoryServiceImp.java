package category.com.exercise_07_category.service.imp;

import category.com.exercise_07_category.model.Category;
import category.com.exercise_07_category.repository.CategoryRepository;
import category.com.exercise_07_category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAllCategory(pageable);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAllCategory();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        categoryRepository.delete(id);
    }

    @Override
    public void create(String category) {
        categoryRepository.create(category);
    }

    @Override
    public void edit(String category, int id) {
        categoryRepository.edit(category, id);
    }

    @Override
    public Page<Category> search(String category, Pageable pageable) {
        return categoryRepository.search("%" + category + "%", pageable);
    }
}
