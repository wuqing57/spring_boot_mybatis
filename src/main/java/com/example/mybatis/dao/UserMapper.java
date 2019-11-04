package com.example.mybatis.dao;

import com.example.mybatis.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "userName",  column = "user_name"),
            @Result(property = "passWord", column = "pass_word"),
            @Result(property = "nickName", column = "nick_name"),
            @Result(property = "regTime", column = "reg_time")
    })
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "userName",  column = "user_name"),
            @Result(property = "passWord", column = "pass_word"),
            @Result(property = "nickName", column = "nick_name"),
            @Result(property = "regTime", column = "reg_time")
    })
    User getOne(Long id);

    @Insert("INSERT INTO user(user_name,pass_word,email,nick_name,reg_time,age) VALUES(#{name}, #{passWord}, null,null,null,null)")
    void insert(User user, String name ,String passWord);

    @Update("UPDATE user SET user_name=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);


}
