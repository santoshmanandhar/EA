package customers;

public class Product {
    private int id;
    private String name;
    private String category;

    public Product(int _id, String _name, String _category){
        this.id = _id;
        this.name=_name;
        this.category=_category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
