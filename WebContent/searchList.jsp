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
  <title>商品一覧</title>
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
      <p>商品一覧</p>
    </div>
    <div>
         <s:if test="searchWord!=null" >"<s:property value="searchWord" />"の検索結果</s:if>
         <s:iterator value="searchList">
          <p><img src="<s:property value="itemimg" />">
          <label><a href='<s:url action="ItemAction"><s:param name="itemid"><s:property value="itemid" /></s:param></s:url>' ><s:property value="itemname" /></a></label></p>
         </s:iterator>

<a href='<s:url action="GoItemDetailAction" ><s:param name="item_id" ><s:property value="item_id"/></s:param></s:url>'>
      <img src="<s:property value="item_image"/>" class="img"></a>


    </div>
  </div>
  <div id="footer">
    <div id="pr">
    </div>
  </div>
</body>
</html>