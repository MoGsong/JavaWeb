<%@page import="java.util.ArrayList"%>
<%@page import="com.gxlq.entity.Authorization"%>
<%@page import="com.gxlq.entity.Menu"%>
<%@page import="com.gxlq.service.imp.MenuService"%>
<%@page import="java.util.List"%>
<%@page import="com.gxlq.service.IMenuService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Object obj = session.getAttribute("AUTHORIZATION");
	List<Authorization> authorizations = new ArrayList<Authorization>();
	if(obj!=null){
		authorizations = (List<Authorization>)obj;
	}
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>step2</title>

</head>
<body>
	<form action="http://192.168.1.167:8080/cims_gjmy/authorization?OP=update" method="post">
	<%
		IMenuService ims = new MenuService();
		List<Menu> menus = ims.findByParent(0);
		for(Menu menu:menus){				
	%>
        <input name="menus" value="<%=menu.getId() %>" type="checkbox" 
        <%for(Authorization au:authorizations){ if(au.getMenu().getId()==menu.getId()){out.print("checked='checked'");break;}}%> /><%=menu.getName() %><br/>
		<%
			List<Menu> sons = ims.findByParent(menu.getId());
			for(Menu son:sons){
		%>
			 &nbsp;&nbsp;&nbsp;&nbsp;<input name="menus" value="<%=son.getId() %>" type="checkbox" 
			<%for(Authorization authorization:authorizations){if(son.getId()==authorization.getMenu().getId()){out.print("checked='checked'");break;}}%>/><%=son.getName() %><br/>
			<% 
			 	  } 	
			}
	%>
		<input type="hidden" name="roleid" value="<%=request.getParameter("roleid")%>"/>
		<input type="submit" value="保存" />
    </form>
</body>
</html>
