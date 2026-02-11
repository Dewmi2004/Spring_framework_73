function saveCustomer(){
    let id=$('#inputid').val()
    let name=$('#inputname').val()
    let age=$('#inputage').val()
    let address=$('#inputAddress').val()

    console.log(id,name,age,address)
    $.ajax({
        url:"http://localhost:8080/api/v1/customer",
        method:"POST",
        contentType:"application/json",
        data:JSON.stringify({

        "id":id,
        "name":name,
        "age":age,
        "address":address

        }),
        success:function (res){
alert("successfully saved")
            getAllCustomers();
        },
        error:function (error){
            alert("network error")
        }
    })
}
function updateCustomer(){
    let id=$('#inputid').val()
    let name=$('#inputname').val()
    let age=$('#inputage').val()
    let address=$('#inputAddress').val()

    console.log(id,name,age,address)
    $.ajax({
        url:"http://localhost:8080/api/v1/customer",
        method:"PUT",
        contentType:"application/json",
        data:JSON.stringify({

        "id":id,
        "name":name,
        "age":age,
        "address":address

        }),
        success:function (res){
alert("successfully updated")
            getAllCustomers();
        },
        error:function (error){
            alert("network error")
        }
    })
}
function deleteCustomer(){
    let id=$('#inputid').val()
    let name=$('#inputname').val()
    let age=$('#inputage').val()
    let address=$('#inputAddress').val()

    $.ajax({
        url:"http://localhost:8080/api/v1/customer",
        method:"DELETE",
        contentType:"application/json",
        data:JSON.stringify({

        "id":id,
        "name":name,
        "age":age,
        "address":address

        }),
        success:function (res){
alert("successfully deleted")
            getAllCustomers();
        },
        error:function (error){
            alert("network error")
        }
    })
}

$(document).ready(function () {
    getAllCustomers();
});

function getAllCustomers() {
    $("#table-customer tbody").empty();

    $.ajax({
        url: "http://localhost:8080/api/v1/customer",
        method: "GET",
        success: function (res) {
            for (let c of res) {
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
            console.log(err);
            alert("Failed to load customers");
        }
    });
}
