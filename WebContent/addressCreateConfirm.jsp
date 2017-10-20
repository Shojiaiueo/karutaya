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
  <title>お届け先の登録確認画面</title>



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
      <p>お届け先の登録確認</p>
    </div>
    <div>

      <table>

        <tr>
          <td>
            <label>郵便番号:</label>
          </td>
          <td>
            <s:property value="addressnumber" />
          </td>
        </tr>
        <tr>
          <td>
            <label>住所:</label>
          </td>
          <td>
            <s:property value="address" />
          </td>
        </tr>
        <tr>
          <td>
            <label>宛名:</label>
          </td>
          <td>
            <s:property value="addressname"/>
          </td>
        </tr>
      <s:form action="AddressCreateCompleteAction">
        <s:hidden name="addressnumber" value="%{addressnumber}" />
        <s:hidden name="address" value="%{address}" />
        <s:hidden name="addressname" value="%{addressname}" />
        <s:hidden name="purchaseflag" value="%{purchaseflag}" />
        <s:submit value="完了"/>
      </s:form>
      </table>
      <div>
        <span>Topに戻る場合は</span>こちら
      </div>
    </div>
  </div>
  <div id="footer">
    <div id="pr">
    </div>
  </div>
</body>
</html>