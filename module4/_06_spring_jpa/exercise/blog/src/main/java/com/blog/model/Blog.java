package com.blog.model;

import javax.persistence.*;

@Entity(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    public Integer id;

    public String tittle;

    @OneToOne
    @JoinColumn(name = "blog_detail_id", referencedColumnName = "id")
    public BlogDetail blogDetail;

    @Column(name = "status_delete", columnDefinition = "BIT(1)")
    private Integer statusDelete = 0;

    public Blog() {
    }

    public Blog(Integer id, String tittle, BlogDetail blogDetail, Integer statusDelete) {
        this.id = id;
        this.tittle = tittle;
        this.blogDetail = blogDetail;
        this.statusDelete = statusDelete;
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
