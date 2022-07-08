//0.3.2
(function ($) {
    $.fn.bgStretch = function (o) {
        this.each(function () {
            var th = $(this),
                data = th.data('bgStretch'),
                _ = {
                    align: 'leftTop',
                    altCSS: {},
                    css: {
                        leftTop: {
                            left: 0,
                            right: 'auto',
                            top: 0,
                            bottom: 'auto'
                        },
                        rightTop: {
                            left: 'auto',
                            right: 0,
                            top: 0,
                            bottom: 'auto'
                        },
                        leftBottom: {
                            left: 0,
                            right: 'auto',
                            top: 'auto',
                            bottom: 0
                        },
                        rightBottom: {
                            left: 'auto',
                            right: 0,
                            top: 'auto',
                            bottom: 0
                        }
                    },
                    preFu: function () {
                        _.img
                            .load(function () {
                                _.checkWidthFu()
                                _.img
                                    .css({
                                        width: '100%',
                                        height: '100%',
                                        position: 'absolute',
                                        zIndex: -1,
                                        left: 0,
                                        top: 0
                                    })
                                $(window).trigger('resize')
                                return false
                            })
                        _.img[0].complete
                        && _.img.trigger('load')
                        _.me
                            .css({
                                position: 'absolute',
                                zIndex: -1
                            })
                            .css($.extend(_.css[_.aalign = _.align], _.altCSS))
                        _.wrap
                            .css({
                                width: '100%',
                                height: '100%',
                                position: 'fixed',
                                left: 0,
                                top: 0,
                                overflow: 'hidden',
                                zIndex: -1
                            })
                    },
                    checkWidthFu: function () {
                        var i = $('<img>')
                        i
                            .css({
                                position: 'absolute'
                                , left: '-999%'
                                , top: '-999%'
                            })
                            .appendTo('body')
                            .load(function () {
                                _.k = i.height() / i.width()
                                _.resizeFu()
                                i.remove()
                            })
                            .attr({src: _.img.attr('src')})
                    },
                    resizeFu: function () {
                        var wh = _.win.height(),
                            ww = _.win.width(),
                            k = wh / ww
                        if (_.aalign != _.align)
                            _.me
                                .css(_.css[_.aalign = _.align])

                        if (k < _.k)
                            _.me
                                .css({
                                    width: ww,
                                    height: ww * _.k
                                })
                        else
                            _.me
                                .css({
                                    width: wh / _.k,
                                    height: wh
                                })

                    },
                    chngFu: function (str) {
                        $.fn.sImg
                            ? _.me.sImg(str)
                            : _.img.attr({src: str})
                    },
                    init: function () {
                        _.win = $(window)
                        _.img = $('img', _.me)
                        _.me.wrap('<div></div>')
                        _.wrap = _.me.parent()

                        _.preFu()
                        $(window)
                            .resize(function () {
                                _.resizeFu()
                            })
                            .trigger('resize')
                        _.navs && _.navs.data('navs')
                        && _.navs.navs(function (n, __) {
                            _.chngFu(__.href)
                        })

                    }
                }
            data ? _ = data : th.data({bgStretch: _})
            typeof o == 'object' && (_ = $.extend(true, _, o))
            _.me || _.init(_.me = th)

            typeof o == 'string' && _.chngFu(o)
        })
        return this
    }
})(jQuery)