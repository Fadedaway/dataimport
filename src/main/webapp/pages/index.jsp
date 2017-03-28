<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/28
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>


    <input type="text" id="excelShow" readonly/>
    <button id="excelScan">浏览</button>
    <button id="excelUpload" onclick="submitExcel();">上传</button>
    
    <input type="text" id="excelShow2" readonly/>
    <button id="excelScan2">浏览</button>
    <button id="excelUpload2" onclick="submitExcel2();">上传</button>

    <form id="excelForm" enctype="multipart/form-data" method="post">
        <input id="excelFile" name="file" type="file"  style="display: none"/>
        <input type="hidden" name="fileType"  value = "image"/>
    </form>
    <form id="excelForm2" enctype="multipart/form-data" method="post">
        <input id="excelFile2" name="file" type="file"  style="display: none"/>
        <input type="hidden" name="fileType"  value = "image"/>
    </form>
</body>
<script>
    var root = '<%=basePath%>';
</script>
<script type="text/javascript" src="/js/jquery/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="/js/index.js"></script>
</html>
