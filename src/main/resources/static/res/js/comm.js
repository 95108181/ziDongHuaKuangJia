var app = {
    footer: function() {
        var h = $(document).height() - $(window).height();
        if (h > 100) {
            $(".com_footer").removeClass("p_fid");
        }
        else{
            $(".com_footer").addClass("p_fid");
        }
    },
    raidoClick: function() {
        $(".list li .dxk").click(function() {
            var cur_img = $(this).find("img").attr("src", ctx+"/res/images/dx2.jpg"+version);
            $(this).siblings().find("img").attr("src", ctx+"/res/images/dx1.jpg"+version);
            $(this).find("input").attr("checked", true);

        });
    },
    init: function() {
        this.footer();
        this.raidoClick();
    }

};

function test(id, questionType, answer, type) {
    $.ajax({
        url: "/answer/updatescorebyid",
        type: "post",
        data: {
            answerId: id,
            questionType: questionType,
            answer: answer,
            type: type
        }
    })
}

$(function() {
    app.init();
});


