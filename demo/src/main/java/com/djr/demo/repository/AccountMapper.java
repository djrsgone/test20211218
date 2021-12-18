package com.djr.demo.repository;

import com.djr.demo.pojo.Account;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AccountMapper {

    @Insert("insert into account values (#{id}, #{name}, #{password}, #{gender}, #{birthDate}, #{place}, #{mobile})")
    int add(Account data);

    @Select("select * from account where id = #{id}")
    Account getById(Integer id);

    @Update("update account set name=#{name},password=#{password}, gender=#{gender}, birthDate=#{birthDate}, place=#{place}, mobile=#{mobile} where id = #{id}")
    void update(Account data);

    @Delete("delete from account where id = #{id}")
    void deleteById(Integer id);
}
