package category.com.exercise_07_category.model;

import javax.persistence.*;

@Entity(name = "blog_detail")
public class BlogDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToOne(mappedBy = "blogDetail")
    private Blog blog;

    public BlogDetail() {
    }

    public BlogDetail(Integer id, String content, Blog blog) {
        this.id = id;
        this.content = content;
        this.blog = blog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
