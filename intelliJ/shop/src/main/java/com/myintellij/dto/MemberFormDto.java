package com.myintellij.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter @Setter
public class MemberFormDto {

    @NotBlank(message = "이름 필수")
    private String name;
    @NotEmpty(message = "이메일 필수")
    @Email(message = "이메일 형식으로 입력")
    private String email;
    @NotEmpty(message = "비밀번호 필수")
    @Length(min=8, max=16, message = "비밀번호는 8자 이상, 16자 이하로 입력")
    private String password;
    @NotEmpty(message = "주소 필수")
    private String address;

}
