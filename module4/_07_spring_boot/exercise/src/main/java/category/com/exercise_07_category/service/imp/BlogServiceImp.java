package category.com.exercise_07_category.service.imp;

import category.com.exercise_07_category.model.Blog;
import category.com.exercise_07_category.model.dto.BlogDTO;
import category.com.exercise_07_category.repository.BlogRepository;
import category.com.exercise_07_category.service.BlogDetailService;
import category.com.exercise_07_category.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImp implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private BlogDetailService blogDetailService;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAllBlog();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void edit(String tittle, int id) {
        blogRepository.edit(tittle.toUpperCase(), id);
    }

    @Override
    public void save(BlogDTO blogDTO) {
        blogDetailService.create(blogDTO.getContent());
        int blog_detail_id = blogDetailService.findAll().size();
        blogRepository.create(blogDTO.getTittle().toUpperCase(), blog_detail_id, blogDTO.getCategory());
    }
}
