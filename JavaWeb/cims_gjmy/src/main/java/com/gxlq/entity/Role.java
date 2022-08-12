package com.gxlq.entity;

import java.io.Serializable;

/**
 * ??????????????????PDM????��?????
 * ??????��??????????��?????????
 *
 * @author johny
 * ?????
 */
public class Role implements Serializable{
    //????,????????
    private int id;
    private String name;

    //set|get????
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //???????????????
    public Role(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Role(String name) {
        super();
        this.name = name;
    }

    public Role() {
        super();
    }

    //????????????????????????
    @Override
    public String toString() {
        return "Role [id=" + id + ", name=" + name + "]";
    }
}
