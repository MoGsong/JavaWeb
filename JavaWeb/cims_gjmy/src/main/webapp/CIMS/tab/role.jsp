<%@page import="java.util.List"%>
<%@page import="com.gxlq.entity.Role"%>
<%@page import="com.gxlq.service.imp.RoleService"%>
<%@page import="com.gxlq.service.IRoleService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int pageSize=10;			//每一页 上显示信息的最大条数
	int firstPage=1;		//首页的页码
	int previousPage=1;		//上一页的页码
	int nextPage=1;			//下一页的页码
	int lastPage=1;			//最后一页的页码
	int currentPage=1;		//当前的页码
	
	//获取请求参数P，该值为要显示的页码
	String cp = request.getParameter("P");
	if(cp!=null){
		currentPage = Integer.parseInt(cp);
	}
	//调用业务方法，检索所有邮件信息
	   IRoleService roleService = new RoleService();
	   
	   List<Role> roles = roleService.find();
	   int total = roles.size(); //最记录条数
	   //分页
	   roles = roleService.find(currentPage,pageSize);
	   
	   //最后一页的页码
	   if(total%pageSize==0){
		   lastPage = total/pageSize;
	   }else{
		   lastPage = total/pageSize + 1;
	   }
	   
		//得到上一页的页号
	   previousPage=currentPage-1;
	   if(previousPage<=firstPage){
		previousPage=firstPage;
	   }
		
	   //得到下一页的页号
	   nextPage=currentPage+1;
	   if(nextPage>=lastPage){
		 nextPage=lastPage;
	   }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>权限管理</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>

<script>
var  highlightcolor='#c1ebff';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
</script>

<script>
   function xxx(n){
	   //重新跳转到tab.jsp，即“刷新tab.jsp”,且把要显示的号码以请求参数的方法进行传递，如 P=4
	   window.location.href="http://192.168.1.167:8080/cims_gjmy/CIMS/tab/role.jsp?P="+n;
   }
</script>

</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="5%"><div align="center"><img src="images/tb.gif" width="16" height="16" /></div></td>
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[权限管理]-[角色]</td>
              </tr>
            </table></td>
            <td width="54%"><table border="0" align="right" cellpadding="0" cellspacing="0">
              <tr>
                <td width="60"><table width="87%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center">
                      <input type="checkbox" name="checkbox62" value="checkbox" />
                    </div></td>
                    <td class="STYLE1"><div align="center">全选</div></td>
                  </tr>
                </table></td>
                <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="images/22.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center"><a href="http://192.168.1.167:8080/cims_gjmy/CIMS/tab/addrole.jsp">新增</a></div></td>
                  </tr>
                </table></td>
                <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="images/33.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center">修改</div></td>
                  </tr>
                </table></td>
                <td width="52"><table width="88%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="images/11.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center">删除</div></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="images/tab_12.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td width="3%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center">
              <input type="checkbox" name="checkbox" value="checkbox" />
            </div></td>
            <td width="20%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">序号</span></div></td>
            <td width="50%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">名称</span></div></td>
            <td width="30%" height="22" background="images/bg.gif" bgcolor="#FFFFFF" class="STYLE1"><div align="center">基本操作</div></td>
          </tr>
          <%
          for(Role role:roles){
          %>
          <tr>
            <td height="20" bgcolor="#FFFFFF"><div align="center">
              <input type="checkbox" name="checkbox2" value="checkbox" />
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="center"><%=roles.indexOf(role)+1%></div>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=role.getName() %></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE4"><img src="images/edt.gif" width="16" height="16" /><a href="http://192.168.1.167:8080/cims_gjmy/role?OP=toupdate&id=<%=role.getId()%>">编辑</a>&nbsp; &nbsp;<img src="images/del.gif" width="16" height="16" /><a href="http://192.168.1.167:8080/cims_gjmy/role?id=<%=role.getId()%>">删除</a></span></div></td>
          </tr>
          <%} %>
        </table></td>
        <td width="8" background="images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="images/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4">&nbsp;&nbsp;共有 <%=total %> 条记录，当前第 <%=currentPage %>/<%=lastPage %>  页</td>
            <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="40"><img src="images/first.gif" width="37" height="15" onclick="xxx(<%=firstPage%>)"/></td>
                  <td width="45"><img src="images/back.gif" width="43" height="15" onclick="xxx(<%=previousPage%>)"/></td>
                  <td width="45"><img src="images/next.gif" width="43" height="15" onclick="xxx(<%=nextPage%>)"/></td>
                  <td width="40"><img src="images/last.gif" width="37" height="15" onclick="xxx(<%=lastPage%>)"/></td>
                  <td width="100"><div align="center"><span class="STYLE1">转到第
                    <input name="textfield" type="text" size="4" onclick="xxx(document.getElementById('page').value)" style="height:12px; width:20px; border:1px solid #999999;" /> 
                    页 </span></div></td>
                  <td width="40"><img src="images/go.gif" width="37" height="15" /></td>
                </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
