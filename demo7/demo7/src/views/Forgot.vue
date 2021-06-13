<template>
	<div class="findPW-box">
		<van-button
			class="back-btn" 
			round 
			type="primary"
			size="small"
			@click="$router.push('/')"
			:text="label.back"
		>
		</van-button>
		
		<div class="logo">
			<img src="../assets/logo.png" />
		</div>

		<van-steps 
			class="steps" 
			:active="active.step" 
			active-icon="success" 
			inactive-icon="arrow"
			active-color="#41b883"
		>
			<van-step>填写账号</van-step>
			<van-step>身份验证</van-step>
			<van-step>设置新密码</van-step>
			<van-step>完成</van-step>
		</van-steps>
		
		<!-- 第一页 -->
		<div class="firstPage">
			<van-cell-group class='input-box'>
				<van-field 
					v-model="info.id" 
					clearable 
					:label="label.id" 
					:placeholder="tips.idTip" 
					class="id-input"
					:error-message="error.idError"
					@focus = "clearID()"
				/>
			</van-cell-group>

			<van-button 
				class="next-btn" 
				round 
				type="primary" 
				@click="firstStep()"
				:text="label.next"
			>
			</van-button>
		</div>
		
		<!-- 第二页 -->
		<div class="secondPage hidePage">
			<van-cell-group class="input-box">
				<van-field 
					v-model="info.id" 
					clearable
					readonly
					:label="label.id" 
					:placeholder="tips.idTip" 
					:error-message="error.idError"
					@focus = "clearID()"
				/>
				
				<van-field
					v-model="info.checkCode"
					center
					clearable
					:label="label.checkCode"
					:placeholder="tips.checkCodeTip"
					:error-message="error.checkCodeError"
					@focus = "clearCheckCode()"
				>
					<template #button>
						<van-button 
							size="small" 
							type="primary"
							color="#41b883"
							@click="sendCheckCode()"
							:text="label.sendCC"
						>
						</van-button>
					</template>
				</van-field>
			</van-cell-group>
		
			<van-button 
				class="next-btn" 
				round 
				type="primary" 
				@click="secondStep()"
				:text="label.next"
			>
			</van-button>
		</div>
		
		<!-- 第三页 -->
		<div class="thirdPage hidePage">
			<van-cell-group class='input-box'>
				<van-field 
					v-model="info.password" 
					clearable 
					:label="label.password" 
					:placeholder="tips.pwTip" 
					class="id-input"
					type="password"
					:error-message="error.pwError"
					@focus = "clearPW()"
				/>
			</van-cell-group>
		
			<van-button 
				class="next-btn" 
				round 
				type="primary" 
				@click="ThirdStep()"
				:text="label.next"
			>
			</van-button>
		</div>
		
		<!-- 第四页 -->
		<div class="confirmPage hidePage">
			<van-button 
				class="next-btn" 
				round 
				type="primary" 
				@click="confirmStep()"
				:text="label.confirm"
			>
			</van-button>
		</div>
		
	</div>

</template>

<script>
	import {
		Button,
		Steps,
		Step,
		CellGroup,
		Field
	} from 'vant';

	export default {
		name: 'forgot',
		data() {
			return {
				info: {
					id: '',
					checkCode: '',
					password: ''
				},
				error: {
					idError: '',
					checkCodeError: '',
					pwError: ''
				},
				label: {
					id: '账 号',
					checkCode: '验 证 码',
					password: '密 码',
					next: '下 一 步',
					back: '返 回',
					confirm: '返 回 登 录',
					sendCC: '发 送 验 证 码'
				},
				tips: {
					idTip: 'Input your username',
					checkCodeTip: 'Input email checkcode',
					pwTip: 'Input new password'
				},
				active: {
					step: 0
				}
			};
		},
		components: {
			[Button.name]: Button,
			[Steps.name]: Steps,
			[Step.name]: Step,
			[CellGroup.name]: CellGroup,
			[Field.name]: Field
		},
		methods: {
			nextStep() {
				if(this.active.step >=0 && this.active.step <4)
					this.active.step ++;
				if(this.active.step == 4)
					this.$router.push("/");
			},
			firstStep() {
				if (!this.info.id) {
					this.error.idError = '账号不能为空';
				}
				if(this.info.id) {
					/* axios验证该账号是否存在 */
					document.querySelector('.firstPage').classList.add('hidePage');
					document.querySelector('.secondPage').classList.remove('hidePage');
					this.nextStep();
				}
			},
			secondStep() {
				if (!this.info.checkCode) {
					this.error.checkCodeError = '验证码不能为空';
				}
				if(this.info.checkCode) {
					/* 验证验证码的正确性 */
					document.querySelector('.secondPage').classList.add('hidePage');
					document.querySelector('.thirdPage').classList.remove('hidePage');
					this.nextStep();
				}
			},
			ThirdStep() {
				if (!this.info.password) {
					this.error.pwError = '密码不能为空';
				}
				if(this.info.checkCode) {
					/* 调用接口更改数据库数据 */
					document.querySelector('.thirdPage').classList.add('hidePage');
					document.querySelector('.confirmPage').classList.remove('hidePage');
					this.nextStep();
				}
			},
			confirmStep() {
				document.querySelector('.confirmPage').classList.add('hidePage');
				document.querySelector('.firstPage').classList.remove('hidePage');
				this.nextStep();
			},
			sendCheckCode() {
				/* 发送邮箱验证码 */
			},
			clearID() {
				this.error.idError = '';
			},
			clearCheckCode() {
				this.error.checkCodeError = '';
			},
			clearPW() {
				this.error.pwError = '';
			}
		}
	};
</script>

<style>
	.hidePage {
		display: none;
	}
	
	.findPW-box {
		width: 100vw;
		padding-top: 10vh;
		font-family: 'Times New Roman', Times, serif;
	}

	.logo img {
		width: 120px;
		margin-left: 50vw;
		transform: translateX(-50%);
	}

	.steps {
		width: 90vw;
		margin: 20px auto;
	}
	
	.next-btn {
		width: 80vw;
		background-color: #41b883;
		font-size: 16px;
		letter-spacing: 2px;
		margin-left: 10vw;
	}
	
	.back-btn {
		background-color: #41b883;
		position: absolute;
		top: 3vh;
		left: 3vh;
	}
	
	.next-btn:hover {
		color: black;
		background-color: #339167;
		transition: background-color .5s;
	}
	
	.input-box {
		margin-bottom: 30px;
	}
</style>