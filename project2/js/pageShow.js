function stopPropagation(e) {
    e = window.event || e;
    if (document.all) { //只有ie识别
        e.cancelBubble = true;
    } else {
        e.stopPropagation();
    }
}

function signUpShow() {
    stopPropagation();
    setTimeout(function()
    {
        console.log("signUp Show/Hide")
         if($('#second-container').css('display') === 'none')
         {
            $("#second-container").css('display', 'block');
          /*  $('#login_page').css('display', 'none');*/
            $('#first-container').css('display', 'none');
         }
        else {
            $('#second-container').css('display', 'none');
            /*$('#login_page').css('display', 'block');*/
            $('#first-container').css('display', 'block');
        }
    }, 50)
}

function forgetPWShow() {
    stopPropagation();
    setTimeout(function()
    {
        console.log("forgetPW Show/Hide")
        if($('#third-container').css('display') === 'none')
        {
            $("#third-container").css('display', 'block');
           /* $('#login_page').css('display', 'none');*/
            $('#first-container').css('display', 'none');
        }
        else {
            $('#third-container').css('display', 'none');
           /* $('#login_page').css('display', 'block');*/
            $('#first-container').css('display', 'block');
        }
    }, 50)
}