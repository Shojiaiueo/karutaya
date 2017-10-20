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
  <title>購入手続き画面</title>



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
      <p>購入手続き</p>
    </div>
    <div>
        <s:if test="%{errorflag}">お届け先を選択してください。<br></s:if>
        <s:form action="CheckAction">
                 ご注文主
                 <s:property value="userName"/>様<br>

                 お届け先<br>
                 <s:iterator value="addressList">
                    <input type="radio" name="addressid" value="<s:property value="addressid"/>"><s:property value="addressname" />様<br>
                    <s:property value="addressnumber"/><br>
                    <s:property value="address"/><br>
                    <s:property value="addressname"/>様<br>
                 </s:iterator>
                 <a href="<s:url action="AddressCreateAction"><s:param name="purchaseflag" value="1"/></s:url> " >新しいお届け先を登録する</a>
                 <p>
                 配送方法：
                 <input type="radio" name="howdeliver" value="ゆうパック" checked>ゆうパック
                 <input type="radio" name="howdeliver" value="同梱">同梱
                 <input type="radio" name="howdeliver" value="店頭受け取り">店頭受け取り
                 </p>
                 <p>
                 お支払い方法：
                 <input type="radio" name="howpay" value="クレジットカード" checked>クレジットカード
                 <input type="radio" name="howpay" value="銀行振り込み">銀行振り込み
                 </p>

                 <input type="submit" value="確認画面へ進む">
        </s:form>
    </div>
  </div>
  <div id="footer">
    <div id="pr">
    </div>
  </div>
</body>
</html>