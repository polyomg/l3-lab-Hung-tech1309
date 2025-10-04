package com.poly.lab3.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data//
public class Staff {

    @NotBlank(message = "Chưa nhập email")
    @Email(message = "Email không đúng định dạng")
    private String id;

    @NotBlank(message = "Chưa nhập họ và tên")
    private String fullname;

    @NotNull(message = "Chưa chọn giới tính")
    private Boolean gender;

    @NotNull(message = "Chưa nhập ngày sinh")
    @Past(message = "Ngày sinh phải trong quá khứ")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthday = new Date();

    private String photo = "photo.jpg";

    @NotNull(message = "Chưa nhập lương")
    @Min(value = 1000, message = "Lương phải lớn hơn 1000")
    private Double salary = 12345.6789;

    @NotNull(message = "Chưa chọn cấp bậc")
    private Integer level = 0;
}