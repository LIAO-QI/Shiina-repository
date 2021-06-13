function nav1_active(e) { //导航栏的按钮样式变化
	let nav1 = document.getElementsByClassName('navigation-left-item');
	for (i = 0; i < nav1.length; i++) {
		nav1[i].className = 'navigation-left-item'
	}
	e.className = 'navigation-left-item a-active'
}

function nav2_active(e) { //日周榜的按钮样式变化
	let nav1 = document.getElementsByClassName('rank-item');
	for (i = 0; i < nav1.length; i++) {
		nav1[i].className = 'rank-item'
	}
	e.className = 'rank-item a-active'
}

function nav3_active(e) { //文章标题的按钮样式变化
	let nav1 = document.getElementsByClassName('navigation-3-item');
	for (i = 0; i < nav1.length; i++) {
		nav1[i].className = 'navigation-3-item'
	}
	e.className = 'navigation-3-item a-active'
}

/* function rotation1_timer() { //轮播图1自动轮播
	let cornerBox = document.getElementById('main-1-left');
	let flag = 1;
	let count = 1;
	setInterval(function() {
		cornerBox.style.transform = 'translateX(' + String(-count * 100) + '%)';
		if (flag == 1) {
			count++;
			if (count == length - 1) {
				flag = 0;
			}
		} else if (flag == 0) {
			count--;
			if (count == 0) {
				flag = 1;
			}
		}
	}, 3000);
}

window.onload = function() {
	console.log('onload')
	rotation1_timer()
	rotation2()
} */

