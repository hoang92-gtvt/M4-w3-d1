package model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserFile {
    private Long id;
    @NotEmpty
    @Size(min = 2,max = 50)
    private String name;
    @Min(18)
    private int age;
    private String gender;
    @Email
    private String email;

    public UserFile() {
    }

    public UserFile(Long id, @NotEmpty @Size(min = 2, max = 50) String name, @Min(18) int age, String gender, @Email String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public UserFile(@NotEmpty @Size(min = 2, max = 50) String name, @Min(18) int age, String gender, @Email String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
