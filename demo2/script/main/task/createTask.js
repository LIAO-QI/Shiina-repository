import {singleton} from './singleton.js';

// 封装选择器
const getSelector = ele => {
    return typeof ele === "string" ? document.querySelector(ele) : "";
}

const createTask = (() => {
	let create_btn = getSelector('#creat-task'),
		task_index = getSelector('#index');
		
	create_btn.onclick = () => { 
		new singleton(task_index).show();
	}
})();

export {createTask};