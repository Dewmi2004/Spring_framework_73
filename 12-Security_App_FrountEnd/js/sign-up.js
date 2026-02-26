$(document).ready(function () {

    $('form').submit(function (e) {
        e.preventDefault();

        let username = $('#username').val().trim();
        let password = $('#password').val().trim();
        let confirm  = $('#confirm').val().trim();
        let role     = $('#role').val();
        let terms    = $('#terms').is(':checked');


        if (!username || !password || !confirm || !role) {
            alert("Please fill all required fields!");
            return;
        }

        if (password !== confirm) {
            alert("Passwords do not match!");
            return;
        }

        if (!terms) {
            alert("You must agree to Terms & Conditions!");
            return;
        }


        $.ajax({
            url: 'http://localhost:8080/api/v1/auth/signUp',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                username: username,
                password: password,
                role: role
            }),

            success: function (res) {
                console.log(res);

                alert("Account Created Successfully!");
                window.location.href = "../Pages/Sign-in.html";
            },

            error: function (err) {
                console.log(err);
                alert("Signup failed! " + (err.responseJSON?.message || ""));
            }
        });

    });

});