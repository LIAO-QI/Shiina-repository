<template>
	<div class="main">
		<!-- <van-overlay 
			:show="show" 
			@click="close()"
			z-index="9999"
		>
		<div class="searchInput">
			<input 
				:value="info.search" 
				:placeholder="tips.search"
				class="sInput"
				@click.stop="stopClosing()"
				@keydown="toSearch()"
			/>
		</div>
		</van-overlay> -->
		
		<van-nav-bar
			:left-text="text.title"
			z-index="999"
			fixed
			@click-right="show=true"
			class="navBar"
		>
			<!-- <template #right>
				<van-icon name="search" size="20" />
			</template> -->
			<template #right>
				<van-icon name="close" size="20" @click="logout()" />
			</template>
		</van-nav-bar>
		
		<div class="main-middle">
			<!-- 个人信息 -->
			
		</div>
		
		<van-tabbar
			v-model="text.active" 
			class="tabbar"
			z-index="999"
		>
			<van-tabbar-item icon="home-o" />
			<van-tabbar-item icon="todo-list-o" replace to="/homework" />
			<van-tabbar-item icon="calender-o" replace to="/subject" />
		</van-tabbar>
		
		
	</div>
</template>

<script>
	import {
		//Button,
		NavBar,
		Icon,
		//Overlay,
		Tabbar,
		TabbarItem 
	} from 'vant';
	
	export default {
		name:'index',
		data() {
			return {
				info: {
					search: ''
				},
				text: {
					title: '主页',
					active: 0
				},
				show: false,
				// tips: {
				// 	search: '请输入搜索的内容'
				// }
			};
		},
		components:{
			//[Button.name] : Button,
			[NavBar.name] : NavBar,
			[Icon.name] : Icon,
			//[Overlay.name] : Overlay,
			[Tabbar.name] : Tabbar,
			[TabbarItem.name] : TabbarItem
		},
		methods: {
			// toSearch() {
			// 	/* 处理搜索事务，返回搜索结果 */
			// 	if(event.keyCode == 13)
			// 		alert('结果');
			// },
			// close() {
			// 	this.show = false;
			// 	this.info.search = '';
			// },
			// stopClosing() {
			// 	let sInput = document.querySelector('.sInput');
			// 	sInput.addEventListener('click',(e) => {
			// 		e.stopPropagation();
			// 	});
			// }
			logout() {
				this.$router.push('/')
			}
		}
	};
</script>

<style>
	.main {
		width: 100vw;
		font-family: 'Times New Roman', Times, serif;
	}
	
	.navBar {
		height: 8vh;
		background-color: rgba(65,184,131,.7);
	}
	
	.searchInput {
		display: flex;
		justify-content: center;
		align-items: center;
		height: 100%;
	}
	
	.sInput {
		height: 60px;
		width: 50vw;
		padding-left: 30px;
		border-radius: 20px;
		border: 0;
		outline: 0;
	}
	
	.main-middle {
		margin-top: 8vh;
		height: 84vh;
		background: center url(../assets/logo.png) no-repeat;
		opacity: .7;
	}
	
	.tabbar {
		height: 8vh;
		background-color: rgba(65,184,131,1);
	}
</style>