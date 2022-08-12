package com.gxlq.view;

import java.io.UnsupportedEncodingException;

import com.gxlq.entity.Authorization;
import com.gxlq.entity.Menu;
import com.gxlq.entity.Operator;
import com.gxlq.service.IAuthorizationService;
import com.gxlq.service.IMenuService;
import com.gxlq.service.imp.AuthorizationService;
import com.gxlq.service.imp.MenuService;
//import java.util.Arrays;

/**
 * ????
 *
 * @author Administrator
 */
public class UI {
    public static void show1() throws UnsupportedEncodingException {
        String str = " __          __  _                       _          _____  ____          _____ _ \r\n" +
                " \\ \\        / / | |                     | |        |  __ \\|  _ \\   /\\   / ____| |\r\n" +
                "  \\ \\  /\\  / /__| | ___ ___  _ __ ___   | |_ ___   | |__) | |_) | /  \\ | |    | |\r\n" +
                "   \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\  | __/ _ \\  |  _  /|  _ < / /\\ \\| |    | |\r\n" +
                "    \\  /\\  /  __/ | (_| (_) | | | | | | | || (_) | | | \\ \\| |_) / ____ \\ |____|_|\r\n" +
                "     \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|  \\__\\___/  |_|  \\_\\____/_/    \\_\\_____(_)\r\n" +
                "                                                                               ";
		/*String Sr = " .----------------.  .----------------.  .----------------.  .----------------. \r\n" + 
				"| .--------------. || .--------------. || .--------------. || .--------------. |\r\n" + 
				"| |  _______     | || |   ______     | || |      __      | || |     ______   | |\r\n" + 
				"| | |_   __ \\    | || |  |_   _ \\    | || |     /  \\     | || |   .' ___  |  | |\r\n" + 
				"| |   | |__) |   | || |    | |_) |   | || |    / /\\ \\    | || |  / .'   \\_|  | |\r\n" + 
				"| |   |  __ /    | || |    |  __'.   | || |   / ____ \\   | || |  | |         | |\r\n" + 
				"| |  _| |  \\ \\_  | || |   _| |__) |  | || | _/ /    \\ \\_ | || |  \\ `.___.'\\  | |\r\n" + 
				"| | |____| |___| | || |  |_______/   | || ||____|  |____|| || |   `._____.'  | |\r\n" + 
				"| |              | || |              | || |              | || |              | |\r\n" + 
				"| '--------------' || '--------------' || '--------------' || '--------------' |\r\n" + 
				" '----------------'  '----------------'  '----------------'  '----------------' ";*/
        System.out.println(str); //????????????????????
//		System.out.println(Sr);
        //????
        // byte[] strByte = str.getBytes("UTF-8");
//        System.out.println("utf-8???"+Arrays.toString(strByte));


        //??????????????????? ISO-8859-1,??ISO8859-1????????????
        // String str2 = new String(strByte,"ISO-8859-1");
//         System.out.println(str2); ???????????
        //????  ,????????????????
        //String str3 = new String(str2.getBytes(),"UTF-8");
        // System.out.println(str3); //"??ISO8859-1????utf-8??\n"
//???????       
//        //?????????????????????????????????????????
//        byte[] strByte2 = str2.getBytes("ISO-8859-1");
//        String str4 = new String(strByte2,"UTF-8");
//        System.out.println("??ISO8859-1(???)????utf-8??\n"+str4); 
//		

    }

    public static void show2() {
        String msg = "+----------------------+" + "\n" +
                     "|	RBAC		         |" + "\n" +
                     "+----------------------+";
        System.out.println(msg);
    }

    public static void show3() {
        IMenuService ims = new MenuService();
        Menu[] menus = ims.findByParent(0);
        for (int i = 0; i < menus.length; i++) {
            System.out.println("~" + menus[i].getName());

            Menu[] menus0 = ims.findByParent(menus[i].getId());
            for (int j = 0; j < menus0.length; j++) {
                System.out.println("  -" + menus0[j].getName());
            }
        }
        System.out.println("~ÍË³ö");
    }
/*
    This method have a disadvantage is what if authorization table
    have not sonMenu authorization the fatherMenu control will can't trigger
 */
    public static void show4(Operator operator) {
        //get all father menu
        IMenuService ims = new MenuService();
        Menu[] FatherMenus = ims.findByParent(0);

        IAuthorizationService ias = new AuthorizationService();
        //selecting role's authorization  by role id
        Authorization[] authorizations = ias.findByRole(operator.getRole().getId());
        for (int i = 0; i < FatherMenus.length; i++) {
            //judge role's authorization have  or not in the FatherMenus
            for (Authorization au:authorizations) {
                if (au.getMenu().getId() == FatherMenus[i].getId()){
                    // if have, display the fatherMenu's name and break into next circulation
                    System.out.println("~" + FatherMenus[i].getName());
                    break;
                }
            }
            //select all SonMenus by the fatherMenu's id
            Menu[] SonMenus = ims.findByParent(FatherMenus[i].getId());
            // for and judge role whether have SonMenus's authorization
             /* another method code
              *  for (Menu son:SonMenus) {
                     for (Authorization au:authorizations) {
                        if (au.getMenu().getId() == son.getId()) {
                        // if have, display the SonMenu's name and break into next circulation
                             System.out.println("  -" + son.getName());
                        break;
                    }*/
            for (int j = 0; j < SonMenus.length; j++) {
                for (Authorization au:authorizations) {
                    if (au.getMenu().getId() == SonMenus[j].getId()) {
                        // if have, display the SonMenu's name and break into next circulation
                        System.out.println("  -" + SonMenus[j].getName());
                        break;
                    }
                }
            }
        }
        System.out.println("~ÍË³ö");
    }

}
