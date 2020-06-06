<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">

<head>
  <title>Profile</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/nhshop.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/checkout.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/profile.css">
  <link rel="shortcut icon" href=" ${pageContext.request.contextPath}/template/logo/icon.ico" type="image/x-icon">
</head>

<body data-spy="scroll" data-target="#myScrollspy" data-offset="1">
    <div class="container">
        <div class="row">
            <div class="col-9">
                <div class="row card border-dark myct">
                    <div class="mygiohang">
                        <h5><b>Giỏ hàng</b> </h5>
                        <span><span>3</span> sản phẩm chưa thanh toán</span>
                        <div class="d-flex flex-row myctwrap">
                            <div class="item">
                                <a href=""><img class="thugon"
                                        src="https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/i1-86f7b43f-2f76-42cb-b253-a7591b6032c7/jordan-short-sleeve-crew-BsLCrG.jpg"
                                        alt="ảnh sp giỏ hàng"></a>
                            </div>
                            <div class="item">
                                <a href=""><img class="thugon"
                                        src="https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/i1-86f7b43f-2f76-42cb-b253-a7591b6032c7/jordan-short-sleeve-crew-BsLCrG.jpg"
                                        alt="ảnh sp giỏ hàng"></a>
                            </div>
                            <div class="item">
                                <a href=""><img class="thugon"
                                        src="https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/i1-86f7b43f-2f76-42cb-b253-a7591b6032c7/jordan-short-sleeve-crew-BsLCrG.jpg"
                                        alt="ảnh sp giỏ hàng"></a>
                            </div>

                        </div>
                        <button type="button" class="btn btn-warning">Kiểm tra giỏ hàng ngay</button>
                    </div>
                    <div class="thongtin" id="idthongtin">
                        <br>
                        <h5><b>Thông tin cá nhân</b> </h5>
                        <form>
                            <div class="input-field">
                                <input type="text" required="">
                                <label>Tên</label>
                            </div>
                            <div class="input-field">
                                <input type="text" required="">
                                <label>Email</label>
                            </div>
                            <div class="input-field">
                                <input type="text" required="">
                                <label>Số điện thoại</label>
                            </div>
                            <div class="input-field">
                                <input type="text" required="">
                                <label>Địa chỉ</label>
                            </div>
                            <div class="mygroupbtn">
                                <button type="button" class="btn btn-info" data-toggle="modal"
                                    data-target="#myModalcpass">Đổi mật khẩu</button>
                                <!-- The Modal -->
                                <!-- change password  -->
                                <div class="modal fade" id="myModalcpass">
                                    <div class="modal-dialog modal-dialog-centered">
                                        <div class="modal-content">

                                            <!-- Modal Header -->
                                            <div class="modal-header">

                                                <button type="button" class="close"
                                                    data-dismiss="modal">&times;</button>
                                            </div>

                                            <!-- Modal body -->
                                            <div class="modal-body">
                                                <div class="containerform">
                                                    <div class="chudau">
                                                        <h4 class="modal-title">Đổi mật khẩu</h4>
                                                    </div>

                                                    <form>
                                                        <div class="input-field">
                                                            <input type="text" required="">
                                                            <label>Email</label>
                                                        </div>
                                                        <div class="input-field">
                                                            <input type="password" required="">
                                                            <label>Mật khẩu cũ</label>
                                                        </div>
                                                        <div class="input-field">
                                                            <input type="password" required="">
                                                            <label>Mật khẩu mới</label>
                                                        </div>
                                                        <div class="input-field">
                                                            <input type="password" required="">
                                                            <label>Nhập lại mật khẩu</label>
                                                        </div>
                                                        <div class="button">
                                                            <div class="inner">
                                                            </div>
                                                            <button type="button" class="btn btn-dark">Xác nhận</button>
                                                        </div>
                                                    </form>
                                                </div>

                                            </div>

                                            <!-- Modal footer -->
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary btn_changepass"
                                                    data-dismiss="modal">Close</button>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <button type="button" class="btn btn-danger">Xóa tài khoản</button>
                            </div>

                        </form>
                    </div>
                    <div class="lichsumua" id="idlichsumua" style="overflow-x:auto; width: 100%;">
                        <br>
                        <h5><b>Lịch sử mua hàng</b> </h5>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Mã đơn hàng</th>
                                    <th>Ngày mua</th>
                                    <th>Sản phẩm</th>
                                    <th>Tổng tiền</th>
                                    <th>Trạng thái</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="mathang">
                                    <td><a href="">ma1</a></td>
                                    <td>6/6/2020</td>
                                    <td>
                                        <a href="">Áo thun nike msmsm2020(Tên sp)</a>
                                    </td>
                                    <td>
                                        <p class="gia">500000</p>
                                    </td>
                                    <td>Giao hàng thành công</td>
                                </tr>
                                <tr class="mathang">
                                    <td><a href="">ma1</a></td>
                                    <td>6/6/2020</td>
                                    <td>
                                        <a href="">Áo thun nike msmsm2020(Tên sp)</a>
                                    </td>
                                    <td>
                                        <p class="gia">500000</p>
                                    </td>
                                    <td>Đã hủy</td>
                                </tr>
                                <tr class="mathang">
                                    <td><a href="">ma1</a></td>
                                    <td>6/6/2020</td>
                                    <td>
                                        <a href="">Áo thun nike msmsm2020(Tên sp)</a>
                                    </td>
                                    <td>
                                        <p class="gia">500000</p>
                                    </td>
                                    <td>Đang giao hàng</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="magiamgia" id="magg">
                        <br>
                        <h5><b>Mã giảm giá của bạn</b> </h5>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Mã giảm giá</th>
                                    <th>Thông tin</th>
                                    <th>Ngày hết hạn</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>giam20k</td>
                                    <td>Thành viên có đăng kí tài khoản, like theo dõi fanpage được giảm 20.000 vnđ</td>
                                    <td>10/6/2020</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <h6 class="chudep"
                    style="font-size: x-large; margin-top: 20px; background-image: -webkit-linear-gradient(#9ea811,#9dbd10,#e812a6);">
                    Các sản phẩm đề xuất</h6>
                <div class="row">
                    <div role="list">
                        <div class="row" role="list" style="text-align: center;">
                            <div class="col _1sanpham" role="listitem">
                                <a href="#"><img alt="sanpham1" class="thugonvua"
                                        src="https://cdn3.yame.vn/pimg/ao-thun-nam-y2010-bd-b01-0019570/f7e1d4ae-c9b3-0100-d1ac-0016c9eb68f5.jpg?w=440"
                                        alt=""></a>
                                <p>100.000 vnd</p>
                                <!-- mau  -->


                            </div>
                            <div class="col _1sanpham" role="listitem">
                                <a href="#"><img alt="sanpham2" class="thugonvua"
                                        src="https://cdn3.yame.vn/pimg/ao-thun-nam-y2010-bd-b03-0019572/d901b2c4-22ec-0300-5539-0016c9eb9d40.jpg?w=440"
                                        alt=""></a>
                                <p>100.000 vnd</p>
                                <!-- mau  -->


                            </div>
                            <div class="col _1sanpham" role="listitem">
                                <a href="#"><img alt="sanpham3" class="thugonvua"
                                        src="https://cdn2.yame.vn/pimg/ao-khoac-y2010-kaki-e06-0019437/80f8c358-7a9c-1e00-c2bc-0016a782c0ff.jpg?w=440"
                                        alt=""></a>
                                <p>100.000 vnd</p>
                                <!-- mau  -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-3">
                
                <nav class="col-sm-3 col-4" id="myScrollspy">
                <h5><b>My account</b> </h5>
                    <ul class="nav nav-pills flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="#idthongtin">Thông tin cá nhân</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#idlichsumua">Lịch sử mua hàng</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#magg">Mã giảm giá</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
    <script>
        $("button.btn_changepass").click(function () {
            event.preventDefault();
        })
        var input = document.querySelector('.pswrd');
        var show = document.querySelector('.show');
        show.addEventListener('click', active);

        function active() {
            if (input.type === "password") {
                input.type = "text";
                show.style.color = "#1DA1F2";
            } else {
                input.type = "password";
                show.style.color = "#111";
            }
        }
    </script>
</body>
</html>