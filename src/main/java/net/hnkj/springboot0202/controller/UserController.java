package net.hnkj.springboot0202.controller;

import net.hnkj.springboot0202.model.User;
import net.hnkj.springboot0202.service.IUserService;
import net.hnkj.springboot0202.utils.JsonData;
import net.hnkj.springboot0202.utils.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
@CrossOrigin //跨域
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("/reg")
    public JsonData reg(User user){
        //1.实例化JsonData
        JsonData jsonData = new JsonData();

        //在新增用户前设置盐,并使用盐对密码进行加密
        String salt = PasswordHelper.createSalt();
        String creadtials = PasswordHelper.createCredentials("88888",salt);
        user.setSalt(salt);
        user.setPassword(creadtials);

        //2.调用service层进行注册
        int i = userService.insertSelective(user);
        if(i==1){//添加成功 根据接口文档 设置响应体
            jsonData.setCode(1);
            jsonData.setMessage("注册成功");
        }else {
            jsonData.setCode(0);
            jsonData.setMessage("注册失败");
        }

        return jsonData;
    }


    @RequestMapping("/login")
    public JsonData login(User user){
        //1、实例化JsonData
        JsonData jsonData = new JsonData();

        //2、通过用户名查询用户
        User user1 = userService.selectUserByUsername(user.getUsername());

        //3、判断用户是否存在
        if (null==user1){  //如果user1为null表示数据库没用对应的用户
            jsonData.setCode(0);
            jsonData.setMessage("用户名不存在");
        }else {  //用户名存在
            //匹配密码
            if(PasswordHelper.checkCredentials(user.getPassword(),user1.getSalt(),user1.getPassword())){
                jsonData.setCode(1);
                jsonData.setMessage("登录成功");
            }else {
                jsonData.setCode(0);
                jsonData.setMessage("密码错误");
            }
        }

        return jsonData;
    }
}
