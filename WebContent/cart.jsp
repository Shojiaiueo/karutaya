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
  <title>カート画面</title>

  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" ></script>
  <script src="js/userincr.js"></script>
  <script>
  $(function(){
    $("input.manual-adjust").userincr().data({
      'min':0,
      'max':100
    });
    $("input.adjust").userincr({
      buttonlabels:{
        'dec':'▼',
        'inc':'▲'
      },
    });
  });
  </script>

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
      <p>カート</p>
    </div>
    <div>

    <s:if test="message != null">
      <h3><s:property value="message"/></h3>
    </s:if>
      <div id="text-right">
       <s:if test="%{errorMessage}">カートが空です。</s:if>
       <s:else>

            <table>
              <s:iterator value="cartList">
                <tr>
                   <td>
                      <s:property value="itemname" />
                   </td>
                   <td>
                     <s:form action="CartUpdateAction">
                       <input type="text" class="manual-adjust" name="quantity" value="<s:property value="quantity" />" />
                       <s:hidden name="itemid" value="%{itemid}" />
                       <input type="submit" value="再計算" />
                     </s:form>
                   </td>
                   <td>
                      <s:form action="CartItemDeleteAction">
                            <s:hidden name="itemid" value="%{itemid}" />
                            <input type="submit" value="削除" />
                      </s:form>

                   </td>
                </tr>
              </s:iterator>
            </table>
            <s:form action="PurchaseAction">
               <input type="submit" value="購入手続きへ進む" />
            </s:form>
        </s:else>
      </div>
    </div>
  </div>
  <div id="footer">
    <div id="pr">
    </div>
  </div>
</body>
</html>