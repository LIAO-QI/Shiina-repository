<template>
	<div class="login-box">
		<div class="logo">
			<img src="../assets/logo.png" />
		</div>
		
		<div class="title">
			Login
		</div>
		
		<van-cell-group>
			<van-field 
				v-model="info.id" 
				clearable 
				:label="label.id" 
				:placeholder="tips.idTip" 
				class="id-input"
				:error-message="error.idError"
				@focus = "clearID()"
			/>
			<van-field 
				v-model="info.password" 
				clearable
				:label="label.pw"
				:placeholder="tips.pwTip" 
				class="pw-input"
				type="password"
				:error-message="error.pwError"
				@focus = "clearPW()"
			/>
		</van-cell-group>
		
		<!-- <svg class="icon" aria-hidden="true">
			<use xlink:href="#iconicon-test1"></use>
		</svg> -->
		
		<div class="btn-box">
			<van-button
				round
				type="primary" 
				@click="login()" 
				class="login-btn"
				:text="label.loginBtn"
			>
			</van-button>
			
			<van-button 
				round 
				type="primary" 
				@click="toFindPW()" 
				class="forgot-btn"
				:text="label.forgotBtn"
			>
			</van-button>
			
			<div class="btn-box_sec">
				<span>Don't have an account ?</span>
				<van-button 
					round 
					type="primary" 
					size="small"
					@click="toRegister()" 
					class="to-register-btn"
					:text="label.toRegisterBtn"
				>
				</van-button>
			</div>
			
			<div class="btn-box_third">
				<span>Just wanna take a look ?</span>
				<van-button 
					round 
					type="primary" 
					size="small"
					@click="$router.push('/main')" 
					class="tourist-btn"
					:text="label.touristsBtn"
				>
				</van-button>
			</div>
		</div>
	</div>
</template>

<script src="../boot/iconfont.js"></script>
<script>
	import {
		Button,
		CellGroup,
		Field
	} from 'vant';

	export default {
		name: 'login',
		data() {
			return {
				info: {
					id: '',
					password: ''
				},
				error: {
					idError: '',
					pwError: ''
				},
				label: {
					id: '账 号',
					pw: '密 码',
					loginBtn: 'Login',
					forgotBtn: 'Forgot password ?',
					toRegisterBtn: 'Register',
					touristsBtn: 'Tourists'
				},
				tips: {
					idTip: 'Input your username',
					pwTip: 'Input your password'
				}
			};
		},
		components: {
			[Button.name]: Button,
			[CellGroup.name]: CellGroup,
			[Field.name]: Field
		},
		methods: {
			login() {
				if (!this.info.id) {
					this.error.idError = '账号不能为空';
				}
				if (!this.info.password) {
					this.error.pwError = '密码不能为空';
				}
				if(this.info.id && this.info.password) {
					/* axios验证 */
					this.$router.push('/main');
				}
			},
			clearID() {
				this.error.idError = '';
			},
			clearPW() {
				this.error.pwError = '';
			},
			toRegister() {
				this.$router.push('/register');
			},
			toFindPW() {
				this.$router.push('/forgot');
			}
		}
	};
</script>

<style>
	/* .icon {
		width: 1em;
		height: 1em;
		vertical-align: -0.15em;
		fill: currentColor;
		overflow: hidden;
	} */

	.login-box {
		width: 100vw;
		padding-top: 10vh;
		font-family: 'Times New Roman', Times, serif;
	}

	.logo img {
		width: 120px;
		margin-left: 50vw;
		transform: translateX(-50%);
	}

	.id-input,
	.pw-input {
		font-size: 16px;
		padding-left: 8vw;
		padding-top: 10px;
		padding-bottom: 10px;
	}
	
	.title {
		text-align: center;
		font-size: 50px;
		margin-bottom: 25px;
		letter-spacing: 5px;
		color: #339167;
		animation: 6s titleStyle infinite ease-in;
	}
	
	.btn-box {
		display: flex;
		flex-direction: column;
		align-items: center;
		margin-top: 30px;
	}
	
	.login-btn {
		width: 80vw;
		background-color: #41b883;
		font-size: 20px;
		letter-spacing: 2px;
	}
	
	.forgot-btn {
		background-color: inherit;
		border: 0;
		color: black;
	}
	
	.btn-box_sec {
		margin: 10px 0;
	}
	
	.to-register-btn
	,.tourist-btn{
		margin-left: 10px;
		background-color: #41b883;
		letter-spacing: 1px;
		font-size: 14px;
	}
	
	.login-btn:hover,
	.to-register-btn:hover
	,.tourist-btn:hover{
		color: black;
		background-color: #339167;
		transition: background-color .5s; 
	}

	@keyframes titleStyle{
		0 {
			color: #339167;
			/* transform: scale(1.2); */
		}
		
		50% {
			color: #35495e;
			text-shadow: 0 0 10px #41b883;
			/* transform: scale(0.8); */
		}
		
		100% {
			color: #339167;
		}
	}
</style>