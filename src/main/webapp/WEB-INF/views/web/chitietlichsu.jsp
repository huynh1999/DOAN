<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">

<head>
  <title>Chi tiết</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/nhshop.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/checkout.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/profile.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/chitietlichsu.css">
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="lichsumua" id="lichsumua" style="overflow-x:auto; width: 100%;">
                <br>
                <h5><b>Chi tiết đơn hàng</b> </h5>
                <table class="table bg-light">
                    <thead>
                        <tr>
                            <th>Sản phẩm</th>
                            <th>Giá</th>
                            <th>Số lượng</th>
                            <th>Giảm giá</th>
                            <th>Tạm tính</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="mathang">
                            <td class="d-flex p-2">
                                <a href=""><img class="anhnho"
                                        src="https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/i1-86f7b43f-2f76-42cb-b253-a7591b6032c7/jordan-short-sleeve-crew-BsLCrG.jpg"
                                        alt=""></a>
                                <a href="" class="p-2">Tên sp áo thun nike blalala123</a>
                            </td>
                            <td>500000</td>
                            <td>1</td>
                            <td>20000</td>
                            <td>480000</td>
                        </tr>
                        <tr class="mathang">
                            <td class="d-flex p-2">
                                <a href=""><img class="anhnho"
                                        src="https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/i1-86f7b43f-2f76-42cb-b253-a7591b6032c7/jordan-short-sleeve-crew-BsLCrG.jpg"
                                        alt=""></a>
                                <a href="" class="p-2">Tên sp áo thun nike blalala123</a>
                            </td>
                            <td>500000</td>
                            <td>1</td>
                            <td>20000</td>
                            <td>480000</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td class="text-right p-4">
                                <h6>Tạm tính</h6>
                                <h6>Phí vận chuyển</h6> 
                                <h6>Tổng cộng</h6> 
                            </td>
                            <td class="text-left p-4">
                                <h6>480000</h6>
                                <h6>20000</h6>
                                <h6 class="text-danger">500000</h6>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row">
            <a href="" class="mr-5">Quay trở lại</a>
            <button type="button" class="btn btn-warning">Theo dõi đơn hàng</button>
        </div>
    </div>
</body>

</html>