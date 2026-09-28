package in.strikes.crudSpringBootDemo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class CreateStudentRequestDto {
    @NotBlank(message = "name cannot be blank")
    @Size(min = 2, max = 50, message = "Student name should be between 2-50")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age should be minium 18")
    private int age;

    @NotBlank(message = "Student email cannot be blank")
    @Email(message = "Student email must be valid")
    private String email;

    @NotNull(message = "RollNo is required")
    private Integer rollNo;

    @NotBlank(message = "Subject is required")
    private String subject;

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

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
