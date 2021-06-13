<template>
	<van-nav-bar 
		:left-text="text.title" 
		z-index="999"
		fixed
		@click-right="search()"
	>
		<template #right>
			<van-icon name="search" size="18" />
		</template>
	</van-nav-bar>
</template>

<script>
	import { NavBar } from 'vant';
	
	export default {
		name: 'header',
		data() {
			return {
				text: {
					title: '主页'
				}
			};
		},
		components: {
			[NavBar.name] : NavBar
		},
		methods: {
			search() {
				
			}
		},
		mounted() {
			(function() {
				if(this.$route.path == '/main')
					this.text.title = '主页';
				if(this.$route.path == '/homework')
					this.text.title = '作业板';
				if(this.text.title == '/subject')
					this.text.title = '课程表';
			})();
		}
	};
</script>

<style>
</style>
