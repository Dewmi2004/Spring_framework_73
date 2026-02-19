let cart = [];

function loadCustomers() {
    $.ajax({
        url: "http://localhost:8080/api/v1/customer",
        method: "GET",
        success: function (res) {
            $("#selectCustomer").empty()
                .append(`<option value="">Select Customer</option>`);

            $.each(res.data, function (index, customer) {
                $("#selectCustomer").append(
                    `<option value="${customer.id}">${customer.id}</option>`
                );
            });
        },
        error: function () {
            alert("Failed to load customers");
        }
    });
}

function loadItems() {
    $.ajax({
        url: "http://localhost:8080/api/v1/item",
        method: "GET",
        success: function (res) {
            $("#selectItem").empty()
                .append(`<option value="">Select Item</option>`);

            $.each(res.data, function (index, item) {
                $("#selectItem").append(
                    `<option value="${item.i_id}">${item.i_id}</option>`
                );
            });
        },
        error: function () {
            alert("Failed to load items");
        }
    });
}

$("#selectItem").change(function () {
    let itemId = $(this).val();
    if (!itemId) {
        $("#inputunitprice").val("");
        $("#availablequantity").val("");
        return;
    }

    $.ajax({
        url: `http://localhost:8080/api/v1/item/${itemId}`,
        method: "GET",
        success: function (res) {
            let item = res.data;
            $("#inputunitprice").val(item.price);
            $("#availablequantity").val(item.quantity);
        },
        error: function () {
            alert("Failed to fetch item details");
        }
    });
});

$("#btnAddToCart").click(function () {
    let itemId = parseInt($("#selectItem").val());
    let qty = parseInt($("#inputordQuantity").val());
    let unitPrice = parseFloat($("#inputunitprice").val());
    let availableQty = parseInt($("#availablequantity").val());

    if (!itemId || !qty) {
        alert("Please select item and quantity");
        return;
    }

    if (qty > availableQty) {
        alert("Not enough stock available");
        return;
    }

    let existing = cart.find(c => c.itemId === itemId);
    if (existing) {
        existing.qty += qty;
        updateCartTable();
    } else {
        cart.push({ itemId: itemId, qty: qty });
        addCartRow(itemId, unitPrice, qty);
    }

    $("#inputordQuantity").val("");
    $("#selectItem").val("");
    $("#inputunitprice").val("");
    $("#availablequantity").val("");
});

function addCartRow(itemId, unitPrice, qty) {
    let total = unitPrice * qty;
    $("#table-cart tbody").append(`
        <tr data-item-id="${itemId}">
            <td>${itemId}</td>
            <td>${unitPrice}</td>
            <td>${qty}</td>
            <td>${total}</td>
            <td>
                <button class="btn btn-danger btn-sm btn-remove">Remove</button>
            </td>
        </tr>
    `);
}

function updateCartTable() {
    $("#table-cart tbody").empty();
    cart.forEach(c => {
        $.ajax({
            url: `http://localhost:8080/api/v1/item/${c.itemId}`,
            method: "GET",
            async: false, // needed to fetch unitPrice before rendering
            success: function (res) {
                let unitPrice = parseFloat(res.data.price);
                addCartRow(c.itemId, unitPrice, c.qty);
            }
        });
    });
}

$("#table-cart").on("click", ".btn-remove", function () {
    let row = $(this).closest("tr");
    let itemId = parseInt(row.data("item-id"));

    cart = cart.filter(c => c.itemId !== itemId);
    row.remove();
});

$("#btnPlaceOrder").click(function () {
    let customerId = parseInt($("#selectCustomer").val());

    if (!customerId) {
        alert("Select Customer");
        return;
    }

    if (cart.length === 0) {
        alert("Cart is empty");
        return;
    }

    let cartDTO = {
        customerId: customerId,
        items: cart
    };

    $.ajax({
        url: "http://localhost:8080/api/v1/order",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(cartDTO),
        success: function () {
            alert("Order placed successfully!");
            cart = [];
            $("#table-cart tbody").empty();
        },
        error: function () {
            alert("Failed to place order");
        }
    });
});

$(document).ready(function () {
    loadCustomers();
    loadItems();
});
