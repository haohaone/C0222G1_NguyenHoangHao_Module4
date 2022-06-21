package com.blog.service;

import com.blog.model.Blog;
import com.blog.model.dto.BlogDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {

    List<Blog> findAll();

    Blog findById(int id);

    void delete(int id);

    void edit(String tittle, int id);

    void save(BlogDTO blogDTO);
}
