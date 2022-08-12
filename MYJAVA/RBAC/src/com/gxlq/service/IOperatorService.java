package com.gxlq.service;

import com.gxlq.entity.Operator;

/**
 * ??????????
 *
 * @author johny
 * ??????????��?��????????????????
 */
public interface IOperatorService {
    //???????
    void add(Operator operator);

    //????????
    void remove(int id);

    //???????
    void update(Operator operator);

    //??????????????
    Operator find(int id);

    //??????????????
    Operator[] find();

    //???????????????
    Operator find(String username, String password);
}