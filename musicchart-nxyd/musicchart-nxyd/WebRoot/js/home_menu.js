$(function() {
	$(".limenu_1 span").click(function() {
		if ($(this).next().is(":hidden")) {
			$(this).next().slideToggle(300);
			$(this).prev().attr("class", "icon-caret-down");
			if ($("ul").is(":show")) {
				$(this).next().slideToggle(300);
			}
		} else {
			$(this).next().slideToggle(300);
			$(this).prev().attr("class", "icon-caret-right");
		}
	});
});
