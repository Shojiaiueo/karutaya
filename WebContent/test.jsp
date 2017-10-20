<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="description" content="User Adjustable Incrementer のデモでーす。">
<title>User Adjustable Incrementer - jQuery Plugin Demo</title>
<script src="js/userincr.js"></script>
<script>
$(function(){
  $("input.manual-adjust").userincr().data({
    'min':0,
    'max':10
  });
  $("input.adjust").userincr({
    buttonlabels:{
      'dec':'↓',
      'inc':'+'
    },
  });
});
</script>
</head>
<body>
<p><a href="https://webkaru.net/jquery-plugin/user-adjustable-incrementer/">「jQueryプラグインまとめ」に戻る</a></p>
<h1>User Adjustable Incrementer のデモでーす。</h1>

<p>「▼」「▲」ボタンをクリックしてみてください。</p>
<input type="text" class="manual-adjust" value="50" />
</body>
</html>
