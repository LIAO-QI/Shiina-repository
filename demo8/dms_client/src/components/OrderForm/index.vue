<template>
    <div class="order-form-component">
        <!-- 头部面包屑 -->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home/index' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>订单管理</el-breadcrumb-item>
            <el-breadcrumb-item>订单录入</el-breadcrumb-item>
        </el-breadcrumb>
        <el-divider><i class="el-icon-magic-stick"></i></el-divider>
        <!-- 订单表单 -->
        <el-form :model="dynamicOrderForm" ref="dynamicOrderForm" label-width="100px">
            <el-form-item label="操作员">
                <el-select v-model="dynamicOrderForm.s_id" placeholder="选择操作员" clearable>
                    <el-option
                    v-for="item in operatorList"
                    :key="item"
                    :label="'操作员' + item"
                    :value="item"
                    >
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item 
                v-for="(drug, index) in dynamicOrderForm.drugOrder1s"
                :key="index"
                :label="'药品'+index"
            >
                <el-select v-model="drug.d_id" placeholder="选择药品" clearable>
                    <el-option
                    v-for="item in drugList"
                    :key="item.d_id"
                    :label="item.d_name"
                    :value="item.d_id"
                    >
                    </el-option>
                </el-select>
                <el-input-number v-model="drug.num" :min="1" :max="20" label="描述文字" size="small" class="drugCount"></el-input-number>
                <el-button type="danger" circle icon="el-icon-close" size="small" @click="removeDomin(index)" class="drugRemove"></el-button>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" round @click="submitOrder('dynamicOrderForm')">提交订单</el-button>
                <el-button round @click="addDomin()">添加药品</el-button>
                <el-button type="info" round @click="resetOrder()">重置信息</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import { reqOrderSave } from '@/api'
export default {
    data(){
        return {
            dynamicOrderForm: {
                s_id: '',
                drugOrder1s: [{
                    d_id: '',
                    num: 1
                }]
            }
        }
    },
    created(){
        this.getOrderOperator()
        this.getDrugs()
    },
    computed: {
        ...mapState([
            'operatorList',
            'drugList'
        ])
    },
    methods: {
        ...mapActions([
            'getOrderOperator',
            'getDrugs'
        ]),
        addDomin() {
            this.dynamicOrderForm.drugOrder1s.push({
                d_id: '',
                num: 1,
                key: new Date().toTimeString()
            })
        },
        removeDomin(index) {
            if (index !== -1 && this.dynamicOrderForm.drugOrder1s.length > 1) {
                this.dynamicOrderForm.drugOrder1s.splice(index, 1)
            } else {
                this.$message({
                    message: '至少包含一个药品！',
                    type: 'error',
                    center: true
                });
            }
        },
        submitOrder() {
            const date = new Date()
            const orderID = 'order' + date.getFullYear() + date.getMonth() + date.getDate()
            const order = {
                order_id: orderID,
                so_date: date.toLocaleDateString(),
                ...this.dynamicOrderForm
            }
            reqOrderSave(order).then(res => {
                if(res.data.code === 200){
                    this.$message({
                        message: '录入订单成功！',
                        type: 'success'
                    })
                    this.dynamicOrderForm = {
                        s_id: '',
                        drugOrder1s: [{
                            d_id: '',
                            num: 1
                        }]
                    }
                } else {
                    this.$message({
                        message: '订单录入存在问题',
                        type: 'error'
                    })
                }
            })
        },
        resetOrder(){
            this.dynamicOrderForm = {
                s_id: '',
                drugOrder1s: [{
                    d_id: '',
                    num: 1
                }]
            }
            this.$message({
                message: '重置信息成功，请重新输入信息',
                type: 'info',
                center: true
            })
        }
    }
}
</script>

<style lang="scss">
.order-form-component {
    .drugCount,.drugRemove {
        margin-left: 100px;
    }
}
</style>