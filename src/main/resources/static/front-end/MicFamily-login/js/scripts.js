include("js/bgStretch.js");
include("js/sImg.js");
include("js/jquery.color.js");
include("js/jquery.backgroundpos.js");
include("js/jquery.easing.js");
include("js/jquery.fancybox-1.3.4.pack.js");
include("js/googleMap.js");
include("js/superfish.js");
include("js/switcher.js");
include("js/forms.js");
include("js/MathUtils.js");

function include(url) {
    document.write('<script src="' + url + '"></script>');
}

var MSIE = true, OPR = true, content, defColor, defMh, h;


function showSplash() {
    content.stop(true).animate({'width': '0'}, 500, 'easeOutExpo')
}

function hideSplash() {
    content.stop(true).animate({'width': '0'}, 400, 'easeInExpo')
        .delay(250)
        .animate({'width': '660px'}, 700, 'easeOutExpo');
}

function hideSplash2() {
    content.stop(true).animate({'width': '660px'}, 700, 'easeOutExpo');
}

function showSplashQ() {
    content.css({'width': '0px'});
}

$(document).ready(ON_READY);
$(window).load(ON_LOAD);

function ON_READY() {

    /*SUPERFISH MENU*/
    $('.menu #menu').superfish({
        delay: 800,
        animation: {
            height: 'show'
        },
        speed: 'slow',
        autoArrows: false,
        dropShadows: false
    });

    $('#bgStretch').bgStretch({
        align: 'leftTop',
        //navs:$('.pagin').navs({'autoPlay':20000})
        navs: $('.pagin').navs({'autoPlay': 100000})
    })
        .sImg({
            sleep: 1000,
            spinner: $('<div class="spinner spinner_bg"></div>').css({opacity: .5}).stop().hide(3000)
        });

}

function ON_LOAD() {
    MSIE = ($.browser.msie) && ($.browser.version <= 8);
    OPR = ($.browser.opera);
    defMh = parseInt($('body').css('minHeight'));
    $('.spinner').fadeOut();


    //********** list_01 ***********
    $('.list_01>li>figure>a').attr('rel', 'appendix')
        .prepend('<span class="sitem_over"><strong></strong></span>')
    $('.list_01>li>figure>a').fancybox({
        'transitionIn': 'elastic',
        'transitionOut': 'elastic',
        'speedIn': 500,
        'speedOut': 300,
        'centerOnScroll': true,
        'overlayColor': '#000'
    });

    $('.list_01>li>figure>a')
        .find('strong').css('top', '200px').end()
        .hover(
            function () {
                if (!MSIE) {
                    $(this).children('.sitem_over').css({
                        display: 'block',
                        opacity: '0'
                    }).stop().animate({'opacity': 1}).end()
                        .find('strong').css({'opacity': 0}).stop().animate({
                        'opacity': 1,
                        'top': '0'
                    }, 350, 'easeInOutExpo');
                } else {
                    $(this).children('.sitem_over').stop().show().end()
                        .find('strong').stop().show().css({'top': '0'});
                }
            },
            function () {
                if (!MSIE) {
                    $(this).children('.sitem_over').stop().animate({'opacity': 0}, 1000, 'easeOutQuad', function () {
                        $(this).children('.sitem_over').css({display: 'none'})
                    }).end()
                        .find('strong').stop().animate({'opacity': 0, 'top': '200px'}, 1000, 'easeOutQuad');
                } else {
                    $(this).children('.sitem_over').stop().hide().end()
                        .find('strong').stop().hide();
                }
            }
        );
    //******** list_02 ***********


    $('.list_02 > li > a').hover(function () {
        $(this).stop().animate({color: "#ffffff", marginLeft: 5}, 300, "easeOutCubic")
    }, function () {
        ;
        $(this).stop().animate({color: "#dc26ae", marginLeft: 0}, 300, "easeOutCubic");
    })

    $('').each(function () {
        $(this).find('>span').stop().animate({opacity: 0}, 0);
        $(this).hover(function () {
            $(this).find('>span').stop().animate({opacity: 1}, aniButtonDuration, 'easeOutCubic')
        }, function () {
            $(this).find('>span').stop().animate({opacity: 0}, aniButtonDuration, 'easeOutCubic')
        })
    })

    //********* list_03 ************
    $('.list_03>li>figure>a').attr('rel', 'appendix')
        .prepend('<span class="sitem_over"><strong></strong></span>')
    $('.list_03>li>figure>a').fancybox({
        'transitionIn': 'elastic',
        'transitionOut': 'elastic',
        'speedIn': 500,
        'speedOut': 300,
        'centerOnScroll': true,
        'overlayColor': '#000'
    });

    $('.list_03>li>figure>a')
        .find('strong').css('top', '200px').end()
        .hover(
            function () {
                if (!MSIE) {
                    $(this).children('.sitem_over').css({
                        display: 'block',
                        opacity: '0'
                    }).stop().animate({'opacity': 1}).end()
                        .find('strong').css({'opacity': 0}).stop().animate({
                        'opacity': 1,
                        'top': '0'
                    }, 350, 'easeInOutExpo');
                } else {
                    $(this).children('.sitem_over').stop().show().end()
                        .find('strong').stop().show().css({'top': '0'});
                }
            },
            function () {
                if (!MSIE) {
                    $(this).children('.sitem_over').stop().animate({'opacity': 0}, 1000, 'easeOutQuad', function () {
                        $(this).children('.sitem_over').css({display: 'none'})
                    }).end()
                        .find('strong').stop().animate({'opacity': 0, 'top': '200px'}, 1000, 'easeOutQuad');
                } else {
                    $(this).children('.sitem_over').stop().hide().end()
                        .find('strong').stop().hide();
                }
            }
        );

    //******** list_04 ************
    $('.list_04>li>figure>a').attr('rel', 'appendix')
        .prepend('<span class="sitem_over"><strong></strong></span>')
    $('.list_04>li>figure>a').fancybox({
        'transitionIn': 'elastic',
        'transitionOut': 'elastic',
        'speedIn': 500,
        'speedOut': 300,
        'centerOnScroll': true,
        'overlayColor': '#000'
    });

    $('.list_04>li>figure>a')
        .find('strong').css('top', '200px').end()
        .hover(
            function () {
                if (!MSIE) {
                    $(this).children('.sitem_over').css({
                        display: 'block',
                        opacity: '0'
                    }).stop().animate({'opacity': 1}).end()
                        .find('strong').css({'opacity': 0}).stop().animate({
                        'opacity': 1,
                        'top': '0'
                    }, 350, 'easeInOutExpo');
                } else {
                    $(this).children('.sitem_over').stop().show().end()
                        .find('strong').stop().show().css({'top': '0'});
                }
            },
            function () {
                if (!MSIE) {
                    $(this).children('.sitem_over').stop().animate({'opacity': 0}, 1000, 'easeOutQuad', function () {
                        $(this).children('.sitem_over').css({display: 'none'})
                    }).end()
                        .find('strong').stop().animate({'opacity': 0, 'top': '200px'}, 1000, 'easeOutQuad');
                } else {
                    $(this).children('.sitem_over').stop().hide().end()
                        .find('strong').stop().hide();
                }
            }
        );
    //*************************

    //content switch
    content = $('#content');
    content.tabs({
        show: 0,
        preFu: function (_) {
            _.li.css({'visibility': 'hidden'});
            showSplashQ();
        },
        actFu: function (_) {
            if (_.n == 0) {
                showSplash()
            } else {
                if (_.curr) {
                    h = parseInt(_.curr.css('height'));
                    if (_.pren == 0) {
                        $(window).trigger('resize');
                        hideSplash2();
                    } else {
                        hideSplash();
                    }
                }
            }

            if (_.curr) h = parseInt(_.curr.outerHeight(true));
            $(window).trigger('resize');

            if (_.curr) {
                _.curr
                    .css({
                        'left': '-660px',
                        'visibility': 'visible'
                    }).stop(true).delay(400).show().animate({'left': '0px'}, {duration: 1000, easing: 'easeOutExpo'});
            }
            if (_.prev) {
                _.prev
                    .show().stop(true).animate({'left': '-660px'}, {
                    duration: 400, easing: 'easeInOutExpo', complete: function () {
                        if (_.prev) {
                            _.prev.css({'visibility': 'hidden'});
                        }
                    }
                });
            }
        }
    });
    var defColor = $('#menu>li>a').not('active').css('color');
    var nav = $('.menu');
    nav.navs({
        useHash: true,
        defHash: '#!/page_home',
        hoverIn: function (li) {
            $('>a', li).stop().animate({color: '#fff'}, 400, 'easeOutExpo');
        },
        hoverOut: function (li) {
            if ((!li.hasClass('with_ul')) || (!li.hasClass('sfHover'))) {
                $('> a', li).stop().animate({color: defColor}, 600, 'easeOutCubic');
            }
        }
    })
        .navs(function (n, _) {
            $('#content').tabs(n);
            if (_.prevHash == '#!/page_mail') {
                $('#form1 a').each(function (ind, el) {
                    if ($(this).attr('data-type') == 'reset') {
                        $(this).trigger('click')
                    }
                })
            }
        });


    //more hover---------------------------------------------------------------------------------------
    $('.button_1 .img_act').css({opacity: 0})
    $('#page_about .col_1 a').hover(function () {

        //$(this).find('span').stop(true).animate({color:'#d63332', marginLeft:5}, 250, "easeOutSine");

        if (!MSIE) {
            $(this).find('.img_act').stop().animate({opacity: 1})
            $(this).find('.img_noact').stop().animate({opacity: 0})
        } else {
            $(this).find('.img_act').css({opacity: 1})
            $(this).find('.img_noact').css({opacity: 0})
        }
    }, function () {

        //$(this).find('span').stop(true).animate({color:'#a59f9f',marginLeft:0}, 250, "easeOutSine");

        if (!MSIE) {
            $(this).find('.img_act').stop().animate({opacity: 0})
            $(this).find('.img_noact').stop().animate({opacity: 1})
        } else {
            $(this).find('.img_act').css({opacity: 0})
            $(this).find('.img_noact').css({opacity: 1})
        }
    })

    //End more hover-------------


    setTimeout(function () {
        $('body').css({'overflow': 'visible'});
    }, 300);

    $(window).trigger('resize');
}

$(window).resize(function () {
    var newMh = h;
    if (defMh > newMh) {
        newMh = defMh;
    }
    $('body').stop().animate({'minHeight': newMh})
});