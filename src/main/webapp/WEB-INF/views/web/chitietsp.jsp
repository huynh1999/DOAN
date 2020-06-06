<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@include file="/common/taglib.jsp"%>

<!doctype html>
<html lang="en">

<head>
  <title>Chi tiết</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/nhshop.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/category.css">

  <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/chitietsp.css">
</head>

<body>
  <div class="container">
    <div class="row">
      <div class="col-8 col-sm-8">
        <div class="anhmieuta" id="lsimg">

        </div>
      </div>
      <div class="col-4 col-sm-4">
        <div class="row">
          <div class="col-8" style="padding-left: 0px;">
            <p class="tensp">${item.name}</p>
          </div>
          <div class="col-4">
            <p id="price">${item.price}</p>
          </div>
        </div>
        <div class="row">
          <h5>Chọn size</h5>
        </div>
        <div class="row">
          <div class="form-check">
            <label class="form-check-label">
              <input type="radio" checked class="form-check-input" name="optradio" value="XS">XS
            </label>
          </div>
          <div class="form-check">
            <label class="form-check-label">
              <input type="radio" class="form-check-input" name="optradio" value="S">S
            </label>
          </div>
          <div class="form-check">
            <label class="form-check-label">
              <input type="radio" class="form-check-input" name="optradio" value="M">M
            </label>
          </div>
          <div class="form-check">
            <label class="form-check-label">
              <input type="radio" class="form-check-input" name="optradio" value="L">L
            </label>
          </div>
          <div class="form-check">
            <label class="form-check-label">
              <input type="radio" class="form-check-input" name="optradio" value="XL">XL
            </label>
          </div>
          <div class="form-check">
            <label class="form-check-label">
              <input type="radio" class="form-check-input" name="optradio" value="2XL">2XL
            </label>
          </div>
        </div>
        <div class="row btmua" style="text-align: center; margin: auto; margin-top: 20px;">
          <button type="button" class="btn btn-outline-warning btnshop" id="add_cart">Thêm vào giỏ hàng</button>
        </div>
        <div class="row">
          <h5>Miêu tả</h5>
          <p id="des"></p>
        </div>
      </div>
    </div>
    <div class="row" style=" margin-top: 50px; border-top: 1px solid gray;">
      <h6 class="chudep" style="font-size: x-large; margin-top: 20px; background-image: -webkit-linear-gradient(#9ea811,#9dbd10,#e812a6);">Các sản phẩm đề xuất</h6>
      <div style="margin: auto;" role="list">
        <div class="row" role="list" style="text-align: center;">
            <div class="col _1sanpham" role="listitem">
                <a href="#"><img alt="sanpham1" class="anhsanpham"
                        src="https://cdn3.yame.vn/pimg/ao-thun-nam-y2010-bd-b01-0019570/f7e1d4ae-c9b3-0100-d1ac-0016c9eb68f5.jpg?w=440"
                        alt=""></a>
                <p>100.000 vnd</p>
                <!-- mau  -->
                <a href="#"><img alt="mau sac sp1" class="anhmau"
                        src="https://cdn3.yame.vn/pimg/ao-thun-nam-y2010-bd-b01-0019570/f7e1d4ae-c9b3-0100-d1ac-0016c9eb68f5.jpg?w=440"
                        alt=""></a>

            </div>
            <div class="col _1sanpham" role="listitem">
                <a href="#"><img alt="sanpham2" class="anhsanpham"
                        src="https://cdn3.yame.vn/pimg/ao-thun-nam-y2010-bd-b03-0019572/d901b2c4-22ec-0300-5539-0016c9eb9d40.jpg?w=440"
                        alt=""></a>
                <p>100.000 vnd</p>
                <!-- mau  -->
                <a href="#"><img alt="mau sanpham2" class="anhmau"
                        src="https://cdn3.yame.vn/pimg/ao-thun-nam-y2010-bd-b03-0019572/d901b2c4-22ec-0300-5539-0016c9eb9d40.jpg?w=440"
                        alt=""></a>

            </div>
            <div class="col _1sanpham" role="listitem">
                <a href="#"><img alt="sanpham3" class="anhsanpham"
                        src="https://cdn2.yame.vn/pimg/ao-khoac-y2010-kaki-e06-0019437/80f8c358-7a9c-1e00-c2bc-0016a782c0ff.jpg?w=440"
                        alt=""></a>
                <p>100.000 vnd</p>
                <!-- mau  -->
                <a href="#"><img alt="mau sanpham3" class="anhmau"
                        src="https://cdn2.yame.vn/pimg/ao-khoac-y2010-kaki-e06-0019437/80f8c358-7a9c-1e00-c2bc-0016a782c0ff.jpg?w=440"
                        alt=""></a>
                <a href="#"><img alt="mau sanpham3" class="anhmau"
                        src="https://cdn3.yame.vn/pimg/ao-khoac-y2010-kaki-e06-0019437/6e5365aa-cd19-1b00-f315-0016a7827302.jpg?w=100&h=140&c=true"
                        alt=""></a>
                <a href="#"><img alt="mau sanpham3" class="anhmau"
                        src="https://cdn2.yame.vn/pimg/ao-khoac-y2010-kaki-e06-0019437/2711de3d-4e22-1c00-56b4-0016a7829674.jpg?w=100&h=140&c=true"
                        alt=""></a>

            </div>
        </div>
    </div>
  </div>
  </div>
  <script>
    window.onload=function(){
      $.getScript("/template/js/page/chitiet.js")
    }
  </script>
</body>

</html>