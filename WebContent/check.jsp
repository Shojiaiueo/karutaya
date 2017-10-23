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
  <title>購入確認画面</title>



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
      height: 90%;
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
      <p>購入確認</p>
    </div>


    <table>
      <tr><th>商品名</th><th>数量</th><th>合計</th></tr>
      <s:iterator value="cartList">
        <tr>
            <td><s:property value="itemname" /></td>
            <td><s:property value="quantity" /></td>
            <td>￥<s:property value="subtotal" /></td>
        </tr>
      </s:iterator>
    </table>
    <div>
        <p>商品金額合計:￥<s:property value="itemtotal" /></p>
        <p>送料:￥<s:property value="postage" /></p>
        <p>手数料:￥<s:property value="commission" /></p>
        <p>注文金額合計:￥<s:property value="total" /></p>
    </div>

    <p>配送情報</p>
    <p>ご注文主：<s:property value="userName" /></p>
    <p>配送方法：<s:property value="howdeliver" /></p>
    <p>お支払い方法：<s:property value="howpay" /></p>
    <p>お届け先</p>
    <table>
        <tr>
            <th>商品名</th><th>数量</th>
        </tr>
        <s:iterator value="cartList">
            <tr>
                <td><s:property value="itemname" /></td><td><s:property value="quantity" /></td>
            </tr>
        </s:iterator>
    </table>

     <s:if test="%{errorflag}">
      <div>
        <s:form action="CompleteCreditAction">
             <table border="1">
                <tr>
                    <th>カード会社の選択</th>
                    <td>
                        <select name="credittype" required>
                             <option value="visa">VISA</option>
                             <option value="mastercard">MasterCard</option>
                             <option value="americanexpress">American Express</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>カード番号</th>
                    <td>
                         <input type="text" name="creditnumber" pattern="^[0-9]+${16}" required>
                    </td>
                </tr>
                <tr>
                    <th>有効期限</th>
                    <td>
                         <select name="creditM">
                              <option>01</option>
                              <option>02</option>
                              <option>03</option>
                              <option>04</option>
                              <option>05</option>
                              <option>06</option>
                              <option>07</option>
                              <option>08</option>
                              <option>09</option>
                              <option>10</option>
                              <option>11</option>
                              <option>12</option>
                         </select>&nbsp;月&nbsp;
                         <select name="creditY">
                              <option><s:property value="year[0]" /></option>
                              <option><s:property value="year[1]" /></option>
                              <option><s:property value="year[2]" /></option>
                              <option><s:property value="year[3]" /></option>
                              <option><s:property value="year[4]" /></option>
                         </select>&nbsp;年
                    </td>
                </tr>
                <tr>
                    <th>セキュリティコード</th>
                    <td>
                        <input type="text" name="creditsecurity" pattern="^[0-9]+${4}" required>
                    </td>
                </tr>
              </table>

                 <s:hidden name="total" value="%{total}"/>
                 <s:hidden name="addressid" value="%{addressid}" />
                 <s:hidden name="howdeliver" value="%{howdeliver}" />
                 <s:hidden name="howpay" value="%{howpay}" />
                 <input type="submit" value="確認画面へ進む">
        </s:form>
      </div>
      </s:if>
      <s:else>
        <div>
           <s:form action="CompleteAction">
                 <s:hidden name="total" value="%{total}"/>
                 <s:hidden name="addressid" value="%{addressid}" />
                 <s:hidden name="howdeliver" value="%{howdeliver}" />
                 <s:hidden name="howpay" value="%{howpay}" />
                 <input type="submit" value="確認画面へ進む">
           </s:form>
        </div>
      </s:else>
  </div>
  <div id="footer">
    <div id="pr">
    </div>
  </div>
</body>
</html>