package customers;

public class Supplier {
    private String name;
    private String phone;

    public Supplier(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
