$(window).on('load', function () {
    if (localStorage.getItem('account')) {
        // $('#accountLogin').html(JSON.parse(localStorage.getItem('account')).username);
        str = `<div class="dropdown">
                  <button class="btn dropdown-toggle btn-loginAccount" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="fas fa-user-alt m-1 me-md-2"></i>
                    ${JSON.parse(localStorage.getItem('account')).username}
                  </button>
                  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                    <li><a class="dropdown-item" href="profile.html">Xem thông tin cá nhân</a></li>
                    <li><a class="dropdown-item" href="shop/index.html">Vào cửa hàng</a></li>
                    <li><button class="dropdown-item" onclick="logout()">Đăng xuất</button></li>
                  </ul>
                </div>`
        document.getElementById("login").innerHTML = str;
    } else {
        str = `<i class="fas fa-user-alt m-1 me-md-2"></i><p class="d-none d-md-block mb-0">Login</p>`
        document.querySelector(".login").href = "login.html";
        document.getElementById("login").innerHTML = str;
    }
});

function logout(){
    localStorage.removeItem("account");
    localStorage.removeItem("token");
    localStorage.removeItem("idAccount")
    window.location.href = "";
}