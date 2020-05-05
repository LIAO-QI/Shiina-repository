// 封装选择器
const getSelector = ele => {
    return typeof ele === "string" ? document.querySelector(ele) : "";
} 

function hideMask() {
	let mask = getSelector('.mask');
	mask.addEventListener('click', () => {
		mask.classList.add('mask-hide');
	});
}

function notCloseTask() {
	let task = getSelector('.task');
	task.addEventListener('click', (e) => {
		e.stopPropagation()
	});
}

const closeMask = (() => {
	hideMask();
	notCloseTask();
})();

export {closeMask};