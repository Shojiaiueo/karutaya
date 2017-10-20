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
  <title>Login画面</title>
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

    #text-link {
      display: inline-block;
      text-align: right;
    }
  </style>
</head>
<body>
  <div id="header">
    <s:include value="header.jsp" />
  </div>
  <div id="main">
    <div id="top">
      <p>Login</p>
    </div>
      <h3></h3>
      <s:form action="LoginPurchaseExecuteAction">
        <s:textfield type="email"  name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" placeholder="email" required="true" />
        <s:password name="password" type="password" pattern="^[0-9A-Za-z]+$" placeholder="password" required="true" />
        <s:submit  value="ログイン" />
      </s:form>
      <br/>
      <div id="text-link">
        <p>新規ユーザー登録は<a href='<s:url action="UserCreateAction" />'>こちら</a></p>
        <p>Homeへ戻る場合は<a href='<s:url action="TopAction" />'>こちら</a></p>
      </div>
  </div>
  <div id="footer">
    <div id="pr">
    </div>
  </div>
</body>
</html>