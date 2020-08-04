<template>
  <div class="SigninPage-box-content">
    <div class="Signin-tabs">
      <div class="Signin-tab" @click="Tab">免密码登录</div>
      <div class="Signin-tab Signin-tab-active">密码登录</div>
    </div>
    <div class="Signin-account">
      <input type="text" class="Input" :value="user.account" placeholder="手机号或邮箱" />
      <div class="Signin-errorTip-hidden">请输入手机号或邮箱</div>
    </div>
    <div class="Signin-password">
      <input type="password" class="Input" :value="user.password" placeholder="密码" />
      <div class="Signin-errorTip-hidden">请输入密码</div>
    </div>
    <div class="Login-options">
      <el-button type="text">海外手机号登录</el-button>
      <el-button type="text">忘记密码？</el-button>
    </div>
    <div>
      <el-button type="primary" class="Login" size="medium">登录</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "signin",
  data() {
    return {
      user: {
        account: "",
        password: "",
      },
    };
  },
  methods: {
    Tab() {
      this.$router.push('/login/signup');
    }
  },
};
</script>

<style scoped>
.SigninPage-box-content {
  padding: 20px 25px;
}

.Signin-tabs {
  display: flex;
  flex-direction: row;
  margin-bottom: 40px;
}

.Signin-tab {
  margin-right: 20px;
  cursor: pointer;
}

.Signin-tab-active {
  font-weight: bold;
}

.Signin-account,
.Signin-password {
  margin-bottom: 10px;
}

.Signin-errorTip-hidden {
  position: absolute;
  margin-top: -32px;
  font-size: 14px;
  color: #f1403c;
  display: none;
}

.Input {
  width: 100%;
  height: 40px;
  border: 0;
  outline: none;
  border-bottom: 1px solid #ebebeb;
}

.Login-options {
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
}

.Login {
  width: 100%;
  margin-bottom: 20px;
}
</style>