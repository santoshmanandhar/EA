package domain;

public class DVD extends Product{

    private String gener;

    public DVD(String gener) {
        this.gener = gener;
    }

    public DVD(String name, String description, double price, String gener) {
        super(name, description, price);
        this.gener = gener;
    }

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }
}
