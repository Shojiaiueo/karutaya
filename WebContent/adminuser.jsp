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
  <meta name="description" content="" />
  <meta name="keywords" content="" />
  <meta charset="utf-8">
  <title>ユーザー管理画面</title>
  <style type="text/css">
  /* ========TAG LAYOUT======== */
    body {
       margin:0;
       padding:0;
       line-height:1.6;
       letter-spacing:1px;
       font-family:Verdana, Helvetica, sans-serif;
       font-size:12px;
       color:#333;
       background:#fff;
    }

    table {
      text-align:center;
      margin:0 auto;
    }

  /* ========ID LAYOUT======== */
    #top {
       width:780px;
       margin:30px auto;
       border:1px solid #333;
    }

    #header {
       width: 100%;
       height: 80px;
       background-color: black;
    }

    #main {
       width: 100%;
       height: 500px;
       text-align: center;
    }

    #footer {
      width: 100%;
      height: 80px;
      background-color: black;
      clear:both;
    }

    #text-right {
      display: inline-block;
      text-align: right;
    }
  </style>
</head>
<body>
  <div id="header">
    <s:include value="adminheader.jsp" />
  </div>
  <div id="main">
    <div id="top">
      <p>ユーザー一覧</p>
    </div>
    <div>
      <table border="1">
          <tr><th>id</th><th>Eメール</th><th>password</th><th>名前</th><th>管理者フラグ</th><th>削除フラグ</th></tr>
          <s:iterator value="userList">
             <tr>
                 <td><s:property value="userId" /></td>
                 <td><s:property value="email" /></td>
                 <td><s:property value="password" /></td>
                 <td><s:property value="userName" /></td>
                 <td><s:property value="adminflag" /></td>
                 <td><s:property value="deleteflag" /></td>
             </tr>
          </s:iterator>
      </table>
    </div>
  </div>
  <div id="footer">
    <div id="pr">
    </div>
  </div>
</body>
</html>