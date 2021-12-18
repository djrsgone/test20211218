package com.djr.demo.mybatis.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class UserBO {
    private Integer id;//编号

    @NotBlank
    private String username;//用户名

    @NotNull
    private String password;//密码

    @Min(value = 1, message = "学生的年级最小为1年级")
    @Max(value = 6, message = "学生的年级最小为6年级")
    private Integer grade;

    @Range(min = 1, max = 18, message = "学生的所在班级区间为1~18")
    private Integer classroom;

    @Size(min=2, max=5, message = "学生的技能填写至少2个，最多5个")
    private List<String> skill;

    @Length(min=3, max=8, message = "学生的英文名长度区间在3~8")
    private String englishName;

    @Email(message = "邮箱格式不正确")
    private String email;
}
