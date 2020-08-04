<template>
    <div>
        index<br />
        <router-link to="find">发现页</router-link><br />
        <router-link to="login">退出登录</router-link>
    </div>
</template>

<script>
export default {
    data() {
        return {
            user: {
                account: ''
            }
        }
    }    
}
</script>

<style>

</style>