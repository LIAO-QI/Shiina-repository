<template>
  <div class="SignupPage-box-content">
    <div class="Signup-tabs">
      <div class="Signup-tab Signup-tab-active">免密码登录</div>
      <div class="Signup-tab" @click="tab">密码登录</div>
    </div>
    <div class="Signup-account">
      <el-select v-model="value" class="Signup-account-select">
        <el-option
          v-for="item in options"
          :key="item.value"
          :value="item.value"
          :label="item.label"
        ></el-option>
      </el-select>
      <input type="text" class="Input" v-model="user.account" placeholder="手机号" />
      <div class="Signup-errorTip-hidden">请输入手机号</div>
    </div>
    <div class="Signup-verifyCode">
      <input type="text" class="Input" v-model="user.verifyCode" placeholder="请输入6位短信验证码" />
      <div class="GetVerifyCode">
        <el-button type="text">获取短信验证码</el-button>
      </div>
      <div class="Signup-errorTip-hidden">请输入短信验证码</div>
    </div>
    <div class="ReceiveVerifyCode">
      <el-button type="text">接收语音验证码</el-button>
    </div>
    <div>
      <el-button type="primary" class="Login" size="medium" @click="login">注册/登录</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "signup",
  data() {
    return {
      user: {
        account: "",
        verifyCode: "",
      },
      options: [
        {
          value: "选项1",
          label: "中国+86",
        },
        {
          value: "选项2",
          label: "美国+1",
        },
        {
          value: "选项3",
          label: "日本+81",
        },
      ],
      value: "中国+86",
    };
  },
  methods: {
    tab() {
      this.$router.push('/login')
    },
    login() {
      this.$router.push({
        path: '/find',
        query: {
          account: this.user.account
        }
      });
    }
  },
};
</script>

<style scoped>
.SignupPage-box-content {
  padding: 20px 25px;
}

.Signup-tabs {
  display: flex;
  flex-direction: row;
  margin-bottom: 40px;
}

.Signup-tab {
  margin-right: 20px;
  cursor: pointer;
}

.Signup-tab-active {
  font-weight: bold;
}

.Signup-account,
.Signup-verifyCode {
  display: flex;
  justify-content: space-between;
}

.Signup-account {
  margin-bottom: 20px;
}

.Signup-verifyCode {
  margin-bottom: 5px;
}

.Signup-account-select {
  width: 150px;
}

.Signup-errorTip-hidden {
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

.Signup-account .Input {
  padding-left: 10px;
}

.GetVerifyCode {
  border-bottom: 1px solid #ebebeb;
}

.ReceiveVerifyCode {
  display: flex;
  justify-content: flex-end;  
  margin-bottom: 15px;
}

.ReceiveVerifyCode >>> .el-button {
  color: grey;
}

.Login {
  width: 100%;
  margin-bottom: 20px;
}
</style>