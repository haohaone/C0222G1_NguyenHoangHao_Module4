package category.com.exercise_07_category.model.dto;

public class BlogDTO {
//    int getId();
//    String getTittle();
//    String getContent();
//    int getCategory();
    private Integer id;
    private String tittle;
    private String content;
    private int category;

    public BlogDTO() {
    }

    public BlogDTO(Integer id, String tittle, String content, int category) {
        this.id = id;
        this.tittle = tittle;
        this.content = content;
        this.category = category;
    }

    public BlogDTO(Integer id, String tittle, String content) {
        this.id = id;
        this.tittle = tittle;
        this.content = content;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
