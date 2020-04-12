import {singleton} from './singleton.js';

// 封装选择器
const getSelector = ele => {
    return typeof ele === "string" ? document.querySelector(ele) : "";
}

const cancelTask = (() => {
	let cancel_btn = getSelector('#cancel-task'),
		task_index = getSelector('#index');
		
	cancel_btn.onclick = () => { 
		new singleton(task_index).hide();
	}
})();

export {cancelTask};