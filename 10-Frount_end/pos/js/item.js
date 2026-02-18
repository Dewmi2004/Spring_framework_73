// =================== SAVE ITEM ===================
function saveItem() {
    let name = $('#inputiname').val();
    let price = $('#inputprice').val();
    let quantity = $('#inputQuantity').val();

    if (!name || !price || !quantity) {
        alert("Please fill all fields!");
        return;
    }

    $.ajax({
        url: "http://localhost:8080/api/v1/item",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            i_name: name,
            price: price,
            quantity: quantity
        }),
        success: function (res) {
            alert("Item successfully saved");
            clearItemForm();
            getAllItems();
        },
        error: function (error) {
            console.error(error);
            alert("Network or server error while saving item");
        }
    });
}

// =================== UPDATE ITEM ===================
function updateItem() {
    let id = $('#inputiid').val();
    let name = $('#inputiname').val();
    let price = $('#inputprice').val();
    let quantity = $('#inputQuantity').val();

    if (!id || !name || !price || !quantity) {
        alert("Please fill all fields!");
        return;
    }

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
            clearItemForm();
            getAllItems();
        },
        error: function (error) {
            console.error(error);
            alert("Network or server error while updating item");
        }
    });
}

// =================== DELETE ITEM ===================
function deleteItem() {
    let id = $('#inputiid').val();

    if (!id) {
        alert("Please enter item ID to delete");
        return;
    }

    $.ajax({
        url: "http://localhost:8080/api/v1/item",
        method: "DELETE",
        contentType: "application/json",
        data: JSON.stringify({
            i_id: id
        }),
        success: function (res) {
            alert("Item successfully deleted");
            clearItemForm();
            getAllItems();
        },
        error: function (error) {
            console.error(error);
            alert("Network or server error while deleting item");
        }
    });
}

// =================== GET ALL ITEMS ===================
function getAllItems() {
    $("#table-item tbody").empty();

    $.ajax({
        url: "http://localhost:8080/api/v1/item",
        method: "GET",
        success: function (res) {
            console.log("API Response:", res);

            // If API returns { data: [...] } instead of array
            let items = Array.isArray(res) ? res : res.data || [];

            if (items.length === 0) {
                $("#table-item tbody").append('<tr><td colspan="4">No items found</td></tr>');
                return;
            }

            for (let c of items) {
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

// =================== CLEAR FORM ===================
function clearItemForm() {
    $('#inputiid').val('');
    $('#inputiname').val('');
    $('#inputprice').val('');
    $('#inputQuantity').val('');
}

// =================== DOCUMENT READY ===================
$(document).ready(function () {
    getAllItems();

    // Optional: add click handlers if needed
    $('#saveBtn').click(saveItem);
    $('#updateBtn').click(updateItem);
    $('#deleteBtn').click(deleteItem);
});
