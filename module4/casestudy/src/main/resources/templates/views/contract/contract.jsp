<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 6/1/2022
  Time: 9:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="/bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap4.min.css"/>
    <link href="/bootstrap413/css/furama.css" rel="stylesheet" type="text/css">
    <style>
        .bg {
            background-image: url(/bootstrap413/css/furama2.jpg);
            background-size: cover;
        }
    </style>
</head>

<body class=" w-100 bg" style="overflow: hidden">
<nav class="navbar bg-white m-0 p-0" id="head">
    <div class="row col-md-12 h-100 m-0 p-0">
        <div class="col-md-2 m-0 p-0 center-box home">
            <a href="jsp/home.jsp">
                <img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo.png" class="logo">
            </a>
        </div>
        <div class=" col-md-8 h-100 p-0 p-0 center-box home">
            Danh sách khách hàng
        </div>
        <div class=" col-md-2 center-box">
        </div>
    </div>
</nav>

<div class="row m-0 p-0  h-100 w-100">
    <div class="col-md-1 m-0 h-100  p-0 center-box">&nbsp;</div>
    <div class="col-md-10 h-100 m-0 p-0 center-box">
        <div class=" bg-white center-box">
            <table class="table border-0 text-center table-striped table-hover bg-white" id="tableEmployee">
                <thead>
                <tr>
                    <td colspan="11" class="text-primary border-0">
                        <div class="row w-100">
                            <div class="col-md-6">
                                <a href="/action?action=add" class="font-weight-bold"
                                   data-toggle="modal" data-target="#addContract"
                                   onclick="doNotContract(${doNotContract})"
                                >
                                    Thêm hợp đồng
                                </a>
                            </div>
                            <div class="col-md-6">
                                <a href="/service?action=search" data-toggle="modal" data-target="#SearchByName"
                                   class="font-weight-bold">
                                    Tìm kiếm dịch vụ
                                </a>
                            </div>
                        </div>
                    </td>
                </tr>
                <c:if test="${editSuccessful != null}">
                    <tr>
                        <th colspan="11">
                            <div class="text-danger font-weight-bold">${editSuccessful}</div>
                        </th>
                    </tr>
                </c:if>

                <c:if test="${addSuccessful != null}">
                    <tr>
                        <th colspan="11">
                            <div class="text-success font-weight-bold">${addSuccessful}</div>
                        </th>
                    </tr>
                </c:if>

                <c:if test="${deleteSuccessful != null}">
                    <tr>
                        <th colspan="11">
                            <div class="text-warning font-weight-bold">${deleteSuccessful}</div>
                        </th>
                    </tr>
                </c:if>
                <tr>
                    <th>Mã hợp đồng</th>
                    <th>Ngày bắt đầu</th>
                    <th>Ngày kết thúc</th>
                    <th>Tiền cọc</th>
                    <th>Tổng tiền thuê</th>
                    <th>Khách hàng</th>
                    <th>Nhân viên</th>
                    <th>Dịch vụ</th>
                    <th>Edit</th>
                    <th>Delel</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${contractList}" var="contract">
                    <c:if test="${contract.statusDelete == 0}">
                        <tr>
                            <td>${contract.contractId}</td>
                            <td>${contract.startDate}</td>
                            <td>${contract.endDate}</td>
                            <td>${contract.deposit}</td>
                            <td>${contract.totalMoney}</td>
                            <c:forEach items="${customerList}" var="customer">
                                <c:if test="${contract.customerId == customer.customerId}">
                                    <td>${customer.customerName}</td>
                                </c:if>
                            </c:forEach>
                            <c:forEach items="${employeeList}" var="employee">
                                <c:if test="${contract.employeeId == employee.employeeId}">
                                    <td>${employee.employeeName}</td>
                                </c:if>
                            </c:forEach>
                            <c:forEach items="${serviceList}" var="service">
                                <c:if test="${service.serviceId == contract.serviceId}">
                                    <td>${service.serviceName}</td>
                                </c:if>
                            </c:forEach>
                            <td>
                                <a href="/contract?action=edit&id=${contract.contractId}">Edit</a>
                            </td>
                            <td>
                                <a href="#" onclick="contractIndex('${contract.contractId}')" data-toggle="modal"
                                   data-target="#delete">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-md-1 m-0 p-0">&nbsp;</div>
</div>
</div>

<div class="modal" id="delete">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title w-100 text-center">Bạn có muốn xóa hợp đồng</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-dark" onclick="contractIndex2()">
                    <a class="text-white">Xóa</a>
                </button>
                <button type="button" class="btn btn-dark " data-dismiss="modal">Hủy</button>
            </div>
        </div>
    </div>
</div>

<div class="modal" id="addContract">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title w-100 text-center" id="doNotContract">

                </h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-footer" id="footerDoNotContract">
            </div>
        </div>
    </div>
</div>

<div class="modal" id="SearchByName">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header w-100">
                <div class="w-100 center-box">
                    <form method="post" action="/customer?action=search"
                          class="form-inline my-2 my-lg-0 w-100 center-box">
                        <div class="row p-1 rounded rounded-pill w-100  center-box">
                            <div class="col-md-4 w-100">
                                <select name="customerTypes" class="form-control custom-select bg-light">
                                    <option value="" selected>Loại khách</option>

                                </select>
                            </div>
                            <div class="col-md-8 input-group center-box shadow-sm bg-light w-100 p-0">
                                <input type="search" placeholder="Tên dịch vụ" aria-describedby="button-addon1"
                                       class="form-control border-0 w-75 bg-light "
                                       name="searchByName"
                                >
                                <div class="input-group-append bg-light w-25">
                                    <button id="button-addon1" type="submit"
                                            class="btn bg-light btn-link text-primary w-100">
                                        <i class="bi bi-search"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap4.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="/bootstrap413/js/bootstrap.bundle.min.js"></script>

<script>
    var id;

    function contractIndex(index) {
        debugger
        id = index;
    };

    function contractIndex2() {
        let link = "/contract?action=delete&id=" + id;
        window.location.href = link;
    };

    function doNotContract(index) {
        if (index > 0) {
            document.getElementById("doNotContract").innerHTML = "Còn " + index + " khách hàng chưa làm hợp đồng"
            document.getElementById("footerDoNotContract").innerHTML
                = "<button type=\"button\" class=\"btn btn-dark\">\n" +
                "                    <a class=\"text-white\" href='/contract?action=add'>Thêm hợp đồng</a>\n" +
                "                </button>" +
                "<button type=\"button\" class=\"btn btn-dark \" data-dismiss=\"modal\">Hủy</button>";
        } else {
            document.getElementById("doNotContract").innerHTML = "Tất cả khách hàng đã làm hợp đồng"
            document.getElementById("footerDoNotContract").innerHTML
                = "<button type=\"button\" class=\"btn btn-dark \" data-dismiss=\"modal\">Hủy</button>";
        }
    };

</script>

<script>
    $(document).ready(function () {
        $('#tableEmployee').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 4
        });
    })
</script>
</html>
