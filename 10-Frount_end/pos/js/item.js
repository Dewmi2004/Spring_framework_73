function saveItem() {
    let id = $('#inputiid').val();
    let name = $('#inputiname').val();
    let price = $('#inputprice').val();
    let quantity = $('#inputQuantity').val();

    $.ajax({
        url: "http://localhost:8080/api/v1/item",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            i_id: id,
            i_name: name,
            price: price,
            quantity: quantity
        }),
        success: function (res) {
            alert("Item successfully saved");
            getAllItems();
        },
        error: function (error) {
            console.error(error);
            alert("Network or server error while saving item");
        }
    });
}

function updateItem() {
    let id = $('#inputiid').val();
    let name = $('#inputiname').val();
    let price = $('#inputprice').val();
    let quantity = $('#inputQuantity').val();

    $.ajax({
        url: "http://localhost:8080/api/v1/item",
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify({
            i_id: id,
            i_name: name,
            price: price,
            quantity: quantity
        }),
        success: function (res) {
            alert("Item successfully updated");
            getAllItems();
        },
        error: function (error) {
            console.error(error);
            alert("Network or server error while updating item");
        }
    });
}

function deleteItem() {
    let id = $('#inputiid').val();

    $.ajax({
        url: "http://localhost:8080/api/v1/item",
        method: "DELETE",
        contentType: "application/json",
        data: JSON.stringify({
            i_id: id
        }),
        success: function (res) {
            alert("Item successfully deleted");
            getAllItems();
        },
        error: function (error) {
            console.error(error);
            alert("Network or server error while deleting item");
        }
    });
}

function getAllItems() {
    $("#table-item tbody").empty();

    $.ajax({
        url: "http://localhost:8080/api/v1/item",
        method: "GET",
        success: function (res) {
            for (let c of res) {
                let row = `
                    <tr>
                        <td>${c.i_id}</td>
                        <td>${c.i_name}</td>
                        <td>${c.price}</td>
                        <td>${c.quantity}</td>
                    </tr>
                `;
                $("#table-item tbody").append(row);
            }
        },
        error: function (err) {
            console.error(err);
            alert("Failed to load items");
        }
    });
}

$(document).ready(function () {
    getAllItems();
});
