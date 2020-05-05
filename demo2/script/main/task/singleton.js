// 封装选择器
const getSelector = ele => {
    return typeof ele === "string" ? document.querySelector(ele) : "";
}

const singleton = function(e) {
	
	const mask = getSelector('.mask');
	
	function taskPop(e) {
		e.appendChild(mask);
	}
	
	taskPop.prototype.show = () => {
		mask.classList.remove('mask-hide');
		mask.style.animation = 'spread 1s';
	}
	
	taskPop.prototype.hide = () => {
		mask.classList.add('mask-hide');
	}
	
	if(typeof singleton.instance === 'object'){
		return singleton.instance;
	}else{
		return singleton.instance = new taskPop(e);
	}
	
}

export {singleton};