<template>
    <div class="home-index-component">
        <h1 class="index-title">统计信息</h1>
        <el-row>
            <el-col :span="6" :offset="3">
                <div @click="jumpRoute('/home/incomeTable')">
                    <el-card class="index-card" shadow="hover" >
                        <div class="index-card-icon">
                            <img src="@/assets/income.png" alt="">
                        </div>
                        <h4 class="index-card-label">总收入</h4>
                        <span class="index-card-data">{{income}}</span>
                    </el-card>
                </div>
            </el-col>
            <el-col :span="6" :offset="6">
                <div @click="jumpRoute('/home/outcomeTable')">
                    <el-card class="index-card" shadow="hover">
                        <div class="index-card-icon">
                            <img src="@/assets/outcome.png" alt="">
                        </div>
                        <h4 class="index-card-label">总支出</h4>
                        <span class="index-card-data">{{outcome}}</span>
                    </el-card>
                </div>
            </el-col>
        </el-row>
        <el-row style="margin-top: 40px;">
            <el-col :span="6" :offset="3">
                <div @click="jumpRoute('/home/orderTable')">
                    <el-card class="index-card" shadow="hover">
                        <div class="index-card-icon">
                            <img src="@/assets/sale.png" alt="">
                        </div>
                        <h4 class="index-card-label">销售量</h4>
                        <span class="index-card-data">{{sale}}</span>
                    </el-card>
                </div>
            </el-col>
            <el-col :span="6" :offset="6">
                <div @click="jumpRoute('/home/drugTable')">
                    <el-card class="index-card" shadow="hover">
                        <div class="index-card-icon">
                            <img src="@/assets/stock.png" alt="">
                        </div>
                        <h4 class="index-card-label">库存量</h4>
                        <span class="index-card-data">{{stock}}</span>
                    </el-card>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
export default {
    data() {
        return {

        }
    },
    created() {
        this.getIncome()
        this.getOutcome()
        this.getSale()
        this.getStock()
    },
    computed: {
        ...mapState([
            'income',
            'outcome',
            'sale',
            'stock'
        ])
    },
    methods: {
        ...mapActions([
            'getIncome',
            'getOutcome',
            'getSale',
            'getStock'
        ]),
        jumpRoute(target) {
            console.log(target)
            
            this.$router.push(target)
        }
    }
}
</script>

<style lang="scss" scoped>
.home-index-component {
    .index-title {
        text-align: center;
        font-size: 28px;
        letter-spacing: 5px;
        color: #333;
        margin-bottom: 15px;
    }
    .index-card {
        &:hover {
            cursor: pointer;
        }
        .index-card-icon {
            width: 128px;
            height: 128px;
            margin: 0 auto;
            img {
                width: 100%;
                height: 100%;
                object-fit: contain;
                opacity: .9;
            }
        }
        .index-card-label {
            text-align: center;
            color: #666;
        }
        .index-card-data {
            width: 100%;
            display: inline-block;
            text-align: center;
            font-size: 24px;
            font-weight: 700;
            color: #F56C6C;
        }
    }
}
</style>