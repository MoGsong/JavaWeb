package com.gxlq.service;

import com.gxlq.entity.Authorization;

public interface IAuthorizationService {
    //??????
    void add(Authorization authorization);

    //??????
    void remove(int id);

    //??????
    void update(Authorization authorization);

    //???????????
    Authorization find(int id);

    //???????????
    Authorization[] find();
   //getting  authorization whole role info
    Authorization[] findByRole(int roleId);
}
