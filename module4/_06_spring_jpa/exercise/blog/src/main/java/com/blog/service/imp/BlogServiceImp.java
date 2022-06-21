package com.blog.service.imp;

import com.blog.model.Blog;
import com.blog.model.dto.BlogDTO;
import com.blog.repository.BlogDetailRepository;
import com.blog.repository.BlogRepository;
import com.blog.service.BlogDetailService;
import com.blog.service.BlogService;
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
        blogRepository.create(blogDTO.getTittle().toUpperCase(), blog_detail_id);
    }
}
