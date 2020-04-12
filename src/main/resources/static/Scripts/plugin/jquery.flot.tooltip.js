/*! SmartAdmin - v1.4.1 - 2014-06-26 */
!function (a) {
    var b = {
        tooltip: !1,
        tooltipOpts: {
            content: "%s | X: %x | Y: %y.2",
            dateFormat: "%y-%0m-%0d",
            shifts: {
                x: 10,
                y: 20
            },
            defaultTheme: !0
        }
    },
    c = function (b) {
        var c = {
            x: 0, y: 0
        };
        var d = b.getOptions();
        var e = function (a) {
            c.x = a.x, c.y = a.y
        }
        var f = function (a) {
            var b = { x: 0, y: 0 }; b.x = a.pageX, b.y = a.pageY, e(b)
        };
        var g = function (b) {
            var c = new Date(b); return a.plot.formatDate(c, d.tooltipOpts.dateFormat)
        };
        b.hooks.bindEvents.push(function (b, e) {
            var i,
                j = d.tooltipOpts,
                k = b.getPlaceholder();
            if (d.tooltip !== !1) {
                if (a("#flotTip").length > 0) {
                    i = a("#flotTip")
                }
                else {
                    i = a("<div />").attr("id", "flotTip"),
                    i.appendTo("body").hide().css({ position: "absolute" }),
                    j.defaultTheme && i.css({ background: "#fff", "z-index": "100", padding: "0.4em 0.6em", "border-radius": "0.5em", "font-size": "0.8em", border: "1px solid #111" });
                }
                a(k).bind("plothover", function (a, b, e) {
                    if (e) {
                        var f;
                        f = "time" === d.xaxis.mode || "time" === d.xaxes[0].mode ? h(j.content, e, g) : h(j.content, e),
                        i.html(f).css({ left: c.x + j.shifts.x, top: c.y + j.shifts.y }).show()
                    } else i.hide().html("")
                }),
                e.mousemove(f)
            }
        });
        var h = function (a, b, c) {
            var d = /%p\.{0,1}(\d{0,})/,
                e = /%s/,
                f = /%x\.{0,1}(\d{0,})/,
                g = /%y\.{0,1}(\d{0,})/;
            "undefined" != typeof b.series.percent && (a = i(d, a, b.series.percent)),
            "undefined" != typeof b.series.label && (a = a.replace(e, b.series.label)),
            "function" == typeof c ? a = a.replace(f, c(b.series.data[b.dataIndex][0])) : "number" == typeof b.series.data[b.dataIndex][0] && (a = i(f, a, b.series.data[b.dataIndex][0])),
            "number" == typeof b.series.data[b.dataIndex][1] && (a = i(g, a, b.series.data[b.dataIndex][1]));
            return a
        },
        i = function (a, b, c) {
            var d;
            "null" !== b.match(a) && ("" !== RegExp.$1 && (d = RegExp.$1, c = c.toFixed(d)), b = b.replace(a, c));
            return b
        }
    };
    a.plot.plugins.push({
        init: c,
        options: b,
        name: "tooltip",
        version: "0.4.4"
    })
}(jQuery);