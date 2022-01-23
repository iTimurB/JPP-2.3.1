package spring_crud.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name not be empty")
    @Size(min = 2, max = 30, message = "Name size - 2 and 30 characters")
    @Column(name = "name")
    private String name;

    @Min(value = 1, message = "Age not be 0")
    @Max(value = 200, message = "Hello alien")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "Email not be empty")
    @Email (message = "Incorrectly filled out form")
    @Column(name = "email")
    private String email;

    public User() {

    }

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
