<template>
    <div class="category-table-component">
        <!-- 头部面包屑 -->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>药品管理</el-breadcrumb-item>
            <el-breadcrumb-item>类别管理</el-breadcrumb-item>
        </el-breadcrumb>
        <el-divider><i class="el-icon-magic-stick"></i></el-divider>
        <!-- 药品分类列表 -->
        <el-table
            :data="drugCategory"
            stripe
            style="width: 100%"
        >
            <el-table-column
                prop="c_id"
                label="#"
                width="150"
            >
            </el-table-column>
            <el-table-column
                prop="c_name"
                label="分类名称"
                width="200"
            >
            </el-table-column>
            <el-table-column
                prop="c_remarks"
                label="功效说明"
                width="400"
            >
            </el-table-column>
            <el-table-column
                label="操作"
            >
                <template slot-scope="category">
                    <el-button 
                        icon="el-icon-edit" 
                        type="warning" 
                        plain 
                        circle 
                        size="small"
                        @click="updateCategory(category.row.c_id)"
                        class="drugs-table-opera-btn">
                    </el-button>
                    <el-button 
                        icon="el-icon-delete" 
                        type="danger" 
                        plain 
                        circle
                        @click="deleteCategory(category.row.c_id)"
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
                        @click="saveCategoryVisible = true"
                    >
                        添加分类
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
        <!-- 添加类别的模态框 -->
        <el-dialog title="类别信息" :visible.sync="saveCategoryVisible" center width="30%" top="15vh">
            <el-divider><i class="el-icon-edit"></i></el-divider>
            <el-form :model="categoryInfo" class="category-table-save" label-width="80px" label-position="left" :rules="rules" ref="categoryForm">
                <el-form-item label="类别名称" prop="c_name">
                    <el-col :span="12">
                        <el-input v-model="categoryInfo.c_name" clearable></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="效果说明" prop="c_remarks">
                    <el-col :span="20">
                        <el-input type="textarea" v-model="categoryInfo.c_remarks" clearable rows="3"></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item>
                    <el-col :span="8">
                        <el-button type="success" style="width: 100%;" round @click="handleSave('categoryForm')">保存</el-button>
                    </el-col>
                    <el-col :span="8" :offset="4">
                        <el-button type="warning" style="width: 100%;" round @click="saveCategoryVisible = false">取消</el-button>
                    </el-col>
                </el-form-item>
            </el-form>
        </el-dialog>
        <!-- 修改类别的模态框 -->
        <el-dialog title="类别信息" :visible.sync="updateCategoryVisible" center width="30%" top="12vh">
            <el-divider><i class="el-icon-edit"></i></el-divider>
            <el-form :model="currentCategory" class="category-table-update" label-width="80px" label-position="left">
                <el-form-item label="类别编号">
                    <el-col :span="12">
                        <el-input v-model="currentCategory.c_id" clearable disabled></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="类别名称">
                    <el-col :span="12">
                        <el-input v-model="currentCategory.c_name" clearable></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="效果说明">
                    <el-col :span="12">
                        <el-input v-model="currentCategory.c_remarks" clearable></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item>
                    <el-col :span="8">
                        <el-button type="success" style="width: 100%;" round @click="handleUpdate()">修改</el-button>
                    </el-col>
                    <el-col :span="8" :offset="4">
                        <el-button type="warning" style="width: 100%;" round @click="updateCategoryVisible = false">取消</el-button>
                    </el-col>
                </el-form-item>
            </el-form>
        </el-dialog>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import { reqCategorySave, reqCategoryDelete, reqCategoryById, reqCategoryUpdate } from '@/api'
export default {
    data () {
        return {
            saveCategoryVisible: false,
            updateCategoryVisible: false,
            currentCategory: {
                c_id: '',
                c_name: '',
                c_remarks: ''
            },
            categoryInfo: {
                c_name: '',
                c_remarks: ''
            },
            rules: {
                c_name: [
                    { required: true, message: '确认分类名称', trigger: 'blur' }
                ],
                c_remarks: [
                    { required: true, message: '输入分类描述信息', trigger: 'blur' }
                ]
            }
        }
    },
    created(){
        this.getDrugCategory()
    },
    computed: {
        ...mapState([
            'drugCategory'
        ])
    },
    methods: {
        ...mapActions([
            'getDrugCategory'
        ]),
        updateCategory(id) {    // 点击修改按钮出发事件
            reqCategoryById(id).then(res => {
                if(res.data.code === 200){
                    this.currentCategory = res.data.data[0]
                    this.updateCategoryVisible = true
                } else {
                    this.updateCategoryVisible = false
                    this.$message({
                        type: 'warning',
                        message: '当前数据异常，不能修改。',
                        center: true
                    });
                }
            })
        },
        deleteCategory(id) {    // 点击删除按钮触发事件
            this.$confirm('此操作将永久删除该记录, 是否继续?', '警告', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'error'
            }).then(() => {
                reqCategoryDelete(id).then(res => {
                    if(res.data.code === 200){
                        this.$message({
                            type: 'success',
                            message: '删除记录成功!',
                            center: true
                        });
                        this.getDrugCategory()
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
        handleSave(form) {      // 点击添加按钮执行添加操作
            this.$refs[form].validate((valid) => {
                if (valid) {
                    reqCategorySave(this.categoryInfo).then(res => {
                        if( res.data.code === 200 ){
                            this.$message({
                                message: '提交信息成功！',
                                type: 'success',
                                center: true
                            });
                            this.$refs[form].resetFields();
                            this.getDrugCategory()
                            this.saveCategoryVisible = false
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
            reqCategoryUpdate(this.currentCategory).then(res => {
                if(res.data.code === 200){
                    this.$message({
                        type: 'success',
                        message: '数据修改成功。',
                        center: true
                    });
                    this.getDrugCategory()
                } else {
                    this.$message({
                        type: 'warning',
                        message: '当前数据异常，暂时不能修改。',
                        center: true
                    });
                }
                this.updateCategoryVisible = false
            })
        }
    }
}
</script>

<style lang="scss">

</style>