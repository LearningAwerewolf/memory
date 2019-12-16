<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/14
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8"/>
    <title></title>
    <link rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
        $(function () {


            function delrain(id) {
                if (confirm("确定删除吗？？")) {
                    var params = "flag=del&id=" + id;
                    $.post("rain", params, function (i) {
                        if (i == 1) {
                            alert("删除用户成功！！！");
                            grtRainMan();//删除完之后，页面刷新，更新列表
                        } else {
                            alert("emmm......");
                        }
                    })
                }

            }
            function grtRainMan() {
                $(".listbody").html("")
                var str = "flag=list";
                $.getJSON("rain", str, function (data) {
                    $(data).each(function (i) {
                        var id = this.id;
                        var tr = $("<tr class=‘list_alltr’><td class='list_alltd'>" + this.id + "</td><td class='list_alltd'>" + this.districtName + "</td><td class='list_alltd'>" + this.monitorTime + "</td><td class='list_alltd'>" + this.rain + "</td><td class='list_alltd'>" + this.monitoringStation + "</td><td class='list_alltd'>" + this.monitoringAddress + "</td></tr><br/>");
                        var td2 = $("<td class='list_alltd'></td>");
                        var a = $("<a href='javascript:;' class='del'>刪除</a>").click(function () {
                            delrain(id);
                        });
                        //拼接
                        td2.append(a)
                        tr.append(td2)
                        $(".listbody").append(tr)
                        $("#rainBody tr:even").css("background-color", "#eff7d1");
                        $("#rainBody tr:odd").css("background-color", "#f7e195");
                    })
                })
            }
            grtRainMan()
        })
    </script>
</head>

<body>
<div id="rainbigBody">
    <h3>雨量监测信息</h3>
    <div id="rainBody">
        <table class="tablebody">
            <thead>
            <tr class="list_alltr">
                <th class="list_alltd">序号</th>
                <th class="list_alltd">区域名称</th>
                <th class="list_alltd">监测时间</th>
                <th class="list_alltd">雨量值(mm)</th>
                <th class="list_alltd">监测站</th>
                <th class="list_alltd">站点地址</th>
                <th class="list_alltd">操作</th>
            </tr>
            </thead>
            <tbody class="listbody">


            </tbody>

        </table>
        <span><a href="addRainManage.jsp">新增雨量监测信息</a></span>
    </div>
</div>
</body>

</html>
