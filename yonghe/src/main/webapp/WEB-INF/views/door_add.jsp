<%@ page pageEncoding="utf-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>新增门店</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/door_add.css">
    <script type="text/javascript">
    </script>
</head>
<body>
<h2>新增门店</h2>
<hr/>
<form action="doorAdd" method="POST">
    <table border="1">
        <tr>
            <td width="30%">门店名称</td>
            <td>
                <input type="text" name="name"/>
            </td>
        </tr>
        <tr>
            <td>联系电话</td>
            <td>
                <input type="text" name="tel"/>
            </td>
        </tr>
        <tr>
            <td>门店地址</td>
            <td>
                <input type="text" name="addr"/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="提 	交"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>



