package com.gxlq.entity;

/**
 * @author johny
 * ?????
 */
public class Authorization {
    //????,????????????
    private int id;
    private Role role;
    private Menu menu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Authorization(int id, Role role, Menu menu) {
        super();
        this.id = id;
        this.role = role;
        this.menu = menu;
    }

    public Authorization(Role role, Menu menu) {
        super();
        this.role = role;
        this.menu = menu;
    }

    public Authorization() {
        super();
    }

    @Override
    public String toString() {
        return "Authorization [id=" + id + ", role=" + role + ", menu=" + menu + "]";
    }

}
