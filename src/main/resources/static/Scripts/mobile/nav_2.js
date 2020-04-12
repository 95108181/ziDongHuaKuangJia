$(document).ready(function() {
    var navbtn = $('.navbtn');
    nav = $('.nav');
    box = $('.allpage');
    navbtn.click(function() {
        if(navbtn.hasClass('clicked')){
            navbtn.removeClass('clicked');
            box.animate({right:'0'},'500');
            return;
        }else{
            navbtn.addClass('clicked');
            box.animate({right:'240px'},'500');
            return;
        }
    });
    $('.searchbtn').click(
        function(){$('.search2').fadeToggle();}
    );
    $('.subclass').click(
        function(){$('.class').slideToggle();}
    );
    $('.foot li:last').css('background','none');
});
	