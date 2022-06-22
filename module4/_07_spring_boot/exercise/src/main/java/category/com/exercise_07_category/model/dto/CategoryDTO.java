package category.com.exercise_07_category.model.dto;

public class CategoryDTO {
    private int id;
    private String category;

    public CategoryDTO() {
    }

    public CategoryDTO(String category) {
        this.category = category;
    }

    public CategoryDTO(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
