package com.blog_app_api.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Integer id;

    @NotBlank
    @Size(min=4, message = "Name should Be Atleast 4 Char")
    private String userName;

    @Email(message = "Your Email address is not valid")
    @NotBlank(message = "Email can not be empty")
    private String email;

    @NotBlank
    @Size(min=3 , max=10 , message = "you password should lie b/w 3 to 10 chars")
    private String password;

    @NotBlank
    @Size(max=200 , message = "Your Info not max reach 200 Words")
    private String about;
}
