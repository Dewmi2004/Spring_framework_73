$(document).ready(function () {

    window.login = function () {
        let username = $('#username').val().trim();
        let password = $('#password').val().trim();

        if (!username || !password) {
            alert("Please enter your username and password!");
            return;
        }

        $.ajax({
            url: 'http://localhost:8080/api/v1/auth/signIn',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                username: username,
                password: password
            }),

            success:function (res) {
                if (res.code===200){
                    localStorage.setItem('token',res.data.accessToken)
                    alert("successfully signed-in")
                    window.location.href="../Pages/DashBaord.html"
                } else {
                    alert(res.data || "Sign in failed. Please try again.");
                }
            },

            error: function (err) {
                console.log(err);
                alert("Sign in failed! " + (err.responseJSON?.message || "Please check your credentials."));
            }
        });
    };

    window.clearBadges = function () {
        $('#username').val('');
        $('#password').val('');
        $('#remember').prop('checked', false);
    };

    const remembered = localStorage.getItem('rememberedUser');
    if (remembered) {
        $('#username').val(remembered);
        $('#remember').prop('checked', true);
    }

});