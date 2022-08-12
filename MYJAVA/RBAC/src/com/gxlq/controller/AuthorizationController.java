package com.gxlq.controller;
import java.util.Scanner;
import com.gxlq.entity.Authorization;
import com.gxlq.entity.Menu;
import com.gxlq.entity.Role;
import com.gxlq.service.IAuthorizationService;
import com.gxlq.service.IMenuService;
import com.gxlq.service.IRoleService;
import com.gxlq.service.imp.AuthorizationService;
import com.gxlq.service.imp.MenuService;
import com.gxlq.service.imp.RoleService;

/**
 * 权限控制类
 * @author johny
 * 分控
 */
public class AuthorizationController {
    //权限调度，即修改权限
    public static  void update() {
        //调用业务方法，显示所有角色,citing service method to display all roles
        IRoleService irs = new RoleService();
        //findAll roles data
        Role[] roles = irs.find();
        //output roles id and name
        StringBuffer msg = new StringBuffer("");
        for (Role role : roles) {
            msg.append(role.getId()+"、"+role.getName()+"\t");
        }
        System.out.println(msg);
        //input roleId to select authorization info by findByRole() method order to alert authorities
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入角色编号：");
        int roleid = sc.nextInt();

        System.out.println("请输入进行权限调度的操作类型【删除权限|添加权限】：");
        String op = sc.next();
        if("删除权限".equals(op)) {
            //当前角色已经拥有权限访问的菜单信息（查询权限表）
            IAuthorizationService ias = new AuthorizationService();
            Authorization[] authorizations = ias.findByRole(roleid);  //authorization[]:{roleId,menu}
            StringBuffer msg3 = new StringBuffer("");
            for(Authorization au:authorizations) {
                msg3.append(au.getMenu().getId()+"、"+au.getMenu().getName()+"\t");
            }
            System.out.println(msg3);
            System.out.println("请输入要撤销权限的菜单编号：");
            int menuid = sc.nextInt();  //4

            //调用业务方法，在权限表中删除一条记录
            //显示所有权限信息，循环每个权限信息，把与当前角色和菜单匹配的权限信息根据主键删除
            authorizations = ias.find(); //{1,1,8  1,1,9}
            for (Authorization au : authorizations) {
                if(au.getMenu().getId()==menuid && au.getRole().getId()==roleid) {
                    ias.remove(au.getId());
                }
            }
            System.out.println("撤销成功！");
        }else if("添加权限".equals(op)) {
            //显示所有当前角色还未拥有权限访问的菜单信息
            //查询所有菜单
            IMenuService ims = new MenuService();
            Menu[] menus = ims.find();  //{id=1,2,3,4,5,6,7,8,9}
            //当前角色已经拥有权限访问的菜单信息（查询权限表）
            IAuthorizationService ias = new AuthorizationService();
            //role data  of authorization table
            Authorization[] authorizations = ias.findByRole(roleid);  //{3,8   3,9}
            //use StringBuffer to improve jvm efficiency
            StringBuffer msg2 = new StringBuffer("");
            //遍历menus数组，把某个元素与authorizations数组中的所有元素进行比较，若均不相等，则表示该菜单是当前角色还没有权限访问的菜单
            for(Menu menu:menus) {
                //标识变量，通常赋初始值，通常其值是否被更改，来判断某个代码片断是否执行过
                boolean flag = false;
                for(Authorization au:authorizations) {
                    //若已经拥有该菜单对应的访问权限，则结束循环，通常break控制减少循环的次数，提高性能
                    if(menu.getId()==au.getMenu().getId()) { //8,9
                        flag = true;
                        break;
                    }
                }
                //if(flag==false) {
                if(!flag) {
                    msg2.append(menu.getId()+"、"+menu.getName()+"|");
                }
            }

            System.out.println(msg2);
            System.out.println("请输入要授予权限的菜单编号：");
            int menuid = sc.nextInt();  //4
            //调用业务方法，在权限表中添加一条记录,only input one have roleId and menuId in an authorization
            Role role =new Role(); //{id=0,name=null}
            role.setId(roleid);     //{id=3,name=null}
            Menu menu = new Menu();//{id=0,name=null,parent=}
            menu.setId(menuid);//{id=4,name=null,parent=}
            Authorization  authorization = new Authorization(role,menu);
            ias.add(authorization);

            System.out.println("授权成功！");

        }else {
            System.out.println("输入有误！");
        }
        System.out.println("权限调度完成！");
    }
}
