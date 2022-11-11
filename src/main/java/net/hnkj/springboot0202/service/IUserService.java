package net.hnkj.springboot0202.service;

import net.hnkj.springboot0202.model.User;
import net.hnkj.springboot0202.utils.PageBean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IUserService {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    @Transactional(readOnly = true)
    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //查询所有用户
    @Transactional(readOnly = true)
    List<User> listUser(User user, PageBean pageBean);

    //根据用户名查询用户  用于登录
    @Transactional(readOnly = true)
    User selectUserByUsername(String username);
}