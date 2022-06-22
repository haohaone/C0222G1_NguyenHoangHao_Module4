package category.com.exercise_07_category.controller;

import category.com.exercise_07_category.model.Category;
import category.com.exercise_07_category.model.dto.CategoryDTO;
import category.com.exercise_07_category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public String showBlogList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("id").descending();
        Page<Category> categoryList = categoryService.findAll(PageRequest.of(page, 1, sort));
        model.addAttribute("categoryList", categoryList);
        return "category-views/category-list";
    }

    @GetMapping("/detail-category/{id}")
    public String showDetailCategory(@PathVariable("id") int id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("blogList", category.getBlogList());
        return "blog-views/blog-list";
    }

    @GetMapping("/delete-category/{id}")
    public String delete(@PathVariable("id") int id) {
        categoryService.delete(id);
        return "redirect:/category";
    }

    @GetMapping("/create-category")
    public String showCreateForm(Model model) {
        model.addAttribute("categoryDTO", new CategoryDTO());
        return "category-views/category-create";
    }

    @PostMapping("/create-category")
    public String create(@ModelAttribute("categoryDTO") CategoryDTO categoryDTO) {
        categoryService.create(categoryDTO.getCategory());
        return "redirect:/category";
    }

    @GetMapping("/edit-category/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("categoryDTO", new CategoryDTO(category.getId(), category.getCategory()));
        return "category-views/category-edit";
    }

    @PostMapping("/edit-category")
    public String edit(@ModelAttribute("categoryDTO") CategoryDTO categoryDTO) {
        categoryService.edit(categoryDTO.getCategory(), categoryDTO.getId());
        return "redirect:/category";
    }

    @PostMapping("/search-category")
    public String search(@RequestParam("name") String category,
                         @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                         Model model){
        Sort sort = Sort.by("id").descending();
        Page<Category> categoryList = categoryService.search(category, PageRequest.of(page, 1, sort));
        model.addAttribute("categoryList", categoryList);
        return "category-views/category-list";
    }
}
