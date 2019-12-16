<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/16
  Time: 19:03
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
            function delbook(id) {
                if (confirm("确定删除吗？？")) {
                    var params = "flag=del&id=" + id;
                    $.post("book", params, function (i) {
                        if (i == 1) {
                            alert("删除用户成功！！！");
                            getBookMan();//删除完之后，页面刷新，更新列表
                        } else {
                            alert("emmm......");
                        }
                    })
                }
            }
            function getBookMan() {
                $(".listbody").html("")
                var str = "flag=list";
                alert(str)
                $.getJSON("book", str, function (data) {

                    $(data).each(function (i) {

                        var id = this.id;
                        var tr = $("<tr class=‘list_alltr’><td class='list_alltd'>" + this.name + "</td><td class='list_alltd'>" + this.author + "</td><td class='list_alltd'>" + this.time + "</td><td class='list_alltd'>" + this.type + "</td></tr><br/>");
                        var td2 = $("<td class='list_alltd'></td>");
                        var a = $("<a href='javascript:;' class='del'>刪除</a>").click(function () {
                            delbook(id);
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
            getBookMan()
        })
    </script>
</head>

<body>
<div id="rainbigBody">
    <h3>图书信息</h3>
    <div id="rainBody">
        <table class="tablebody">
            <thead>
            <tr class="list_alltr">
                <th class="list_alltd">图书名称</th>
                <th class="list_alltd">图书作者</th>
                <th class="list_alltd">购买时间</th>
                <th class="list_alltd">图书分类</th>
                <th class="list_alltd">操作</th>
            </tr>
            </thead>
            <tbody class="listbody">

            </tbody>

        </table>

    </div>
</div>
</body>

</html>
