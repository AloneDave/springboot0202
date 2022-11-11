package net.hnkj.springboot0202.mapper;

import net.hnkj.springboot0202.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //查询所有用户
    List<User> listUser(User user);

    //根据用户名查询用户  用于登录
    User selectUserByUsername(String username);
}