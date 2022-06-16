<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 6/5/2022
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Sandwich Condiments</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/bootstrap413/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .center-box {
            display: flex;
            align-items: center;
            justify-content: center;
        }


        .footer {
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
    </style>
</head>
<body>
<div class="p-3 ">
    <h4 class="lable text-center font-weight-bold">Tờ khai y tế</h4>
    <p class="lable text-center font-weight-bold">
        ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ
        LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG
        DỊCH BỆNH TRUYỀN NHIỄM
    </p>
    <p class="lable text-danger text-center font-weight-bold">
        Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt
        Nam và có thể xử lý hình sự
    </p>
    <form:form action="/create" method="post" modelAttribute="health">
        <div class="form-group">
            <label class="font-weight-bold">Họ tên (ghi chữ IN HOA)</label>
            <span class="text-danger font-weight-bold">(*)</span>
            <form:input type="text" path="name" class="form-control"/>
        </div>

        <div class="footer">
            <div class="form-group" style="width: 33%">
                <label class="font-weight-bold">Năm sinh (ghi chữ IN HOA)</label>
                <span class="text-danger font-weight-bold">(*)</span>
                <form:select path="dayOfBirth" class="form-control">
                    <form:options items="${dayOfBirth}"></form:options>
                </form:select>
            </div>
            <div class="form-group" style="width: 33%">
                <label class="font-weight-bold">Giới tính (ghi chữ IN HOA)</label>
                <span class="text-danger font-weight-bold">(*)</span>
                <form:select type="text" path="gender" class="form-control">
                    <form:option value="Nam">Nam</form:option>
                    <form:option value="Nữ">Nữ</form:option>
                </form:select>
            </div>
            <div class="form-group" style="width: 33%">
                <label class="font-weight-bold">Quốc tịch (ghi chữ IN HOA)</label>
                <span class="text-danger font-weight-bold">(*)</span>
                <form:select path="nationality" class="form-control">
                    <form:options items="${nationality}"></form:options>
                </form:select>
            </div>
        </div>

        <div class="form-group">\\\\
            <label class="font-weight-bold">Thông tin đi lại</label>
            <span class="text-danger font-weight-bold">(*)</span>
            <div class="w-25 footer">
                <span class="font-weight-bold"><form:radiobutton path="transport"/> Tàu bay</span>
                <span class="font-weight-bold"><form:radiobutton path="transport"/> Tàu thuyền</span>
                <span class="font-weight-bold"><form:radiobutton path="transport"/> Ô tô</span>
                <span class="font-weight-bold"><form:radiobutton path="transport"/> Khác</span>
            </div>
        </div>

        <div class="footer">
            <div class="form-group" style="width: 49%">
                <label class="font-weight-bold">Số hiệu phương tiện</label>
                <form:input type="text" path="idTransport" class="form-control" placeholder="VD: VN123"/>
            </div>
            <div class="form-group" style="width: 49%">
                <label class="font-weight-bold">Số ghế</label>
                <form:input type="text" path="seats" class="form-control"/>
            </div>
        </div>

        <div class="footer">
            <div class="form-group" style="width: 49%">
                <label class="font-weight-bold">Ngày bắt đầu</label>
                <span class="text-danger font-weight-bold">(*)</span>
                <form:input type="date" path="startDate" class="form-control" placeholder="VD: VN123"/>
            </div>
            <div class="form-group" style="width: 49%">
                <label class="font-weight-bold">Ngày kết thúc</label>
                <span class="text-danger font-weight-bold">(*)</span>
                <form:input type="date" path="endDate" class="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="font-weight-bold">
                Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?
            </label>
            <span class="text-danger font-weight-bold">(*)</span>
            <form:textarea type="text" path="moreDescription" class="form-control"/>
        </div>
        <p class="lable text-danger font-weight-bold">
            Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch, thuộc quản lý của Ban chỉ
            đạo quốc gia về Phòng chống dịch Covid-19. Khi bạn nhấn nút "Gửi" là bạn đã hiểu và đồng ý.
        </p>

        <div class="form-group center-box">
            <button class="btn btn-success" type="submit">GỬI TỜ KHAI</button>
        </div>
    </form:form>

</div>
</body>

<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/bootstrap413/js/bootstrap.bundle.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous">

</script>
</html>
