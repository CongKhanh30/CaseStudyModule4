let idAccount = localStorage.getItem("idAccount");
let idShop;
var params = new window.URLSearchParams(window.location.search);
var idP = params.get('idP');
function getShop() {
    // Tạo ra 1 request.
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/shop/shop/" + idAccount,
        success: function (data) {
            idShop = data.id;
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}
getShop();
function getAllCategory() {
    // Tạo ra 1 request.
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/api/categories",
        success: function (data) {
            showCategory(data);
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}
getAllCategory();
function showCategory(arr){
    let str = "";
    for (const c of arr) {
        str += `<option value="${c.id}">${c.name}</option>`
    }
    document.getElementById("category").innerHTML = str;
}

function getProduct() {
    // Tạo ra 1 request.
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/api/product/" + idP,
        success: function (data) {
            showEdit(data);
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}
getProduct()
function showEdit(p){
    document.getElementById("id").value = p.id;
    document.getElementById("name").value = p.name;
    document.getElementById("describe").value = p.describes;
    document.getElementById("price").value = p.price;
    document.getElementById("quantity").value = p.quantity;
    document.getElementById("img-thumbnail").value = p.imgProduct.thumbnail;
    document.getElementById("img1").value = p.imgProduct.img1;
    document.getElementById("img2").value = p.imgProduct.img2;
    document.getElementById("img3").value = p.imgProduct.img3;
}
showEdit();
function edit() {
    let id = $("#id").val();
    let name = $("#name").val();
    let describe = $("#describe").val();
    let price = $("#price").val();
    let quantity = $("#quantity").val();
    let thumbnail = $("#img-thumbnail").val();
    let img1 = $("#img1").val();
    let img2 = $("#img2").val();
    let img3 = $("#img3").val();
    let imgProduct = {"thumbnail": thumbnail, "img1": img1, "img2": img2, "img3": img3}
    let category = {"id": $("#category").val()};
    let shop = {"id": idShop};
    let product = {id, name, describe, price, quantity, imgProduct, category, shop}

    $.ajax({
        type: "Post",
        headers: {
            'Content-Type': 'application/json',
        },
        url: "http://localhost:8080/api/saveProduct",
        data: JSON.stringify(product),
        success: function (data) {
            window.location.href = "utilities-Product.html";
        },
        error: function (err) {
            console.log(err)
            lỗi
        }
    });
}