package spring.practice.dto;

public class UserResponseDto {
    private String email;
    private String password;

    public UserResponseDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserResponseDto{" + "email='" + email + '\'' + ", password='"
                + password + '\'' + '}';
    }
}
