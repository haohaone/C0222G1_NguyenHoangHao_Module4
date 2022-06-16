<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 6/16/2022
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<p>Họ và Tên: ${health.name}</p>
<p>Năm sinh: ${health.dayOfBirth}</p>
<p>Giới tính: ${health.gender}</p>
<p>Quốc tịch: ${health.nationality}</p>
<p>Phương tiện di chuyển: ${health.transport}</p>
<p>Mã phương tiện: ${health.idTransport}</p>
<p>Chỗ ngồi: ${health.seats}</p>
<p>Ngày bắt đầu: ${health.startDate}</p>
<p>Ngày kết thúc: ${health.endDate}</p>
<p>Mô tả thêm: ${health.moreDescription}</p>
</body>
</html>
