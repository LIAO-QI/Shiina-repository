<template>
    <div class="login-component">
        <el-card class="login-card" shadow="hover">
            <!-- 标题部分 -->
            <div class="login-header">
                <div class="login-logo">
                    <img src="@/assets/logo.png" alt="">
                </div>
                <h1>药店后台管理系统</h1>
            </div>
            <hr/>
            <!-- 表单部分 -->
            <el-form 
                label-position="left" 
                label-width="80px" 
                :model="admin" 
                class="login-form" 
                :rules="validate"
                ref="loginForm"
            >
                <el-form-item label="用户名" prop="username">
                    <el-input 
                        v-model="admin.username" 
                        placeholder="请输入用户名" 
                        clearable
                        prefix-icon="el-icon-user"
                    />
                </el-form-item>

                <el-form-item label="密码" prop="password">
                    <el-input 
                        v-model="admin.password" 
                        placeholder="请输入密码" 
                        show-password 
                        clearable
                        prefix-icon="el-icon-lock"
                    />
                </el-form-item>

                <div class="login-btn">
                    <el-button type="primary" round plain @click.prevent="submitForm('loginForm')">登录</el-button>
                    <el-button type="danger" round plain @click.prevent="resetForm('loginForm')">重置</el-button>
                </div>
            </el-form>
        </el-card>
    </div>
</template>

<script>
import { reqLogin } from '@/api'
import { mapActions } from 'vuex'
export default {
    data (){
        return {
            admin: {
                username: '',
                password: ''
            },
            validate: {
                username: [
                    { required: true, message: "用户名不能为空.", trigger: 'blur' }
                ],
                password: [
                    { required: true, message: "密码不能为空.", trigger: 'blur' }
                ]
            }
        }
    },
    methods: {
        ...mapActions([
            'login'
        ]),
        submitForm (formName){
            this.$refs[formName].validate(valid => {
                if(valid){
                    reqLogin(this.admin).then(res => {
                        if(res.data.code === 200){
                            this.$message({
                                message: '登录成功！',
                                type: 'success',
                                center: true
                            })
                            localStorage.setItem("Flag", "isLogin")
                            this.login()
                            this.$router.push('home/index');
                        } else {
                            this.$message({
                                message: '登录失败，确认用户信息！',
                                type: 'error',
                                center: true
                            })
                        }
                    })
                } else {
                    this.$message({
                        message: '登录失败，确认用户信息！',
                        type: 'error',
                        center: true
                    })
                }
            })
        },
        resetForm (formName){
            this.$refs[formName].resetFields();
            this.$message({
                message: "重置成功。",
                type: 'info',
                center: true
            })
        }
    }
}
</script>

<style lang="scss" scoped>
.login-component {
    height: 100%;
    width: 100%;
    background: url("../../assets/bg.jpg");
    background-size: 100% 100%;
    position: fixed;
    padding-top: 100px;
    .login-card {
        width: 30%;
        margin: 0 auto;
        border-radius: 10px;
        .login-header {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            .login-logo {
                width: 100px;
                height: 100px;
                img {
                    width: 100%;
                    object-fit: cover;
                }
            }
            h1 {
                margin-top: 10px;
                font-size: 24px;
                color: #666;
                letter-spacing: 1px;
            }
        }
        hr {
            margin: 20px 5px 30px;
            border: none;
            border-bottom: 1px solid #ddd;
        }
        .login-form {
            padding: 0 40px;
            .login-btn {
                width: 100%;
                margin: 40px 0 15px;
                display: flex;
                justify-content: space-around;
                button {
                    width: 40%;
                }
                
            }
        }
    }
}
</style>