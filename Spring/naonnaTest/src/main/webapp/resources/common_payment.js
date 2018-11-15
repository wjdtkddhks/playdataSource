(function (jq) {
	var showLoadingSpin = function(layerSelector) {
		jq(layerSelector).show();
		var opts = {
			lines: 9 // The number of lines to draw
			, length: 8 // The length of each line
			, width: 4 // The line thickness
			, radius: 10 // The radius of the inner circle
			, scale: 1 // Scales overall size of the spinner
			, corners: 1 // Corner roundness (0..1)
			, color: '#FFFFFF' // #rgb or #rrggbb or array of colors
			, opacity: 0.25 // Opacity of the lines
			, rotate: 0 // The rotation offset
			, direction: 1 // 1: clockwise, -1: counterclockwise
			, speed: 1 // Rounds per second
			, trail: 60 // Afterglow percentage
			, fps: 20 // Frames per second when using setTimeout() as a fallback for CSS
			, zIndex: 2e9 // The z-index (defaults to 2000000000)
			, className: 'spinner' // The CSS class to assign to the spinner
			, top: '50%' // Top position relative to parent
			, left: '50%' // Left position relative to parent
			, shadow: false // Whether to render a shadow
			, hwaccel: false // Whether to use hardware acceleration
			, position: 'absolute' // Element positioning
		}
		var target = document.getElementById("spin");
		var spinner = new Spinner(opts).spin(target);
		target.appendChild(spinner.el);
	};

	var cancelRequest = function (hash, isCancelPost, blockEvent, postSelector) {
		jq.ajax({
			url: "/v1/" + hash + "/cancel",
			type: "GET",
			cache: false
		}).done(function (resp) {
			blockEvent();
			moveToUrl(isCancelPost, resp.cancel_url, postSelector);
		}).fail(function (xhr, textStatus, error) {
			/*
			 *	abuse case : tid convert, tid 조회 실패
			 *	or network issue
			 * */
		});
	};

	var moveToUrl = function (isPost, url, postSelector) {
		if (isPost) {
			if (postSelector) {
				jq(postSelector).attr('action', url).submit();
			}
		} else {
			window.location.replace(url);
		}
	};

	window.teslaCommonPayment = {
		"showSpin": showLoadingSpin,
		"paymentStop": cancelRequest,
		"redirectToUrlWithMethod": moveToUrl
	};

})(jQuery);



