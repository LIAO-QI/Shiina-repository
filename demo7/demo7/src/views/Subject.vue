<template>
	<div class="main">
		<van-overlay 
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
		</van-overlay>
		
		<van-nav-bar
			:left-text="text.title"
			z-index="999"
			fixed
			@click-right="show=true"
			class="navBar"
		>
			<template #right>
				<van-icon name="search" size="20" />
			</template>
		</van-nav-bar>
		
		<div class="subject-middle">
			<!-- 课程信息 -->
			<van-row type="flex">
				<van-col span="4">span: 8</van-col>
				<van-col span="4">span: 8</van-col>
				<van-col span="4">span: 8</van-col>
				<van-col span="4">span: 8</van-col>
				<van-col span="4">span: 8</van-col>
				<van-col span="4">span: 8</van-col>
			</van-row>
			<van-row>
				<van-col span="4">span: 8</van-col>
				<van-col span="4">span: 8</van-col>
				<van-col span="4">span: 8</van-col>
				<van-col span="4">span: 8</van-col>
				<van-col span="4">span: 8</van-col>
				<van-col span="4">span: 8</van-col>
			</van-row>
			
			
			
		</div>
		
		<van-tabbar
			v-model="text.active" 
			class="tabbar"
			z-index="999"
		>
			<van-tabbar-item icon="home-o" replace to="/main" />
			<van-tabbar-item icon="todo-list-o" replace to="/homework" />
			<van-tabbar-item icon="calender-o" />
		</van-tabbar>
		
		
	</div>
</template>

<script>
	import {
		Button,
		NavBar,
		Icon,
		Overlay,
		Tabbar,
		TabbarItem,
		Col,
		Row
	} from 'vant';
	
	export default {
		name:'subject',
		data() {
			return {
				info: {
					search: ''
				},
				text: {
					title: '课程表',
					active: 2
				},
				show: false,
				tips: {
					search: '请输入搜索的内容'
				}
			};
		},
		components:{
			[Button.name] : Button,
			[NavBar.name] : NavBar,
			[Icon.name] : Icon,
			[Overlay.name] : Overlay,
			[Tabbar.name] : Tabbar,
			[TabbarItem.name] : TabbarItem,
			[Col.name] : Col,
			[Row.name] : Row
		},
		methods: {
			toSearch() {
				/* 处理搜索事务，返回搜索结果 */
				if(event.keyCode == 13)
					alert('结果');
			},
			close() {
				this.show = false;
				this.info.search = '';
			},
			stopClosing() {
				let sInput = document.querySelector('.sInput');
				sInput.addEventListener('click',(e) => {
					e.stopPropagation();
				});
			}
		}
	};
</script>

<link rel="stylesheet" href="../bootstrap.min.css" />
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
	
	.subject-middle {
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