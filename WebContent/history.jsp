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
  <title>購入履歴画面</title>
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
    <s:include value="header.jsp" />
  </div>
  <div id="main">
    <div id="top">
      <p>購入履歴一覧</p>
    </div>
    <div>
    <p><s:property value="userName" />様</p>

    <s:if test="message != null">
      <h3><s:property value="message"/></h3>
    </s:if>
      <div id="text-right">
        <table>
            <tr>
               <th>注文日</th><th>注文内容</th><th>注文金額合計</th><th>支払方法</th>
            </tr>
          <s:iterator value="historyList">
            <tr>
              <td><s:property value="purchaseday" /></td>
              <td><s:iterator value="purchaseList">・<s:property value="itemname" /><br></s:iterator></td>
              <td><s:property value="total" /></td>
              <td><s:property value="howpay" /></td>
            </tr>
          </s:iterator>
        </table>
        <p>Topへ戻る場合は<a href='<s:url action="TopAction" />'>こちら</a></p>
        <p>MyPageへ戻る場合は<a href='<s:url action="MyPageAction" />'>こちら</a></p>
        <p>ログアウトする場合は<a href='<s:url action="LogoutExecuteAction" />'>こちら</a></p>
      </div>
    </div>
  </div>
  <div id="footer">
    <div id="pr">
    </div>
  </div>
</body>
</html>