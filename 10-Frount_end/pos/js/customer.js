// =================== SAVE CUSTOMER ===================
function saveCustomer() {
    let name = $('#inputname').val();
    let age = $('#inputage').val();
    let address = $('#inputAddress').val();

    if (!name || !age || !address) {
        alert("Please fill all fields!");
        return;
    }

    $.ajax({
        url: "http://localhost:8080/api/v1/customer",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            name: name,
            age: age,
            address: address
        }),
        success: function (res) {
            alert("Customer successfully saved");
            clearCustomerForm();
            getAllCustomers();
        },
        error: function (error) {
            console.error(error);
            alert("Network or server error while saving customer");
        }
    });
}

// =================== UPDATE CUSTOMER ===================
function updateCustomer() {
    let id = $('#inputid').val();
    let name = $('#inputname').val();
    let age = $('#inputage').val();
    let address = $('#inputAddress').val();

    if (!id || !name || !age || !address) {
        alert("Please fill all fields!");
        return;
    }

    $.ajax({
        url: "http://localhost:8080/api/v1/customer",
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify({
            id: id,
            name: name,
            age: age,
            address: address
        }),
        success: function (res) {
            alert("Customer successfully updated");
            clearCustomerForm();
            getAllCustomers();
        },
        error: function (error) {
            console.error(error);
            alert("Network or server error while updating customer");
        }
    });
}

// =================== DELETE CUSTOMER ===================
function deleteCustomer() {
    let id = $('#inputid').val();

    if (!id) {
        alert("Please enter Customer ID to delete");
        return;
    }

    $.ajax({
        url: "http://localhost:8080/api/v1/customer",
        method: "DELETE",
        contentType: "application/json",
        data: JSON.stringify({ id: id }),
        success: function (res) {
            alert("Customer successfully deleted");
            clearCustomerForm();
            getAllCustomers();
        },
        error: function (error) {
            console.error(error);
            alert("Network or server error while deleting customer");
        }
    });
}

// =================== GET ALL CUSTOMERS ===================
function getAllCustomers() {
    $("#table-customer tbody").empty();

    $.ajax({
        url: "http://localhost:8080/api/v1/customer",
        method: "GET",
        success: function (res) {
            console.log("API Response:", res);

            // Handle nested data if API returns { data: [...] }
            let customers = Array.isArray(res) ? res : res.data || [];

            if (customers.length === 0) {
                $("#table-customer tbody").append('<tr><td colspan="4">No customers found</td></tr>');
                return;
            }

            for (let c of customers) {
                let row = `
                    <tr>
                        <td>${c.id}</td>
                        <td>${c.name}</td>
                        <td>${c.age}</td>
                        <td>${c.address}</td>
                    </tr>
                `;
                $("#table-customer tbody").append(row);
            }
        },
        error: function (err) {
            console.error(err);
            alert("Failed to load customers");
        }
    });
}

// =================== CLEAR FORM ===================
function clearCustomerForm() {
    $('#inputid').val('');
    $('#inputname').val('');
    $('#inputage').val('');
    $('#inputAddress').val('');
}

// =================== DOCUMENT READY ===================
$(document).ready(function () {
    getAllCustomers();

    // Optional: attach click handlers
    $('#saveBtn').click(saveCustomer);
    $('#updateBtn').click(updateCustomer);
    $('#deleteBtn').click(deleteCustomer);
});
