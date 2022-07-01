package category.com.exercise_07_category.controller;

import category.com.exercise_07_category.model.Blog;
import category.com.exercise_07_category.model.BlogDetail;
import category.com.exercise_07_category.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/blog-rest")
public class BlogRestController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/more/{more}")
    public ResponseEntity<List<Blog>> showBlogList(@PathVariable(value = "more", required = false) int more) {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            List<Blog> moreBlogList = new ArrayList<>();
            for (int i = 0; i < more + 1; i++) {
                moreBlogList.add(blogList.get(i));
            }
            return new ResponseEntity<>(moreBlogList, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDetail> showBlogDetail(@PathVariable("id") int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blog.getBlogDetail(), HttpStatus.OK);
        }
    }

    @GetMapping("/search/{tittle}")
    public ResponseEntity<List<Blog>> searchBlogList(@PathVariable("tittle") String tittle) {
        List<Blog> blogList = blogService.search(tittle);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
    }
}
