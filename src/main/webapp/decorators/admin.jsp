<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard - Ace Admin</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>    
    <link rel="stylesheet" href="<c:url value='/template/admin/css/bootstrap.min.css'></c:url>" />
    <link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.2.0/css/font-awesome.min.css'></c:url>" />
    <link rel="stylesheet" href="<c:url value='/template/admin/fonts/fonts.googleapis.com.css'></c:url>" />
    <link rel="stylesheet" href="<c:url value='/template/admin/css/ace.min.css'></c:url>" />
    <script src="<c:url value='/template/admin/js/ace-extra.min.js'></c:url>"></script>
    <script src="<c:url value='/template/paging/jquery.twbsPagination.js'></c:url>"></script>
</head>
<body class="no-skin">
		<!-- header -->
		<%@include file="/common/admin/header.jsp"%>
		<!-- header -->
		<div class="main-container" id="main-container">
			<!-- Menu -->
			<%@include file="/common/admin/menu.jsp"%>
			<!-- Menu -->
			<dec:body></dec:body>
		</div>
		
		<!-- footer -->
		<%@include file="/common/admin/footer.jsp"%>
		<!-- footer -->
		
        <script type="text/javascript">
            window.jQuery || document.write("<script src="<c:url value='/template/admin/js/jquery.min.js'></c:url>">" + "<" + "/script>");
        </script>

        <script type="text/javascript">
            if ('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
        </script>
        <script src="<c:url value='/template/admin/js/bootstrap.min.js'></c:url>"></script>
        <script src="<c:url value='/template/admin/js/jquery-ui.custom.min.js'></c:url>"></script>
        
        <script src="<c:url value='/template/admin/js/jquery.ui.touch-punch.min.js'></c:url>"></script>
        <script src="<c:url value='/template/admin/js/jquery.easypiechart.min.js'></c:url>"></script>
        <script src="<c:url value='/template/admin/js/jquery.sparkline.min.js'></c:url>"></script>
        <script src="<c:url value='/template/admin/js/jquery.flot.min.js'></c:url>"></script>
        <script src="<c:url value='/template/admin/js/jquery.flot.pie.min.js'></c:url>"></script>
        <script src="<c:url value='/template/admin/js/jquery.flot.resize.min.js'></c:url>"></script>
        <script src="<c:url value='/template/admin/js/ace-elements.min.js'></c:url>"></script>
        <script src="<c:url value='/template/admin/js/ace.min.js'></c:url>"></script>
        <!-- <script type="text/javascript">
            jQuery(function ($) {
                $('.easy-pie-chart.percentage').each(function () {
                    var $box = $(this).closest('.infobox');
                    var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
                    var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
                    var size = parseInt($(this).data('size')) || 50;
                    $(this).easyPieChart({
                        barColor: barColor,
                        trackColor: trackColor,
                        scaleColor: false,
                        lineCap: 'butt',
                        lineWidth: parseInt(size / 10),
                        animate: /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase()) ? false : 1000,
                        size: size
                    });
                })

                $('.sparkline').each(function () {
                    var $box = $(this).closest('.infobox');
                    var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
                    $(this).sparkline('html',
                        {
                            tagValuesAttribute: 'data-values',
                            type: 'bar',
                            barColor: barColor,
                            chartRangeMin: $(this).data('min') || 0
                        });
                });


                $.resize.throttleWindow = false;

                var placeholder = $('#piechart-placeholder').css({ 'width': '90%', 'min-height': '150px' });
                var data = [
                    { label: "social networks", data: 38.7, color: "#68BC31" },
                    { label: "search engines", data: 24.5, color: "#2091CF" },
                    { label: "ad campaigns", data: 8.2, color: "#AF4E96" },
                    { label: "direct traffic", data: 18.6, color: "#DA5430" },
                    { label: "other", data: 10, color: "#FEE074" }
                ]
                function drawPieChart(placeholder, data, position) {
                    $.plot(placeholder, data, {
                        series: {
                            pie: {
                                show: true,
                                tilt: 0.8,
                                highlight: {
                                    opacity: 0.25
                                },
                                stroke: {
                                    color: '#fff',
                                    width: 2
                                },
                                startAngle: 2
                            }
                        },
                        legend: {
                            show: true,
                            position: position || "ne",
                            labelBoxBorderColor: null,
                            margin: [-30, 15]
                        }
                        ,
                        grid: {
                            hoverable: true,
                            clickable: true
                        }
                    })
                }
                drawPieChart(placeholder, data);

                placeholder.data('chart', data);
                placeholder.data('draw', drawPieChart);


                //pie chart tooltip example
                var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
                var previousPoint = null;

                placeholder.on('plothover', function (event, pos, item) {
                    if (item) {
                        if (previousPoint != item.seriesIndex) {
                            previousPoint = item.seriesIndex;
                            var tip = item.series['label'] + " : " + item.series['percent'] + '%';
                            $tooltip.show().children(0).text(tip);
                        }
                        $tooltip.css({ top: pos.pageY + 10, left: pos.pageX + 10 });
                    } else {
                        $tooltip.hide();
                        previousPoint = null;
                    }

                });

                /////////////////////////////////////
                $(document).one('ajaxloadstart.page', function (e) {
                    $tooltip.remove();
                });




                var d1 = [];
                for (var i = 0; i < Math.PI * 2; i += 0.5) {
                    d1.push([i, Math.sin(i)]);
                }

                var d2 = [];
                for (var i = 0; i < Math.PI * 2; i += 0.5) {
                    d2.push([i, Math.cos(i)]);
                }

                var d3 = [];
                for (var i = 0; i < Math.PI * 2; i += 0.2) {
                    d3.push([i, Math.tan(i)]);
                }


                var sales_charts = $('#sales-charts').css({ 'width': '100%', 'height': '220px' });
                $.plot("#sales-charts", [
                    { label: "Domains", data: d1 },
                    { label: "Hosting", data: d2 },
                    { label: "Services", data: d3 }
                ], {
                    hoverable: true,
                    shadowSize: 0,
                    series: {
                        lines: { show: true },
                        points: { show: true }
                    },
                    xaxis: {
                        tickLength: 0
                    },
                    yaxis: {
                        ticks: 10,
                        min: -2,
                        max: 2,
                        tickDecimals: 3
                    },
                    grid: {
                        backgroundColor: { colors: ["#fff", "#fff"] },
                        borderWidth: 1,
                        borderColor: '#555'
                    }
                });


                $('#recent-box [data-rel="tooltip"]').tooltip({ placement: tooltip_placement });
                function tooltip_placement(context, source) {
                    var $source = $(source);
                    var $parent = $source.closest('.tab-content')
                    var off1 = $parent.offset();
                    var w1 = $parent.width();

                    var off2 = $source.offset();
                    //var w2 = $source.width();

                    if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2)) return 'right';
                    return 'left';
                }


                $('.dialogs,.comments').ace_scroll({
                    size: 300
                });
                var agent = navigator.userAgent.toLowerCase();
                if ("ontouchstart" in document && /applewebkit/.test(agent) && /android/.test(agent))
                    $('#tasks').on('touchstart', function (e) {
                        var li = $(e.target).closest('#tasks li');
                        if (li.length == 0) return;
                        var label = li.find('label.inline').get(0);
                        if (label == e.target || $.contains(label, e.target)) e.stopImmediatePropagation();
                    });

                $('#tasks').sortable({
                    opacity: 0.8,
                    revert: true,
                    forceHelperSize: true,
                    placeholder: 'draggable-placeholder',
                    forcePlaceholderSize: true,
                    tolerance: 'pointer',
                    stop: function (event, ui) {
                        $(ui.item).css('z-index', 'auto');
                    }
                }
                );
                $('#tasks').disableSelection();
                $('#tasks input:checkbox').removeAttr('checked').on('click', function () {
                    if (this.checked) $(this).closest('li').addClass('selected');
                    else $(this).closest('li').removeClass('selected');
                });

                $('#task-tab .dropdown-hover').on('mouseenter', function (e) {
                    var offset = $(this).offset();

                    var $w = $(window)
                    if (offset.top > $w.scrollTop() + $w.innerHeight() - 100)
                        $(this).addClass('dropup');
                    else $(this).removeClass('dropup');
                });

            })
        </script> -->
</body>
</html>
