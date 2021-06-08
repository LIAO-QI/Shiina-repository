<template>
    <div class="home-component">
        <el-container class="home-wrap">
            <!-- 头部 -->
            <el-header height="80px" class="home-header">
                <el-row>
                    <el-col :span="12">
                        <img src="@/assets/logo.png" class="home-logo">
                        <span class="home-title">药店药品进销管理系统</span>
                    </el-col>
                    <el-col :span="2" :offset="10">
                        <el-button icon="el-icon-close" size="small" class="logout-btn" @click="logoutSystem()">退出系统</el-button>
                    </el-col>
                </el-row>
            </el-header>
            <el-container class="home-main">
                <!-- 侧边栏 -->
                <el-aside width="250px" class="home-aside">
                    <el-menu
                        default-active="2"
                        unique-opened
                        router
                    >
                         <el-menu-item index="/home/index">
                            <i class="el-icon-menu"></i>
                            <span slot="title">首页</span>
                        </el-menu-item>
                        <el-submenu index="1">
                            <template slot="title">
                                <i class="el-icon-first-aid-kit"></i>
                                <span>药品管理</span>
                            </template>
                            <el-menu-item index="/home/drugTable"><i class="el-icon-tickets"></i>药品列表</el-menu-item>
                            <el-menu-item index="/home/drugForm"><i class="el-icon-circle-plus"></i>添加药品</el-menu-item>
                            <el-menu-item index="/home/categoryTable"><i class="el-icon-setting"></i>类别管理</el-menu-item>
                        </el-submenu>
                        <el-submenu index="2">
                            <template slot="title">
                                <i class="el-icon-user"></i>
                                <span>人员管理</span>
                            </template>
                            <el-menu-item index="/home/staffTable"><i class="el-icon-tickets"></i>人员列表</el-menu-item>
                            <el-menu-item index="/home/staffForm"><i class="el-icon-circle-plus"></i>添加人员</el-menu-item>
                            <el-menu-item index="/home/departmentTable"><i class="el-icon-setting"></i>部门管理</el-menu-item>
                        </el-submenu>
                        <el-submenu index="3">
                            <template slot="title">
                                <i class="el-icon-s-order"></i>
                                <span>订单管理</span>
                            </template>
                            <el-menu-item index="/home/orderTable"><i class="el-icon-document"></i>订单列表</el-menu-item>
                            <el-menu-item index="/home/orderForm"><i class="el-icon-document-add"></i>订单录入</el-menu-item>
                        </el-submenu>
                        <el-submenu index="4">
                            <template slot="title">
                                <i class="el-icon-truck"></i>
                                <span>库存管理</span>
                            </template>
                            <el-menu-item index="/home/applyTable"><i class="el-icon-tickets"></i>补货列表</el-menu-item>
                            <el-menu-item index="/home/applyForm"><i class="el-icon-circle-plus"></i>补货录入</el-menu-item>
                            <el-menu-item index="/home/stockTable"><i class="el-icon-document"></i>购进列表</el-menu-item>
                            <el-menu-item index="/home/stockForm"><i class="el-icon-document-add"></i>购进录入</el-menu-item>
                        </el-submenu>
                        <el-submenu index="5">
                            <template slot="title">
                                <i class="el-icon-coin"></i>
                                <span>财务管理</span>
                            </template>
                            <el-menu-item index="/home/incomeTable"><i class="el-icon-download"></i>收入信息</el-menu-item>
                            <el-menu-item index="/home/outcomeTable"><i class="el-icon-upload2"></i>支出信息</el-menu-item>
                            <el-menu-item index="/home/othercomeTable"><i class="el-icon-document"></i>其他支出</el-menu-item>
                            <el-menu-item index="/home/insertother"><i class="el-icon-document-add"></i>支出录入</el-menu-item>
                        </el-submenu>
                    </el-menu>
                </el-aside>
                <!-- 主要内容区域 -->
                <el-main class="home-sub-main">
                    <el-card class="home-main-card">
                        <transition name="fade" mode="out-in">
                            <router-view/>
                        </transition>
                    </el-card>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
import { reqLogout } from '@/api'
import { mapActions } from 'vuex';
export default {
    methods: {
        ...mapActions([
            'logout'
        ]),
        logoutSystem() {
            this.$confirm('是否确定退出', '警告', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'danger'
            }).then(() => {
                reqLogout().then(res => {
                    if(res.data.code === 200){
                        this.$message({
                            type: 'success',
                            message: '退出系统成功',
                            center: true
                        });
                        this.logout()
                        localStorage.removeItem("Flag")
                        this.$router.push('/login');
                    } else {
                        this.$message({
                            type: 'warning',
                            message: '操作异常',
                            center: true
                        });  
                    }
                })
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '取消操作',
                    center: true
                });       
            });
            
        }
    }
}
</script>

<style lang="scss" scoped>
.home-component {
    height: 100%;
    .home-wrap {
        height: 100%;
        .home-header {
            padding: 10px 40px;
            box-shadow: 0px 2px 12px 0px rgba($color: #000000, $alpha: 0.1);
            z-index: 1;
            .home-logo {
                width: 60px;
                height: 60px;
                vertical-align: middle;
                margin-right: 30px;
            }
            .home-title {
                font-size: 20px;
                font-weight: 700;
                color: #333;
            }
        }
        .home-main {
            height: 100%;
            overflow: hidden;
            .home-aside {
                padding: 10px 0 50px 10px;
                overflow-y:scroll;
                border-right: 1px solid #e6e6e6;
                .el-menu {
                    border: none;
                }
                &::-webkit-scrollbar-thumb {
                    border-radius:3px;
                    background-color:#ddd;
                }
                &::-webkit-scrollbar{
                    width:6px;
                    background-color:#fff;
                }
            }
            .home-sub-main {
                overflow-y:scroll;
                background-color: #fdfdfd;
                &::-webkit-scrollbar-thumb {
                    border-radius:3px;
                    background-color:#aaa;
                }
                &::-webkit-scrollbar{
                    width:6px;
                    background-color:#fff;
                }
                .home-main-card {
                    padding: 10px;
                }
            }
        }
        
    }
    .logout-btn {
        margin-top: 14px;
    }
}
// 动画设置
.fade-enter {
  opacity:0;
}
.fade-leave{
  opacity:1;
}
.fade-enter-active{
  transition:opacity .3s;
}
.fade-leave-active{
  opacity:0;
  transition:opacity .3s;
}
</style>