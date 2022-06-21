package com.blog.service.imp;

import com.blog.model.Blog;
import com.blog.model.BlogDetail;
import com.blog.repository.BlogDetailRepository;
import com.blog.service.BlogDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogDetailServiceImp implements BlogDetailService {
    @Autowired
    private BlogDetailRepository blogDetailRepository;


    @Override
    public List<BlogDetail> findAll() {
        return blogDetailRepository.findAll();
    }

    @Override
    public BlogDetail findById(int id) {
        return blogDetailRepository.findByIdBlogDetail(id);
    }

    @Override
    public void edit(String content,  int id) {
        blogDetailRepository.edit(content, id);
    }

    @Override
    public BlogDetail findByIdBlogDetail(int id) {
        return blogDetailRepository.findByIdBlogDetail(id);
    }

    @Override
    public void create(String content) {
        blogDetailRepository.create(content);
    }
}
