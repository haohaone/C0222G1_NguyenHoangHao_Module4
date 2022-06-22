package category.com.exercise_07_category.model;

import javax.persistence.*;

@Entity(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private Integer id;

    private String tittle;

    @OneToOne
    @JoinColumn(name = "blog_detail_id", referencedColumnName = "id")
    private BlogDetail blogDetail;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;


    @Column(name = "status_delete", columnDefinition = "BIT(1)")
    private Integer statusDelete = 0;

    public Blog() {
    }

    public Blog(Integer id, String tittle, BlogDetail blogDetail, Category category, Integer statusDelete) {
        this.id = id;
        this.tittle = tittle;
        this.blogDetail = blogDetail;
        this.category = category;
        this.statusDelete = statusDelete;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(Integer statusDelete) {
        this.statusDelete = statusDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public BlogDetail getBlogDetail() {
        return blogDetail;
    }

    public void setBlogDetail(BlogDetail blogDetail) {
        this.blogDetail = blogDetail;
    }
}
