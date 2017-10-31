package com.lanou.bookstore.user.dao;

import com.lanou.bookstore.user.domain.User;

/**
 * Created by dllo on 17/9/21.
 */
public interface UserDao {

    User findWithName(String username );

    User findWithEmail(String email);

    void addUser(User formUser);

    User findByCode(String code);

    void updateState(String uid, String state);
}
