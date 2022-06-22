package category.com.exercise_07_category.controller;

import category.com.exercise_07_category.model.Blog;
import category.com.exercise_07_category.model.Category;
import category.com.exercise_07_category.model.dto.BlogDTO;
import category.com.exercise_07_category.service.BlogDetailService;
import category.com.exercise_07_category.service.BlogService;
import category.com.exercise_07_category.service.CategoryService;
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
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/blog")
    public String showBlogList(Model model) {
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "blog-views/blog-list";
    }

    @GetMapping("/delete-blog/{id}")
    public String delete(@PathVariable("id") String id) {
        blogService.delete(Integer.parseInt(id));
        return "redirect:/blog";
    }

    @GetMapping("/create-blog")
    public String showCreateForm(Model model) {
        model.addAttribute("blogDTO", new BlogDTO());
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "blog-views/create-blog";
    }

    @PostMapping("/create-blog")
    public String create(@ModelAttribute("blogDTO") BlogDTO blogDTO) {
        blogService.save(blogDTO);
        return "/redirect:/blog";
    }

    @GetMapping("/edit-blog/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blogDTO", new BlogDTO(blog.getId(), blog.getTittle(), blog.getBlogDetail().getContent()));
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "blog-views/edit-blog";
    }

    @PostMapping("/edit-blog")
    public String edit(@ModelAttribute("blogDTO") BlogDTO blogDTO) {
        blogService.edit(blogDTO.getTittle(), blogDTO.getId());
        blogDetailService.edit(blogDTO.getContent(), blogDTO.getId());
        return "redirect:/blog";
    }
}
