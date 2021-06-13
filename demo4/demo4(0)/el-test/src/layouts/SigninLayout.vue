<template>
  <div id="container">
    <el-container>
      <el-main class="SigninPage-main">
        <img class="SigninPage-logo" src="../assets/zhLogo.png" />
        <div class="SigninPage-box">
          <router-view />
          <div class="Signin-tip">
            未注册手机验证后自动登录，注册即代表同意
            <a href="https://www.zhihu.com/term/zhihu-terms">《知乎协议》</a>
            <a href="https://www.zhihu.com/term/privacy">《隐私保护指引》</a>
          </div>
          <div class="Separated-line"></div>
          <div class="SigninPage-box-socialLogin">
            <span>社交帐号登录</span>
            <div class="Login-choice">
              <el-button type="text">微信</el-button>
              <el-button type="text">QQ</el-button>
              <el-button type="text">微博</el-button>
            </div>
          </div>

          <div class="SigninPage-box-bottom">
            <el-button type="text" icon="el-icon-info">开通机构号</el-button>
            <div class="Separated-row"></div>
            <el-button type="text" icon="el-icon-download">下载知乎App</el-button>
          </div>
        </div>
      </el-main>

      <el-footer class="SingninPage-footer">
        <div class="SigninPage-zhLinks"></div>
        <div class="SigninPage-zhRights"></div>
        <div class="SigninPage-zhReports"></div>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "signinLayout",
  data() {
    return {
      user: {
        account: "",
        password: "",
      },
    };
  },
  methods: {},
};
</script>

<style scoped>
#container {
  width: 100vw;
  height: 100vh;
  background: url("../assets/signinBg.png") no-repeat;
  background-color: #b8e5f8;
  background-attachment: fixed;
  background-size: cover;
  overflow: auto;
}

.SigninPage-main {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top: 25px;
}

.SigninPage-logo {
  width: 128px;
  height: 81px;
  margin-bottom: 24px;
}

.SigninPage-box {
  width: 400px;
  min-width: 0;
  background-color: white;
  overflow: hidden;
  padding: 0;
  margin: 0;
  border-radius: 2px;
  box-shadow: 0 1px 3px rgba(26, 26, 26, 0.1);
  box-sizing: border-box;
}

/* .SigninPage-box-content {
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
} */

.Signin-tip {
  font-size: 13px;
  color: grey;
  padding: 0 25px;
}

.Signin-tip a {
  text-decoration: none;
}

.Separated-line {
  box-sizing: border-box;
  width: calc(100% - 50px);
  height: 1px;
  background-color: #ebebeb;
  margin: 10px 0 10px 25px;
}

.SigninPage-box-socialLogin {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  color: #8590a6;
  font-size: 15px;
  padding: 0 25px;
  margin-bottom: 8px;
}

.SigninPage-box-socialLogin >>> .el-button {
  color: #8590a6;
  font-size: 15px;
}

.SigninPage-box-bottom {
  background-color: #f6f6f6;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  padding: 8px 25px;
}

.Separated-row {
  box-sizing: border-box;
  width: 2px;
  height: 20px;
  background-color: #ebebeb;
  margin-top: 10px;
}

.SigninPage-box-bottom >>> .el-button {
  color: #0084ff;
  font-size: 16px;
}
</style>