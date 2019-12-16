<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/14
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#sub").click(function () {

                var txtName = $("#txtName").val();
                var txtTime = $("#txtTime").val();
                var txtRainValue = $("#txtRainValue").val();
                var txtMonitor = $("#txtMonitor").val();
                var txtPlace = $("#txtPlace").val();
                var reg = /^(\d{4}).(0\d{1}|1[0-2]).(0\d{1}|[12]\d{1}|3[01])$/;
                var regx = /^[0-9]*$/;
                if (txtName == null || txtName == "") {
                    alert("区域名称不能为空")
                } else if (txtTime == null || txtTime == "") {
                    alert("监测时间不能为空")
                } else if (reg.test(txtTime) == false) {
                    alert("监测时间格式不正确");
                } else if (txtRainValue == null || txtRainValue == "") {
                    alert("雨量值不能为空")
                } else if (regx.test(txtRainValue) == false) {
                    alert("雨量值为数字");
                } else if (txtMonitor == null || txtMonitor == "") {
                    alert("监测站不能为空")
                } else if (txtPlace == null || txtPlace == "") {
                    alert("站点位置不能为空")
                } else {
                    var jsonstr = $(".box-body input").serializeArray();
                    var params = $.param(jsonstr);

                    $.get("rain", params, function (i) {
                        alert(i);
                        if (i <= 0) {
                            alert("添加失败\n请联系管理员")
                        } else {
                            alert("添加成功")
                            $("#newstitle").val("");
                            $("#newsCountent").val("");
                            window.location.href = "index.jsp";
                        }
                    })
                }

            })
            $("#btn").click(function () {
                window.location.href = "index.jsp";
            })
        })
    </script>

</head>

<body>
<div id="addBody">

        <table class="box-body">
            <tr>
                <td colspan="3">
                    <h4>新增雨量监测信息</h4>
                </td>
            </tr>
            <tr>
                <td>区域名称:</td>
                <input type="hidden" value="add" name="flag">
                <td><input type="text" id="txtName" name="txtName" class="form-control"/></td>
                <td></td>
            </tr>
            <tr>
                <td>监测时间：</td>
                <td><input type="text" id="txtTime" name="txtTime" class="form-control"/></td>
                <td>yyyy.MM.dd格式</td>
            </tr>
            <tr>
                <td>雨量值(mm)：</td>
                <td><input type="text" id="txtRainValue" name="txtRainValue" class="form-control"/></td>
                <td></td>
            </tr>
            <tr>
                <td>监测站：</td>
                <td><input type="text" id="txtMonitor" name="txtMonitor" class="form-control"/></td>
                <td></td>
            </tr>
            <tr>
                <td>站点位置：</td>
                <td><input type="text" id="txtPlace" name="txtPlace" class="form-control"/></td>
                <td></td>
            </tr>
            <tr>

                <td colspan="3"><input type="button" id="sub" value="提交"> &nbsp;
                    <input type="reset" value="重置" class="form-control"/> &nbsp;
                    <input type="button" value="返回" id="btn"/></td>

            </tr>
        </table>
</div>

</body>

</html>
