<template>
    <div class="staff-table-component">
        <!-- 头部面包屑 -->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>人员管理</el-breadcrumb-item>
            <el-breadcrumb-item>人员列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-divider><i class="el-icon-magic-stick"></i></el-divider>
        <!-- 条件模糊查询 -->
        <el-row class="staff-table-condition">
            <el-col :span="4" :offset="3">
                <el-input v-model="condition['s_name']" placeholder="请输入姓名" clearable></el-input>
            </el-col>
            <el-col :span="4" :offset="2">
                <el-select v-model="condition['de_id']" placeholder="选择部门" clearable>
                    <el-option
                    v-for="(item,index) in staffDepartment"
                    :key="index"
                    :label="item.de_name"
                    :value="item.de_id">
                    </el-option>
                </el-select>
            </el-col>
            <el-col :span="3" :offset="2">
                <el-button type="primary" round style="width: 100%;" @click="handleQueryCondition()" icon="el-icon-search">查询</el-button>
            </el-col>
        </el-row>
        <!-- 人员列表 -->
        <el-table
            :data="staffList"
            stripe
            style="width: 100%"
        >
            <el-table-column
                prop="s_id"
                label="#"
                width="80"
            >
            </el-table-column>
            <el-table-column
                prop="s_name"
                label="姓名"
                width="150"
            >
            </el-table-column>
            <el-table-column
                prop="s_sex"
                label="性别"
                width="100"
            >
            </el-table-column>
            <el-table-column
                prop="s_birth"
                label="出生日期"
                width="200"
            >
            </el-table-column>
            <el-table-column
                prop="department.de_name"
                label="所属部门"
                width="150"
            >
            </el-table-column>
            <el-table-column
                prop="s_phone"
                label="联系方式"
                width="200"
            >
            </el-table-column>
            <el-table-column
                fixed="right"
                label="操作"
            >
                <template slot-scope="scope">
                    <el-button 
                        icon="el-icon-view" 
                        type="primary" 
                        plain 
                        circle 
                        size="small" 
                        @click="viewStaff(scope.row.s_id)" 
                        class="staff-table-opera-btn">
                    </el-button>
                    <el-button 
                        icon="el-icon-edit" 
                        type="warning" 
                        plain 
                        circle 
                        size="small"
                        @click="updateStaff(scope.row.s_id)"
                        class="staff-table-opera-btn">
                    </el-button>
                    <el-button 
                        icon="el-icon-delete" 
                        type="danger" 
                        plain 
                        circle
                        @click="deleteStaff(scope.row.s_id)"
                        size="small">
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
        <!-- 分页组件 -->
        <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="pageNum"
            :page-sizes="[3, 5, 8]"
            :page-size="pageSize"
            layout="total, sizes, prev, pager, next, jumper"
            :total="staffCount"
            class="staff-table-pagination"
        >
        </el-pagination>
        <!-- 查看详情的模态框 -->
        <el-dialog title="人员详情" :visible.sync="viewStaffVisible" center width="30%" top="15vh">
            <el-divider><i class="el-icon-reading"></i></el-divider>
            <el-form :model="currentStaff" class="staff-table-info" label-width="80px" label-position="left">
                <el-form-item label="员工编号">
                    <span>{{ currentStaff.s_id }}</span>
                </el-form-item>
                <el-form-item label="姓名">
                    <span>{{ currentStaff.s_name }}</span>
                </el-form-item>
                <el-form-item label="性别">
                    <span>{{ currentStaff.s_sex }}</span>
                </el-form-item>
                <el-form-item label="出生日期">
                    <span>{{ currentStaff.s_birth }}</span>
                </el-form-item>
                <el-form-item label="联系方式">
                    <span>{{ currentStaff.s_phone }}</span>
                </el-form-item>
                <el-form-item label="职务">
                    <span>{{ currentStaff.s_duty }}</span>
                </el-form-item>
                <el-form-item label="地址">
                    <span>{{ currentStaff.s_address }}</span>
                </el-form-item>
                <el-form-item label="部门">
                    <span>{{ currentStaff.department.de_name }}</span>
                </el-form-item>
            </el-form>
        </el-dialog>
        <!-- 修改详情的模态框 -->
        <el-dialog title="人员详情" :visible.sync="updateStaffVisible" center width="40%" top="6vh">
            <el-divider><i class="el-icon-edit"></i></el-divider>
            <el-form :model="currentStaff" class="staff-table-update" label-width="80px" label-position="left">
                <el-form-item label="员工编号">
                    <el-col :span="6">
                        <el-input v-model="currentStaff.s_id" clearable disabled></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="姓名" prop="s_name">
                    <el-col :span="12">
                        <el-input v-model="currentStaff.s_name" clearable></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="性别">
                    <el-col :span="8">
                        <el-select v-model="currentStaff.s_sex" placeholder="请选择药品类别" style="width: 100%;">
                            <el-option label="男" value="男"></el-option>
                            <el-option label="女" value="女"></el-option>
                        </el-select>
                    </el-col>
                </el-form-item>
                <el-form-item label="出生日期" prop="s_birth">
                    <el-col :span="8">
                        <el-date-picker type="date" placeholder="选择日期" v-model="currentStaff.s_birth" style="width: 100%;" value-format="yyyy-MM-dd"></el-date-picker>
                    </el-col>
                </el-form-item>
                <el-form-item label="联系方式" prop="s_phone">
                    <el-col :span="12">
                        <el-input v-model="currentStaff.s_phone" clearable></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="职务" prop="s_duty">
                    <el-col :span="12">
                        <el-input v-model="currentStaff.s_duty" clearable></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="住址" prop="s_address">
                    <el-col :span="12">
                        <el-input v-model="currentStaff.s_address" size="medium" rows="6"></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="所属部门">
                    <el-col :span="8">
                        <el-select v-model="currentStaff.department.de_id" placeholder="选择部门" style="width: 100%;">
                            <el-option
                                v-for="(item,index) in staffDepartment"
                                :key="index"
                                :label="item.de_name"
                                :value="item.de_id"
                            ></el-option>
                        </el-select>
                    </el-col>
                </el-form-item>
                <el-form-item>
                    <el-col :span="6">
                        <el-button type="success" style="width: 100%;" round @click="handleUpdate()">修改信息</el-button>
                    </el-col>
                    <el-col :span="6" :offset="6">
                        <el-button type="warning" style="width: 100%;" round @click="updateStaffVisible = false">取消修改</el-button>
                    </el-col>
                </el-form-item>
            </el-form>
        </el-dialog>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import { reqStaffDelete, reqStaffById, reqStaffUpdate } from '@/api'
export default {
    data() {
        return {
            pageNum: 1,
            pageSize: 3,
            viewStaffVisible: false,
            updateStaffVisible: false,
            condition: {
                department: '',
                s_name: ''
            },
            currentStaff: {
                s_id: '',
                s_name: '',
                s_sex: '',
                s_birth: '',
                s_phone: '',
                s_duty: '',
                s_address: '',
                department: {
                    de_id: '',
                    de_name: '',
                    de_remarks: '',
                    de_manager: '',
                    de_phone: ''
                }
            }
        }
    },
    created() {
        this.getStaffByCondition({pageNum: 1, pageSize: 3, selectCondition: this.condition})
        this.getStaffCount(this.condition)
        this.getDepartment()
    },
    computed: {
        ...mapState([
            'staffList',
            'staffCount',
            'staffDepartment'
        ])
    },
    methods: {
        ...mapActions([
            'getStaffs',
            'getStaffCount',
            'getStaffsPage',
            'getDepartment',
            'getStaffByCondition'
        ]),
        handleSizeChange(size){
            this.pageSize = size
            this.getStaffByCondition({pageNum: this.pageNum, pageSize: this.pageSize, selectCondition: this.condition})
        },
        handleCurrentChange(page){
            this.pageNum = page
            this.getStaffByCondition({pageNum: this.pageNum, pageSize: this.pageSize, selectCondition: this.condition})
        },
        viewStaff(id) {   // 查看某个员工
            reqStaffById(id).then(res => {
                if(res.data.code === 200){
                    this.currentStaff = res.data.data[0]
                    this.viewStaffVisible = true
                } else {
                    this.$message({
                        type: 'danger',
                        message: '员工不存在！',
                        center: true
                    });
                    this.viewStaffVisible = false
                }
            })
        },
        updateStaff(id) {
            reqStaffById(id).then(res => {
                if(res.data.code === 200){
                    this.currentStaff = res.data.data[0]
                    this.updateStaffVisible = true
                } else {
                    this.$message({
                        type: 'danger',
                        message: '修改失败，当前记录正在被操作或不存在。',
                        center: true
                    });
                    this.updateStaffVisible = false
                    return false
                }
            })
        },
        handleUpdate(){
            let current = this.currentStaff
            let staff = {
                s_id: current.s_id,
                s_name: current.s_name,
                s_sex: current.s_sex,
                s_birth: current.s_birth,
                s_phone: current.s_phone,
                s_duty: current.s_duty,
                s_address: current.s_address,
                'department.de_id': current.department.de_id

            }
            reqStaffUpdate(staff).then(res => {
                console.log(staff);
                console.log(res);
                if(res.data.code === 200){
                    this.$message({
                        type: 'success',
                        message: '修改成功',
                        center: true
                    });
                    this.getStaffByCondition({pageNum: this.pageNum, pageSize: this.pageSize, selectCondition: this.condition})
                    this.getStaffCount(this.condition)
                    this.updateStaffVisible = false
                } else {
                    this.$message({
                        type: 'warning',
                        message: '修改失败，当前记录异常。',
                        center: true
                    });
                }
            })
        },
        deleteStaff(id) {   // 删除员工操作
            this.$confirm('此操作将永久删除该记录, 是否继续?', '警告', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'error'
            }).then(() => {
                reqStaffDelete(id).then(res => {
                    if(res.data.code === 200){
                        this.$message({
                            type: 'success',
                            message: '删除成功!',
                            center: true
                        });
                        this.getStaffCount(this.condition)
                        if(this.staffCount % this.pageSize === 1){
                            this.pageNum = this.pageNum - 1
                        }
                        this.getStaffsPage({pageNum: this.pageNum, pageSize: this.pageSize})
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
        handleQueryCondition(){
            this.pageNum = 1
            this.pageSize = 3
            this.getStaffByCondition({pageNum: this.pageNum, pageSize: this.pageSize, selectCondition: this.condition})
            this.getStaffCount(this.condition)
        }
    }
}
</script>

<style lang="scss">
.staff-table-component {
    .staff-table-pagination {
        margin-top: 20px;
    }
    .staff-table-condition {
        margin: 40px 0;
    }
    .staff-table-info {
        padding-left: 0; 
        font-size: 14px;
        display: flex;
        flex-direction: column;
        .el-form-item {
            margin: 0;
            label {
                color: rgba(0, 0, 0, 0.3);
                margin-right: 20px;
            }
        }
    }
    .staff-table-opera-btn {
        margin-right: 10px;
    }
    .el-dialog__body {
        padding-top: 0;
        padding-left: 50px;
    }
}
</style>