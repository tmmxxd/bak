<%@ page pageEncoding="utf-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>修改门店</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/door_update.css">
    <script type="text/javascript">
    </script>
</head>
<body>
<h2>修改门店</h2>
<hr/>
<form action="doorUpdate" method="POST">
    <!-- hidden隐藏域,在提交表单时连door.id一起提交 -->
    <input type="hidden" name="id" value="${ door.id }"/>
    <table border="1">
        <tr>
            <td width="30%">门店名称</td>
            <td>
                <input type="text" name="name" value="${ door.name }"/>
            </td>
        </tr>
        <tr>
            <td>联系电话</td>
            <td>
                <input type="text" name="tel" value="${ door.tel }"/>
            </td>
        </tr>
        <tr>
            <td>门店地址</td>
            <td>
                <input type="text" name="addr" value="${ door.addr }"/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="提	交"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>



