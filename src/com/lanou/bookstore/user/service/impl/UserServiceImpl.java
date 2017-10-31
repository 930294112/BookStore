package com.lanou.bookstore.user.service.impl;

import com.lanou.bookstore.user.dao.UserDao;
import com.lanou.bookstore.user.dao.impl.UserDaoImpl;
import com.lanou.bookstore.user.domain.User;
import com.lanou.bookstore.user.service.UserException;
import com.lanou.bookstore.user.service.UserService;

/**
 * Created by dllo on 17/9/21.
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void regist(User formUser) throws UserException {
        User dbuser = userDao.findWithName(formUser.getUsername());
        User dbuser1 = userDao.findWithEmail(formUser.getEmail());
        if (dbuser!=null){
            throw new UserException("用户:" + formUser.getUsername() +"已经存在");
        }else if (dbuser1!=null){
            throw new UserException("Email:"+formUser.getEmail()+"已被注册");
        }else {
            //用户不存在,添加到数据库
            userDao.addUser(formUser);
        }

    }

    @Override
    public User active(String code) throws UserException {
        User user = userDao.findByCode(code);
        String state = user.getState();
        String uid = user.getUid();
        if (user==null){
            throw  new UserException("用户:"+ user.getUsername() +"不存在");
        }else if (state!=null){
            throw new UserException("用户:" + user.getUsername()+"已经激活");
        }else if (!user.getCode().equals(code)){
            throw new UserException("激活码错误");
        }
        userDao.updateState(uid,state);
        return user;
    }

    @Override
    public User login(User fromuser) throws UserException {
        User user = userDao.findWithName(fromuser.getUsername());
        if (user==null){
            throw new UserException("用户:" +fromuser.getUsername()+"不存在");
        }else if (!user.getPassword().equals(fromuser.getPassword())){
            throw new UserException("密码错误");
        }else if (user.getState()==null){
            throw new UserException("您未激活,请激活");
        }
        return user;
    }
}
