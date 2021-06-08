<template>
    <div class="staff-form-component">
        <!-- 头部面包屑 -->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>库存管理</el-breadcrumb-item>
            <el-breadcrumb-item>购进录入</el-breadcrumb-item>
        </el-breadcrumb>
        <el-divider><i class="el-icon-magic-stick"></i></el-divider>
        <!-- 添加进货的表单 -->
        <el-form ref="stockForm" class="staff-form-info" :model="stock" label-width="100px" label-position="left" :rules="rules">
            <el-form-item label="进货流水号" prop="stock_id">
                <el-col :span="12">
                    <el-input v-model="stock.stock_id" clearable></el-input>
                </el-col>
            </el-form-item>
            <el-form-item label="补货编号" prop="ra_id">
                <el-col :span="12">
                    <el-input v-model="stock.ra_id" clearable></el-input>
                </el-col>
            </el-form-item>
            <el-form-item label="进货日期" prop="po_date">
                <el-col :span="8">
                    <el-date-picker type="date" placeholder="选择日期" v-model="stock.po_date" style="width: 100%;" value-format="yyyy-MM-dd"></el-date-picker>
                </el-col>
            </el-form-item>
            <el-form-item label="进货备注" prop="po_remarks">
                <el-col :span="12">
                    <el-input v-model="stock.po_remarks" clearable></el-input>
                </el-col>
            </el-form-item>
            <el-form-item>
                <el-col :span="10">
                    <el-button type="primary" style="width: 100%;" round plain @click="saveStock('stockForm')">立即添加</el-button>
                </el-col>
                <el-col :span="10" :offset="4">
                    <el-button type="info" style="width: 100%;" round plain @click="resetStock('stockForm')">重置信息</el-button>
                </el-col>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
import { insertStock } from '@/api'
export default {
    data(){
        return {
            stock: {
                po_id: 0,
                stock_id: '',
                ra_id: '',
                po_date: '',
                po_remarks: ''
            },
            rules: {
                stock_id: [
                    { required: true, message: '请输入进货流水号', trigger: 'blur' }
                ],
                ra_id: [
                    { required: true, message: '请输入补货编号', trigger: 'change' }
                ],
                po_date: [
                    { required: true, message: '确认进货日期', trigger: 'blur' }
                ],
                po_remarks: [
                    { required: true, message: '确认进货备注', trigger: 'blur' }
                ]

            }
        }
    },
    created () {
    },
    methods: {
        saveStock(form) {
            this.$refs[form].validate((valid) => {
                if (valid) {
                    insertStock(this.stock).then(res => {
                        if( res.data.code === 200 ){
                            this.$message({
                                message: '提交信息成功！',
                                type: 'success',
                                center: true
                            });
                            this.$refs[form].resetFields();
                        } else {
                            this.$message({
                                message: '提交失败，响应码非200成功',
                                type: 'error',
                                center: true
                            });
                        }
                    }).catch(error => {
                        this.$message({
                            message: '提交失败，系统错误',
                            type: 'error',
                            center: true
                        });
                        console.log(error);
                    })
                } else {
                    this.$message({
                        message: '提交失败，进货单信息填写不完整',
                        type: 'error',
                        center: true
                    });
                    return false;
                }
            });
        },
        resetStock(form) {
            this.$refs[form].resetFields();
            this.$message({
                message: '进货信息已重置，请重新填写。',
                type: 'warning',
                center: true
            });
        }
    }
}
</script>

<style lang="scss">
.staff-form-component {
    .staff-form-info {
        width: 60%;
        padding: 30px 50px;
    }
}
</style>