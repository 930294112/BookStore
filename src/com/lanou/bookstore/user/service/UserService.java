package com.lanou.bookstore.user.service;

import com.lanou.bookstore.user.domain.User;

/**
 * Created by dllo on 17/9/21.
 */
public interface UserService {
    void regist(User formUser) throws UserException;

    User active(String code) throws UserException;

    User login(User fromuser) throws UserException;
}
