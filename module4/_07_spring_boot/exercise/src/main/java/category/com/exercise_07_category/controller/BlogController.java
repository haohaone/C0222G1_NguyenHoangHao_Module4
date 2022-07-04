package category.com.exercise_07_category.controller;

import category.com.exercise_07_category.model.Blog;
import category.com.exercise_07_category.model.Category;
import category.com.exercise_07_category.model.dto.BlogDTO;
import category.com.exercise_07_category.service.BlogDetailService;
import category.com.exercise_07_category.service.BlogService;
import category.com.exercise_07_category.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogDetailService blogDetailService;
    @Autowired
    private CategoryService categoryService;

    //Chiến gà
    @ModelAttribute("categoryList")
    public List<Category> getListCategory() {
        return this.categoryService.findAll();
    }

    @GetMapping("/blog")
    public String showBlogList(Model model) {
        List<Blog> blogList = blogService.findAll();
        List<Blog> moreBlogList = new ArrayList<>();
        moreBlogList.add(blogList.get(0));
        model.addAttribute("blogList", moreBlogList);
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
        BlogDTO blogDTO = new BlogDTO();
        BeanUtils.copyProperties(blog, blogDTO);
        model.addAttribute("blogDTO", blogDTO);
        return "blog-views/edit-blog";
    }

    @PostMapping("/edit-blog")
    public String edit(@ModelAttribute("blogDTO") BlogDTO blogDTO) {
        blogService.edit(blogDTO.getTittle(), blogDTO.getId());
        blogDetailService.edit(blogDTO.getContent(), blogDTO.getId());
        return "redirect:/blog";
    }
}
