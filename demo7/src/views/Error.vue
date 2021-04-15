<template>
	<div class="missing-box">
		<div class="logo">
			<img src="../assets/logo.png" />
		</div>
		
		<div class="title">
			404 NOT FOUND
		</div>
		
		<van-button 
			round 
			type="primary"
			@click="$router.push('/main')"
			:text="label.back"
			class="back-btn"
		>
		</van-button>
	</div>
</template>

<script>
	import {Button} from 'vant';
	
	export default {
		name :'error',
		data() {
			return {
				label: {
					back: '返 回'
				}
			};
		},
		components: {
			[Button.name] : Button
		}
	};
</script>

<style>
	.missing-box {
		width: 100vw;
		padding-top: 10vh;
		font-family: 'Times New Roman', Times, serif;
	}
	
	.logo img {
		width: 120px;
		margin-left: 50vw;
		transform: translateX(-50%);
	}
	
	.title {
		text-align: center;
		font-size: 50px;
		margin: 30px 0;
		letter-spacing: 5px;
		color: #339167;
		animation: 6s titleStyle infinite ease-in;
	}
	
	.back-btn {
		width: 80vw;
		background-color: #41b883;
		font-size: 16px;
		letter-spacing: 2px;
		margin-left: 10vw;
	}
	
	@keyframes titleStyle{
		0 {
			color: #339167;
		}
		
		50% {
			color: #35495e;
			text-shadow: 0 0 10px #41b883;
		}
		
		100% {
			color: #339167;
		}
	}
</style>