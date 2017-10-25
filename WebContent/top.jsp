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
	<meta name="description" content="かるた,カルタ,百人一首,カード,TCG,通販" />
	<meta name="keywords" content="かるた,カルタ,百人一首,カード,TCG,通販" />
	<title>カルタ屋</title>
	<style type="text/css">
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

		/* ========TEMPLATE LAYOUT======== */
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
		   height: 500px;+

		   text-align: center;
		}

		#footer {
			width: 100%;
			height: 80px;
			background-color: black;
			clear:both;
		}

		#text-center {
			display: inline-block;
			text-align: center;
		}
	</style>
</head>
<body>
	<div id="header">
	 	<s:include value="header.jsp" />
	</div>

  <div id="right">
     <div id="top">
       <s:form action="SearchAction">
            <s:textfield name="searchWord" />
            <s:submit value="検索" />
       </s:form>
     </div>

     <s:form action="ItemIdAction">
        <s:hidden name="searchId" value="1" />
        <s:submit value="1-10" />
     </s:form>
     <s:form action="ItemIdAction">
        <s:hidden name="searchId" value="11" />
        <s:submit value="11-20" />
     </s:form>
     <s:form action="ItemIdAction">
        <s:hidden name="searchId" value="21" />
        <s:submit value="21-30" />
     </s:form>
     <s:form action="ItemIdAction">
        <s:hidden name="searchId" value="31" />
        <s:submit value="31-40" />
     </s:form>
     <s:form action="ItemIdAction">
        <s:hidden name="searchId" value="41" />
        <s:submit value="41-50" />
     </s:form>
     <s:form action="ItemIdAction">
        <s:hidden name="searchId" value="51" />
        <s:submit value="51-60" />
     </s:form>
     <s:form action="ItemIdAction">
        <s:hidden name="searchId" value="61" />
        <s:submit value="61-70" />
     </s:form>
     <s:form action="ItemIdAction">
        <s:hidden name="searchId" value="71" />
        <s:submit value="71-80" />
     </s:form>
     <s:form action="ItemIdAction">
        <s:hidden name="searchId" value="81" />
        <s:submit value="81-90" />
     </s:form>
     <s:form action="ItemIdAction">
        <s:hidden name="searchId" value="91" />
        <s:submit value="91-100" />
     </s:form>
  </div>



  <div id="main">
     <s:form action="SpecialAction">
        <s:hidden name="special" value="1" />
        <s:submit value="special1" />
     </s:form>
  </div>

  <div id="footer">
	 	<div id="pr">
		</div>
	</div>
</body>
</html>