package com.blog.controller;

import com.blog.model.Blog;
import com.blog.model.dto.BlogDTO;
import com.blog.service.BlogDetailService;
import com.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogDetailService blogDetailService;

    @GetMapping("/")
    public String showBlogList(Model model){
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "blog-list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        blogService.delete(Integer.parseInt(id));
        return "redirect:/";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("blogDTO", new BlogDTO());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blogDTO") BlogDTO blogDTO){
        blogService.save(blogDTO);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blogDTO", new BlogDTO(blog.id, blog.tittle, blog.blogDetail.getContent()));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("blogDTO") BlogDTO blogDTO){
        blogService.edit(blogDTO.getTittle(), blogDTO.getId());
        blogDetailService.edit(blogDTO.getContent(), blogDTO.getId());
        return "redirect:/";
    }
}
