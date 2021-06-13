<template>
    <div class="drug-form-component">
        <!-- 头部面包屑 -->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>财务管理</el-breadcrumb-item>
            <el-breadcrumb-item>支出录入</el-breadcrumb-item>
        </el-breadcrumb>
        <el-divider><i class="el-icon-magic-stick"></i></el-divider>
        <!-- 添加其他收入的表单 -->
        <el-form ref="insertother" class="drug-form-info" :model="accountOther" label-width="100px" label-position="left" :rules="rules">
            <el-form-item label="费用名称" prop="ao_name">
                <el-col :span="12">
                    <el-input v-model="accountOther.ao_name" clearable></el-input>
                </el-col>
            </el-form-item>
            <el-form-item label="金额" prop="ao_money">
                <el-col :span="12">
                    <el-input v-model="accountOther.ao_money" clearable></el-input>
                </el-col>
            </el-form-item>
            <el-form-item label="备注" prop="ao_remarks">
                <el-col :span="12">
                    <el-input v-model="accountOther.ao_remarks" clearable></el-input>
                </el-col>
            </el-form-item>
            <el-form-item label="日期" prop="ao_date">
                <el-col :span="12">
                    <el-input v-model="accountOther.ao_date" clearable></el-input>
                </el-col>
            </el-form-item>

            <el-form-item>
                <el-col :span="10">
                    <el-button type="primary" style="width: 100%;" round plain @click="saveOther('insertother')">立即添加</el-button>
                </el-col>
                <el-col :span="10" :offset="4">
                    <el-button type="info" style="width: 100%;" round plain @click="resetOther('insertother')">重置信息</el-button>
                </el-col>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import { insertAccountOther } from '@/api'
export default {
    data(){
        return {
            accountOther: {
                ao_id: 0,
                ao_name: '',
                ao_money: '',
                ao_remarks: '',
                ao_date: ''
            },
            rules: {
                ao_name: [
                    { required: true, message: '请输入费用名称', trigger: 'blur' }
                ],
                ao_money: [
                    { required: true, message: '请输入费用金额', trigger: 'blur' }
                ],
                ao_remarks: [
                    { required: true, message: '请输入费用备注', trigger: 'blur' }
                ],
                ao_date: [
                    { required: true, message: '请选择缴费时间', trigger: 'blur' }
                ]
            }
        }
    },
    created() {

    },
    computed: {
        ...mapState([

        ])
    },
    methods: {
        ...mapActions([

        ]),
        saveOther(form) {
            //alert(this.accountOther.ao_name)
            this.$refs[form].validate((valid) => {
                if (valid) {
                    insertAccountOther(this.accountOther).then(res => {
                        if( res.data.code === 200 ){
                            this.$message({
                                message: '提交信息成功！',
                                type: 'success',
                                center: true
                            });
                            this.$refs[form].resetFields();
                        } else {
                            this.$message({
                                message: '提交失败，请检查信息1',
                                type: 'error',
                                center: true
                            });
                        }
                    }).catch(error => {
                        this.$message({
                            message: '提交失败，请检查信息2',
                            type: 'error',
                            center: true
                        });
                        console.log(error);
                        
                    })
                } else {
                    this.$message({
                        message: '其它支出信息输入不完整，请检查输入！',
                        type: 'error',
                        center: true
                    });
                    return false;
                }
            });
        },
        resetOther(form) {
            this.$refs[form].resetFields();
            this.$message({
                message: '信息已重置，请重新填写。',
                type: 'warning',
                center: true
            });
        }
    }
}
</script>

<style lang="scss">
.drug-form-component {
    .drug-form-info {
        width: 60%;
        padding: 30px 50px;
    }
}
</style>