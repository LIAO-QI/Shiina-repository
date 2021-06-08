<template>
    <div class="staff-form-component">
        <!-- 头部面包屑 -->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>人员管理</el-breadcrumb-item>
            <el-breadcrumb-item>添加人员</el-breadcrumb-item>
        </el-breadcrumb>
        <el-divider><i class="el-icon-magic-stick"></i></el-divider>
        <!-- 添加人员的表单 -->
        <el-form ref="staffForm" class="staff-form-info" :model="staffInfo" label-width="100px" label-position="left" :rules="rules">
            <el-form-item label="姓名" prop="s_name">
                <el-col :span="12">
                    <el-input v-model="staffInfo.s_name" clearable></el-input>
                </el-col>
            </el-form-item>
            <el-form-item label="性别" prop="s_sex">
                <el-col :span="8">
                    <el-select v-model="staffInfo.s_sex" placeholder="选择性别" style="width: 100%;">
                        <el-option label="男" value="男"></el-option>
                        <el-option label="女" value="女"></el-option>
                    </el-select>
                </el-col>
            </el-form-item>
            <el-form-item label="出生日期" prop="s_birth">
                <el-col :span="8">
                    <el-date-picker type="date" placeholder="选择日期" v-model="staffInfo.s_birth" style="width: 100%;" value-format="yyyy-MM-dd"></el-date-picker>
                </el-col>
            </el-form-item>
            <el-form-item label="联系方式" prop="s_phone">
                <el-col :span="12">
                    <el-input v-model="staffInfo.s_phone" clearable></el-input>
                </el-col>
            </el-form-item>
            <el-form-item label="职务" prop="s_duty">
                <el-col :span="12">
                    <el-input v-model="staffInfo.s_duty" clearable></el-input>
                </el-col>
            </el-form-item>
            <el-form-item label="所属部门" required>
                <el-col :span="8">
                    <el-select v-model="staffInfo['department.de_id']" placeholder="选择所属部门" style="width: 100%;">
                        <el-option
                            v-for="(item,index) in staffDepartment"
                            :key="index"
                            :label="item.de_name"
                            :value="item.de_id"
                        ></el-option>
                    </el-select>
                </el-col>
            </el-form-item>
            <el-form-item label="家庭住址" prop="s_address">
                <el-col :span="12">
                    <el-input v-model="staffInfo.s_address" clearable></el-input>
                </el-col>
            </el-form-item>
            <el-form-item>
                <el-col :span="10">
                    <el-button type="primary" style="width: 100%;" round plain @click="saveStaff('staffForm')">立即添加</el-button>
                </el-col>
                <el-col :span="10" :offset="4">
                    <el-button type="info" style="width: 100%;" round plain @click="resetStaff('staffForm')">重置信息</el-button>
                </el-col>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
import { reqStaffSave } from '@/api'
export default {
    data(){
        return {
            staffInfo: {
                s_name: '',
                s_sex: '男',
                s_birth: '',
                s_phone: '',
                s_duty: '',
                'department.d_id': 1,
                s_address: ''
            },
            rules: {
                s_name: [
                    { required: true, message: '请输入姓名', trigger: 'blur' }
                ],
                s_sex: [
                    { required: true, message: '请选择性别', trigger: 'change' }
                ],
                s_birth: [
                    { required: true, message: '确认出生日期', trigger: 'blur' }
                ],
                s_phone: [
                    { required: true, message: '确认联系方式', trigger: 'blur' }
                ],
                s_duty: [
                    { required: true, message: '请输入职务', trigger: 'blur' }
                ],
                s_address: [
                    { required: true, message: '请确认住址', trigger: 'blur' }
                ]
            }
        }
    },
    created () {
        this.getDepartment()
    },
    computed: {
        ...mapState([
            'staffDepartment'
        ])
    },
    methods: {
        ...mapActions([
            'getDepartment'
        ]),
        saveStaff(form) {
            this.$refs[form].validate((valid) => {
                if (valid) {
                    reqStaffSave(this.staffInfo).then(res => {
                        if( res.data.code === 200 ){
                            this.$message({
                                message: '提交信息成功！',
                                type: 'success',
                                center: true
                            });
                            this.$refs[form].resetFields();
                        } else {
                            this.$message({
                                message: '提交失败，请检查人员信息',
                                type: 'error',
                                center: true
                            });
                        }
                    }).catch(error => {
                        this.$message({
                            message: '提交失败，请检查人员信息',
                            type: 'error',
                            center: true
                        });
                        console.log(error);
                    })
                } else {
                    this.$message({
                        message: '提交失败，请检查人员信息',
                        type: 'error',
                        center: true
                    });
                    return false;
                }
            });
        },
        resetStaff(form) {
            this.$refs[form].resetFields();
            this.$message({
                message: '人员信息已重置，请重新填写。',
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