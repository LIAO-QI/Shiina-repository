<template>
    <div class="department-table-component">
        <!-- 头部面包屑 -->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>人员管理</el-breadcrumb-item>
            <el-breadcrumb-item>部门管理</el-breadcrumb-item>
        </el-breadcrumb>
        <el-divider><i class="el-icon-magic-stick"></i></el-divider>
        <!-- 部门列表 -->
        <el-table
            :data="staffDepartment"
            stripe
            style="width: 100%"
        >
            <el-table-column
                prop="de_id"
                label="#"
                width="150"
            >
            </el-table-column>
            <el-table-column
                prop="de_name"
                label="部门名称"
                width="150"
            >
            </el-table-column>
            <el-table-column
                prop="de_remarks"
                label="部门描述"
                width="250"
            >
            </el-table-column>
            <el-table-column
                prop="de_manager"
                label="管理员"
                width="150"
            >
            </el-table-column>
            <el-table-column
                prop="de_phone"
                label="联系方式"
                width="150"
            >
            </el-table-column>
            <el-table-column
                label="操作"
            >
                <template slot-scope="department">
                    <el-button 
                        icon="el-icon-edit" 
                        type="warning" 
                        plain 
                        circle 
                        size="small"
                        @click="updateDepartment(department.row.de_id)"
                        class="drugs-table-opera-btn">
                    </el-button>
                    <el-button 
                        icon="el-icon-delete" 
                        type="danger" 
                        plain 
                        circle
                        @click="deleteDepartment(department.row.de_id)"
                        size="small">
                    </el-button>
                </template>
            </el-table-column>
            <el-table-column>
                <template slot="header">
                    <el-button 
                        type="primary" 
                        round 
                        icon="el-icon-circle-plus-outline" 
                        style="width: 100%;"
                        @click="saveDepartmentVisible = true"
                    >
                        添加部门
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
        <!-- 添加部门的模态框 -->
        <el-dialog title="部门信息" :visible.sync="saveDepartmentVisible" center width="30%" top="12vh">
            <el-divider><i class="el-icon-edit"></i></el-divider>
            <el-form :model="departmentInfo" class="department-table-save" label-width="80px" label-position="left" :rules="rules" ref="departmentForm">
                <el-form-item label="部门名称" prop="de_name">
                    <el-col :span="12">
                        <el-input v-model="departmentInfo.de_name" clearable></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="管理员" prop="de_manager">
                    <el-col :span="12">
                        <el-input v-model="departmentInfo.de_manager" clearable></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="部门电话" prop="de_phone">
                    <el-col :span="12">
                        <el-input v-model.number="departmentInfo.de_phone" clearable></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="部门描述" prop="de_remarks">
                    <el-col :span="20">
                        <el-input type="textarea" v-model="departmentInfo.de_remarks" clearable rows="3"></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item>
                    <el-col :span="8">
                        <el-button type="success" style="width: 100%;" round @click="handleSave('departmentForm')">保存</el-button>
                    </el-col>
                    <el-col :span="8" :offset="4">
                        <el-button type="warning" style="width: 100%;" round @click="saveDepartmentVisible = false">取消</el-button>
                    </el-col>
                </el-form-item>
            </el-form>
        </el-dialog>
        <!-- 修改部门的模态框 -->
        <el-dialog title="部门信息" :visible.sync="updateDepartmentVisible" center width="30%" top="12vh">
            <el-divider><i class="el-icon-edit"></i></el-divider>
            <el-form :model="currentDepartment" class="department-table-update" label-width="80px" label-position="left">
                <el-form-item label="部门编号">
                    <el-col :span="12">
                        <el-input v-model="currentDepartment.de_id" clearable disabled></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="部门名称">
                    <el-col :span="12">
                        <el-input v-model="currentDepartment.de_name" clearable></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="管理员">
                    <el-col :span="12">
                        <el-input v-model="currentDepartment.de_manager" clearable></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="部门电话">
                    <el-col :span="12">
                        <el-input v-model.number="currentDepartment.de_phone" clearable></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="部门描述">
                    <el-col :span="20">
                        <el-input type="textarea" v-model="currentDepartment.de_remarks" clearable rows="3"></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item>
                    <el-col :span="8">
                        <el-button type="success" style="width: 100%;" round @click="handleUpdate()">修改</el-button>
                    </el-col>
                    <el-col :span="8" :offset="4">
                        <el-button type="warning" style="width: 100%;" round @click="updateDepartmentVisible = false">取消</el-button>
                    </el-col>
                </el-form-item>
            </el-form>
        </el-dialog>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import { reqDepartmentSave, reqDepartmentDelete, reqDepartmentUpdate, reqDepartmentById } from '@/api'
export default {
    data() {
        return {
            saveDepartmentVisible: false,
            updateDepartmentVisible: false,
            departmentInfo: {
                de_name: '',
                de_remarks: '',
                de_manager: '',
                de_phone: ''
            },
            currentDepartment: {
                de_id: '',
                de_name: '',
                de_remarks: '',
                de_manager: '',
                de_phone: ''
            },
            rules: {
                de_name: [
                    { required: true, message: '输入部门名称', trigger: 'blur' }
                ],
                de_remarks: [
                    { required: true, message: '输入部门描述信息', trigger: 'blur' }
                ],
                de_manager: [
                    { required: true, message: '确认部门管理员', trigger: 'blur' }
                ],
                de_phone: [
                    { required: true, message: '填写部门联系方式', trigger: 'blur' },
                    { type: 'number', message: '联系方式必须为数字值', trigger: 'blur'}
                ]
            }
        }
    },
    created(){
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
        updateDepartment(id){   // 点击修改按钮触发事件
            reqDepartmentById(id).then(res => {
                if(res.data.code === 200){
                    this.currentDepartment = res.data.data
                    this.updateDepartmentVisible = true
                } else {
                    this.updateDepartmentVisible = false
                    this.$message({
                        type: 'warning',
                        message: '当前数据异常，不能修改。',
                        center: true
                    });
                }
            })
        },
        deleteDepartment(id){   // 点击删除按钮触发事件
            this.$confirm('此操作将永久删除该记录, 是否继续?', '警告', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'error'
            }).then(() => {
                reqDepartmentDelete(id).then(res => {
                    if(res.data.code === 200){
                        this.$message({
                            type: 'success',
                            message: '删除成功!',
                            center: true
                        });
                        this.getDepartment()
                    } else {
                        this.$message({
                            type: 'danger',
                            message: '删除失败!（权限不够或未知原因）',
                            center: true
                        });
                    }
                });
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除',
                    center: true
                });
            });
        },
        handleSave(form){   // 执行添加操作
            this.$refs[form].validate((valid) => {
                if (valid) {
                    reqDepartmentSave(this.departmentInfo).then(res => {
                        if( res.data.code === 200 ){
                            this.$message({
                                message: '提交信息成功！',
                                type: 'success',
                                center: true
                            });
                            this.$refs[form].resetFields();
                            this.getDepartment()
                            this.saveDepartmentVisible = false
                        } else {
                            this.$message({
                                message: '提交失败，请检查部门信息',
                                type: 'error',
                                center: true
                            });
                        }
                    }).catch(error => {
                        this.$message({
                            message: error,
                            type: 'error',
                            center: true
                        });
                    })
                } else {
                    this.$message({
                        message: '提交失败，请检查部门信息',
                        type: 'error',
                        center: true
                    });
                    return false;
                }
            });
        },
        handleUpdate(){     // 执行修改操作
            reqDepartmentUpdate(this.currentDepartment).then(res => {
                if(res.data.code === 200){
                    this.$message({
                        type: 'success',
                        message: '数据修改成功。',
                        center: true
                    });
                    this.getDepartment()
                } else {
                    this.$message({
                        type: 'warning',
                        message: '当前数据异常，暂时不能修改。',
                        center: true
                    });
                }
                this.updateDepartmentVisible = false
            })
        }
    }
}
</script>

<style lang="scss">
.department-table-component {
    .el-dialog__body {
        padding-top: 0;
        padding-bottom: 10px;
    }
}
</style>