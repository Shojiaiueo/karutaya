<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="Content-Style-Type" content="text/css" />
  <meta http-equiv="Content-Script-Type" content="text/javascript" />
  <meta http-equiv="imagetoolbar" content="no" />
  <title>カルタ屋</title>

 <style type="text/css">

.logo{
  margin-right:1em;
  position:relative;
  top:10px;
  width:134px;
  height:45px;
}

.header_btn {
  margin:1em;
  font-weight: bold;
    display: inline-block;
    padding: 0.5em 1em;
    text-decoration: none;
    color: black;
    border: double 4px black;
    border-radius: 3px;
    transition: .4s;
    background:#ffffff;
    z-index: 12;
}
.header_btn:hover {
    background: #c0c0c0;
}
</style>
</head>


<body>
 <s:if test="#loginUserInfoMap.loginUserId == null">
   <a href="<s:url action="GoHomeAction" />"><img class="logo" src="img/カルタ屋ロゴ.png"></a>
   <a href="login.jsp" class="header_btn">ログイン</a>
   <a href="userCreate.jsp" class="header_btn">会員登録</a>
   <a href="<s:url action="GoCartAction"/>" class="header_btn">カート</a>
  </s:if>
  <s:else>
   <a href="login.jsp"><img class="logo" src="img/カルタ屋ロゴ.png"></a>
   <a href="myPage.jsp" class="header_btn">マイページ</a>
   <a href="<s:url action="GoCartAction"/>" class="header_btn">カート</a>
  </s:else>

</body>
</html>