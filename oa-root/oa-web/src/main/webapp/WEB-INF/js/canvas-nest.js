!function() {
    /**
     * 获取指定标签中指定属性值,并设置默认值
     * @param node [element]标签
     * @param attr [String]属性名
     * @param defaultValue [Object]属性值
     * @return [Object]属性值
     */
    function getAttribute(node, attr, defaultValue) {
        return node.getAttribute(attr) || defaultValue;
    }
    /**
     * 通过标签名查找元素
     * @param tagName [String]标签名称
     * @return [Array]标签数组
     */
    function getByTagName(tagName) {
        return document.getElementsByTagName(tagName);
    }
    /**
     * 获取配置参数
     * @return [Object]配置参数集合
     */
    function getConfigOption() {
        var scripts = getByTagName("script");
        var scriptLen = scripts.length;
        // 当前加载的script标签
        var script = scripts[scriptLen - 1];
        return {
            length: scriptLen, // 长度,用于生成canvas id
            zIndex: getAttribute(script, "zIndex", -1),
            opacity: getAttribute(script, "opacity", 0.5),
            color: getAttribute(script, "color", "0,0,0"),
            count: getAttribute(script, "count", 99)
        };
    }
    /**
     * 设置nestCanvas的高度和宽度
     * @param nestCanvas [canvas]画布
     * @param nestCanvasSize [Object]画布的长宽
     */
    function setNestCanvasSize(nestCanvas, nestCanvasSize) {
        nestCanvasSize.width = nestCanvas.width = 
            window.innerWidth ||
            document.documentElement.clientWidth ||
            document.body.clientWidth;
        nestCanvasSize.height = nestCanvas.height = 
            window.innerHeight ||
            document.documentElement.clientHeight ||
            document.body.clientHeight;
    }
    /**
     * 绘制过程
	 * @param context [Object]画布内容
	 * @param nestCanvasSize [Object]画布长宽
	 * @param allPoints [Object]随机点和鼠标坐标点信息数组
     */
    function drawNestCanvas(context, nestCanvasSize, allPoints) {
        var width = nestCanvasSize.width;
        var height = nestCanvasSize.height;
        context.clearRect(0, 0, width, height);
        // 遍历处理每一个点移动坐标
        for(var i = 0, length = allPoints.length - 1; i < length; i ++) {
			var point = allPoints[i];
            point.x += point.offSetX;
            point.y += point.offSetY; // 移动
            point.offSetX *= 
                point.x > width || point.x < 0 ? -1 : 1;
            point.offSetY *= 
                point.y > height || point.y < 0 ? -1 : 1; // 触底反弹
            // 绘制一个宽高为1的点
            context.fillRect(point.x - 0.5, point.y - 0.5, 1, 1);
            
        };
		// 遍历处理点和点之间的线段关系
		for(var i = 0, length = allPoints.length - 1; i < length; i ++) {
			// 当前的点
			var currPoint = allPoints[i];
			for(var k = i + 1; k < allPoints.length; k ++) {
				// 偏移点
				var point = allPoints[k];
				// 偏移点是否存在
				if(point.x != null && point.y != null) {
					var distX = currPoint.x - point.x; // x轴距离
					var distY = currPoint.y - point.y; // y轴距离
					// 两点之间的距离的平方
					var dist = distX * distX + distY * distY;
					if(dist < point.max) {
						// 当偏移点是鼠标所在的点,并且当前点接近的时候,会被吸引,靠近时会加速
						if(k == allPoints.length - 1 && dist >= point.max / 2) {
							currPoint.x -= 0.03 * distX;
							currPoint.y -= 0.03 * distY;
						}
						// 距离比值参数,距离越近,值越大
						var nest = (point.max - dist) / point.max;
						context.beginPath(); // 开启新的画笔,不然每次绘制的内容都是连成一条直线的
						context.lineWidth = nest; // 线段宽度
						context.strokeStyle = "rgba(" + config.color + "," + (nest + 0.2) + ")"; // 线段颜色及透明度
						context.moveTo(currPoint.x, currPoint.y);
						context.lineTo(point.x, point.y);
						context.stroke();
					}
				}
			}
		}
        // 动画效果
        frameFunction(function() {
            drawNestCanvas(context, nestCanvasSize, allPoints);
        });
    }
	
    // 创建画布
    var nestCanvas = document.createElement("canvas");
    // 配置
    var config = getConfigOption();
    // canvas id
    var canvasId = "nest_canvas_" + config.length;
    nestCanvas.id = canvasId;
    // 画布主体内容
    var context = nestCanvas.getContext("2d");
    // 画布的长宽
    var nestCanvasSize = {
        width  : null,
        height : null
    };
    // 动画效果,每隔一段时间重新绘制画布
    var frameFunction = window.requestAnimationFrame ||
        window.webkitRequestAnimationFrame ||
        window.mozRequestAnimationFrame ||
        window.oRequestAnimationFrame ||
        window.msRequestAnimationFrame ||
        function(callback) {
            window.setTimeout(callback, 1000 / 45);
        };
    // 随机函数
    var random = Math.random;
    // 设置画布css
    nestCanvas.style.cssText = 
		"position : fixed; " +
		"top : 0; left : 0; " +
		"z-index : " + config.zIndex + "; " + 
		"opacity : " + config.opacity + ";";
    // 把画布放入body标签中
    getByTagName("body")[0].appendChild(nestCanvas);
    // 初始化画布大小
    setNestCanvasSize(nestCanvas, nestCanvasSize);
    // 在改变浏览器窗口大小的时候改变画布大小
    window.onresize = function () {
        setNestCanvasSize(nestCanvas, nestCanvasSize);
    }
	// 当前鼠标位置坐标
    var mousePoint = {
        x : null,
        y : null,
        max : 20000 // 圈半径平方
    };
    // 生成随机点
    var randomPoints = [];
    for(var i = 0; i < config.count; i ++) {
        // 随机位置
        var x = random() * nestCanvasSize.width;
        var y = random() * nestCanvasSize.height;
        // 随机运动方向
        var offSetX = 2 * random() - 1;
        var offSetY = 2 * random() - 1;
        // 保存随机点
        randomPoints.push({
            x : x,
            y : y,
            offSetX : offSetX,
            offSetY : offSetY,
            max : 6000 // 粘附距离
        });
    }
	// 随机点坐标 + 鼠标当前位置坐标 = 所有点坐标
	var allPoints	 = randomPoints.concat([mousePoint]);
	// 鼠标移入画布事件
    window.onmousemove = function(e) {
		e = e || window.event;
		mousePoint.x = e.clientX;
		mousePoint.y = e.clientY;
	};
    // 鼠标移出画布事件
	window.onmouseout = function() {
		mousePoint.x = null;
		mousePoint.y = null;
	};
    // 0.1秒绘制画布
    window.setTimeout(function() {
        drawNestCanvas(context, nestCanvasSize, allPoints);
    }, 100);
}();