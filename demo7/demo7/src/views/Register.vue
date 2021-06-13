<template>
	<div class="register-box">
		<div class="logo">
			<img src="../assets/logo.png" />
		</div>
		
		<div class="title">
			Register
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
				v-model="info.name" 
				clearable 
				:label="label.name" 
				:placeholder="tips.nameTip" 
				class="name-input"
				:error-message="error.nameError"
				@focus = "clearNAME()"
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
		
		<div class="btn-box">
			<van-button 
				round 
				type="primary" 
				@click="register()" 
				class="register-btn"
				:text="label.registerBtn"
			>
			</van-button>
			
			<div class="btn-box_sec">
				<span>Already have an account ?</span>
				<van-button 
					round 
					type="primary" 
					size="small"
					@click="$router.push('/')" 
					class="to-login-btn"
					:text="label.toLoginBtn"
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
					name: '',
					password: ''
				},
				error: {
					idError: '',
					nameError: '',
					pwError: ''
				},
				label: {
					id: '账 号',
					name: '昵 称',
					pw: '密 码',
					registerBtn: 'Register',
					toLoginBtn: 'Login'
				},
				tips: {
					idTip: 'Input your username',
					nameTip: 'Input your nickname',
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
			register() {
				if (!this.info.id) {
					this.error.idError = '账号不能为空';
				}
				if (!this.info.name) {
					this.error.nameError = '昵称不能为空';
				}
				if (!this.info.password) {
					this.error.pwError = '密码不能为空';
				}
				if(this.info.id && this.info.password && this.info.name) {
					/* axios验证 */
					this.$router.push('/');
				}
			},
			clearID() {
				this.error.idError = '';
			},
			clearNAME() {
				this.error.nameError = '';
			},
			clearPW() {
				this.error.pwError = '';
			}
		}
	};
</script>

<style>
	.register-box {
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
	.pw-input,
	.name-input{
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
	
	.register-btn {
		width: 80vw;
		background-color: #41b883;
		font-size: 20px;
		letter-spacing: 2px;
	}
	
	.btn-box_sec {
		margin-top: 40px;
	}
	
	.to-login-btn {
		margin-left: 10px;
		background-color: #41b883;
		letter-spacing: 1px;
		font-size: 14px;
	}
	
	.register-btn:hover,
	.to-login-btn:hover{
		color: black;
		background-color: #339167;
		transition: background-color .5s; 
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
