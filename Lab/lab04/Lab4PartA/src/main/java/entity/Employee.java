package entity;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue
   private int employeeNumber;
   private String name;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", name='" + name + '\'' +
                '}';
    }

    @ManyToOne
   @JoinColumn(name = "dept_id")
   private Department dept;

    public Employee(String name, Department dept) {

        this.name = name;
        this.dept=dept;
    }

    public Employee() {

    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
