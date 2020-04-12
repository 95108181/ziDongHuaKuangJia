if (IScroll) {
    (function () {
        var usedIScroll = function () {
            var kws = ["iPhone", "android", "Windows", "Mac OS X"];
            var ua = navigator.userAgent.toLowerCase();
            for (var i = 0; i < kws.length; ++i) {
                var kw = kws[i].toLowerCase();
                if (ua.indexOf(kw) >= 0)
                    return true;
            }
            return false;
        };

        window.IScrollExtend = function (ele, callback, onlyBottom) {
            var sf = this;
            var of = 60;
            var cb = callback;
            var $wrp = $(ele);
            if (typeof (cb) != 'function')
                cb = function (pageIndex, pageSize, cbk) { cbk(0); }
            var addClass = function (obj, cls) {
                var prevCls = obj.className.split(/ +/);
                if (prevCls.indexOf(cls) >= 0) {
                    return;
                }
                prevCls.push(cls);
                obj.className = prevCls.join(" ");
            }
            var removeClass = function (obj, cls) {
                var prevCls = obj.className.split(/ +/);
                var idx = -1;
                while ((idx = prevCls.indexOf(cls)) >= 0) {
                    prevCls.splice(idx, 1);
                }
                obj.className = prevCls.join(" ");
            }
            var clsInfo = {
                top: $wrp.find(".nscroll-top")[0],
                bottom: $wrp.find(".nscroll-bottom")[0],

                shouldLoading: "nscroll-should-loading",
                isTopShouldLoading: false,
                isBottomShouldLoading: false,

                loading: "nscroll-loading",
                isTopLoading: false,
                isBottomLoading: false,

                loadFinish: "nscroll-load-finish",
                isBottomLoadFinish: false,

                show: "nscroll-loading-shown",
                isTopShow: false,
                isBottomShow: false
            };
            var setShouldLoading = function (isTop, b) {
                if (isTop) {
                    if (clsInfo.isTopShouldLoading == b) {
                        return;
                    }
                    if (b) {
                        addClass(clsInfo.top, clsInfo.shouldLoading);
                    }
                    else {
                        removeClass(clsInfo.top, clsInfo.shouldLoading);
                    }
                    clsInfo.isTopShouldLoading = b;
                }
                else {
                    if (clsInfo.isBottomShouldLoading == b) {
                        return;
                    }
                    if (b) {
                        addClass(clsInfo.bottom, clsInfo.shouldLoading);
                    }
                    else {
                        removeClass(clsInfo.bottom, clsInfo.shouldLoading);
                    }
                    clsInfo.isBottomShouldLoading = b;
                }
            };
            var setLoading = function (isTop, b) {
                if (isTop) {
                    if (clsInfo.isTopLoading == b) {
                        return;
                    }
                    if (b) {
                        addClass(clsInfo.top, clsInfo.loading);
                    }
                    else {
                        removeClass(clsInfo.top, clsInfo.loading);
                    }
                    clsInfo.isTopLoading = b;
                }
                else {
                    if (clsInfo.isBottomLoading == b) {
                        return;
                    }
                    if (b) {
                        addClass(clsInfo.bottom, clsInfo.loading);
                    }
                    else {
                        removeClass(clsInfo.bottom, clsInfo.loading);
                    }
                    clsInfo.isBottomLoading = b;
                }
            };
            var setLoadFinish = function (b) {
                if (clsInfo.isBottomLoadFinish == b) {
                    return;
                }
                if (b) {
                    addClass(clsInfo.bottom, clsInfo.loadFinish);
                }
                else {
                    removeClass(clsInfo.bottom, clsInfo.loadFinish);
                }
                clsInfo.isBottomLoadFinish = b;
            };

            var pageInfo = {
                pageIndex: 0,
                pageSize: 10,
                pageCount: 0,
                record: 0
            };

            var refreshLoadFinish = function () {
                iscroll.refresh();
                pageInfo.pageCount = Math.ceil(pageInfo.record / pageInfo.pageSize);
                var isFinish = pageInfo.pageIndex + 1 >= pageInfo.pageCount;
                setLoadFinish(isFinish);
                iscroll.options.overflowBottomHeight = 0;
            }
            var _isScroll = false;
            var _scrollY = 0;
            var _touchEnd = function (e) {
                try {
                    if (_isScroll) {
                        e.preventDefault();
                    }
                    if (iscroll.y > of) {
                        iscroll.options.overflowTopHeight = of;
                        setLoading(true, true);
                        pageInfo.pageIndex = 0;
                        setTimeout(function () {
                            cb(pageInfo.pageIndex, pageInfo.pageSize, function (record) {
                                pageInfo.record = record >= 0 ? record : pageInfo.record;
                                setLoading(true, false);
                                setShouldLoading(true, false);
                                iscroll.options.overflowTopHeight = 0;
                                iscroll.resetPosition(iscroll.options.bounceTime);
                                refreshLoadFinish();
                            });
                        }, 0);
                    }
                    else if (iscroll.y < iscroll.maxScrollY - of && !clsInfo.isBottomLoadFinish) {
                        iscroll.options.overflowBottomHeight = of;
                        setLoading(false, true);
                        ++pageInfo.pageIndex;
                        setTimeout(function () {
                            cb(pageInfo.pageIndex, pageInfo.pageSize, function (record) {
                                pageInfo.record = record >= 0 ? record : pageInfo.record;
                                setShouldLoading(false, false);
                                setLoading(false, false);
                                iscroll.options.overflowBottomHeight = 0;
                                iscroll.resetPosition(iscroll.options.bounceTime);
                                refreshLoadFinish();
                            });
                        }, 0);
                    }
                }
                catch (ex) {
                }
            };
            var _touchStart = function (e) {
                _isScroll = false;
                if (iscroll)
                    _scrollY = iscroll.y;
            };
            if ('ontouchend' in document) {
                $wrp[0].addEventListener("touchstart", _touchStart, false);
                $wrp[0].addEventListener("touchend", _touchEnd, false);
            }
            else {
                $wrp.bind("mousedown", _touchStart);
                $wrp.bind("mouseup", _touchEnd);
                $wrp.bind("click", function (e) {
                    if (_isScroll) {
                        e.preventDefault();
                    }
                })
            }
            var iscroll = null;

            if (!onlyBottom && usedIScroll()) {
                //if (true) {
                iscroll = new IScroll(ele, {
                    probeType: 2,
                    mouseWheel: true,
                    scrollbars: true,
                    fadeScrollbars: true,
                    shrinkScrollbars: 'clip',
                    snapThreshold: 0.667,
                    click: true,
                    tap: true,
                    useTransition: true
                });
                iscroll.on('scroll', function () {
                    _isScroll = _isScroll || Math.abs(iscroll.y - _scrollY) > 10;
                    if (iscroll.y > of) {
                        setShouldLoading(true, true);
                    }
                    else {
                        setShouldLoading(true, false);
                    }
                    if (clsInfo.isBottomLoadFinish)
                        return;
                    if (iscroll.y < iscroll.maxScrollY - of) {
                        setShouldLoading(false, true);
                    }
                    else {
                        setShouldLoading(false, false);
                    }
                });
                //document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
                sf.scrollTo = function () {
                    iscroll.scrollTo.apply(iscroll, arguments);
                }

                sf.scrollBy = function () {
                    iscroll.scrollBy.apply(iscroll, arguments);
                }
                sf.reload = function () {
                    iscroll.options.overflowTopHeight = of;
                    iscroll.scrollTo(0, of, iscroll.options.bounceTime);
                    setLoading(true, true);
                    pageInfo.pageIndex = 0;
                    setTimeout(function () {
                        cb(pageInfo.pageIndex, pageInfo.pageSize, function (record) {
                            pageInfo.record = record >= 0 ? record : pageInfo.record;
                            setLoading(true, false);
                            setShouldLoading(true, false);
                            iscroll.options.overflowTopHeight = 0;
                            iscroll.resetPosition(iscroll.options.bounceTime);
                            refreshLoadFinish();
                        });
                    }, 0);
                };
                sf.nextPage = function () {
                    if (!clsInfo.isBottomLoadFinish) {
                        iscroll.options.overflowBottomHeight = of;
                        setLoading(false, true);
                        ++pageInfo.pageIndex;
                        setTimeout(function () {
                            cb(pageInfo.pageIndex, pageInfo.pageSize, function (record) {
                                pageInfo.record = record >= 0 ? record : pageInfo.record;
                                setShouldLoading(false, false);
                                setLoading(false, false);
                                iscroll.options.overflowBottomHeight = 0;
                                iscroll.resetPosition(iscroll.options.bounceTime);
                                refreshLoadFinish();
                            });
                        }, 0);
                    }
                };
                sf.gjhScroll = iscroll;
                sf.gjhRefresh = function () {
                    iscroll.refresh();
                };
            }
            else {
                $wrp.css({ overflow: "auto", top: "auto" });
                $wrp.find(".nscroll-loading-box").remove();
                var $wrpIn = $wrp.children(":eq(0)");
                var $loadss = $("<div class='drag-show-load'>拖动加载</div>");
                var isLoadFinish = false;
                var startLoad = function () {
                    setTimeout(function () {
                        cb(pageInfo.pageIndex, pageInfo.pageSize, function (record) {
                            pageInfo.record = record >= 0 ? record : pageInfo.record;
                            pageInfo.pageCount = Math.ceil(pageInfo.record / pageInfo.pageSize);
                            isLoaded = false;
                            if (pageInfo.pageIndex + 1 >= pageInfo.pageCount) {
                                isLoadFinish = true;
                                $loadss.text("");
                            }
                            else {
                                isLoadFinish = false;
                                $loadss.text("拖动加载");
                            }
                        });
                    }, 0);
                };
                $wrpIn.append($loadss);
                var isLoaded = false;
                $wrp.scroll(function (evt) {
                    if ($(this).scrollTop() + $(this).outerHeight(false) >= $wrpIn.outerHeight(false)) {
                        if (!isLoaded && !isLoadFinish) {
                            isLoaded = true;
                            $loadss.text("正在加载...");
                            sf.nextPage();
                        }
                    }
                    else {
                        if (isLoaded) {
                            isLoaded = false;
                            $loadss.text("拖动加载");
                        }
                    }
                });
                sf.reload = function () {
                    pageInfo.pageIndex = 0;
                    startLoad();
                };
                sf.nextPage = function () {
                    ++pageInfo.pageIndex;
                    startLoad();
                };
                sf.gjhRefresh = function () {
                    ;
                };
            }
            sf.reload();
        };
    })(jQuery);
}