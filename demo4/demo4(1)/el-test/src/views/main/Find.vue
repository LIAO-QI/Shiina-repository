<template>
  <div id="container">
    <el-container>
      <el-header>
        <div class="Header-inner">
          <a href="https://www.zhihu.com" class="Header-link">知乎</a>
          
          <el-menu 
            class="Header-menu" 
            router
            :default-active="defaultActive" 
            mode="horizontal">
            <el-menu-item index="/">首页</el-menu-item>
            <el-menu-item index="find">发现</el-menu-item>
            <el-menu-item index="message">等你来答</el-menu-item>
          </el-menu>

          <el-input
            placeholder="请输入搜索内容"
            suffix-icon="el-icon-search"
            v-model="searchContent"
            class="Search-input"
            size="medium"
          />

          <el-button type="primary" round size="small">提问</el-button>

          <div class="Header-box">
            <el-button type="text" icon="el-icon-bell"></el-button>
            <el-button type="text" icon="el-icon-message"></el-button>
            <span @click="logout">{{user.account}}</span>
          </div>
        </div>
      </el-header>
      
      <el-main>
        <div class="Main-inner">
          <div class="Main-newlyTopic">
            <div class="topic"><i class="el-icon-document"></i><span>最新专题</span></div>
            <div class="Main-row-1">
              <div class="content"><img src="../../assets/logo.png" /></div>
              <div class="content"><img src="../../assets/logo.png" /></div>
            </div>
            <div class="Main-row-1">
              <div class="content"><img src="../../assets/logo.png" /></div>
              <div class="content"><img src="../../assets/logo.png" /></div>
            </div>
            <div class="Main-Item-bottom">
              <el-button round>查看更多专题<i class="el-icon-arrow-right"></i></el-button>
            </div>
          </div>

          <div class="Main-roundDiscuss">
            <div class="topic"><i class="el-icon-menu"></i><span>圆桌讨论</span></div>
            <div class="Main-row-1">
              <div class="content"><img src="../../assets/logo.png" /></div>
              <div class="content"><img src="../../assets/logo.png" /></div>
            </div>
            <div class="Main-row-1">
              <div class="content"><img src="../../assets/logo.png" /></div>
              <div class="content"><img src="../../assets/logo.png" /></div>
            </div>
            <div class="Main-Item-bottom">
              <el-button round>查看更多圆桌<i class="el-icon-arrow-right"></i></el-button>
            </div>
          </div>

          <div class="Main-hotStar">
            <div class="topic"><i class="el-icon-star-on"></i><span>热门收藏夹</span></div>
            <div class="Main-row-2">
              <div class="content"><img src="../../assets/logo.png" /></div>
              <div class="content"><img src="../../assets/logo.png" /></div>
            </div>
            <div class="Main-row-2">
              <div class="content"><img src="../../assets/logo.png" /></div>
              <div class="content"><img src="../../assets/logo.png" /></div>
            </div>
            <div class="Main-Item-bottom">
              <el-button round>查看更多收藏夹<i class="el-icon-arrow-right"></i></el-button>
            </div>
          </div>

          <div class="Main-specialColumn">
            <div class="topic"><i class="el-icon-edit"></i><span>专栏</span></div>
            <div class="Main-row-3">
              <div class="content"><img src="../../assets/logo.png" /></div>
              <div class="content"><img src="../../assets/logo.png" /></div>
              <div class="content"><img src="../../assets/logo.png" /></div>
            </div>
            <div class="Main-Item-bottom">
              <el-button round>查看更多专栏<i class="el-icon-arrow-right"></i></el-button>
            </div>
          </div>

          <div class="Main-footer">
            <a href="https://www.shiinaliu.com">https://www.shiinaliu.com ©2020 Shiina</a>
          </div>

          <div class="back-to-top"><el-button type="primary" circle icon="el-icon-arrow-up" @click="scrollToTop"></el-button></div>
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  name: 'find',
  data() {
    return {
      defaultActive: 'find',
      searchContent: '',
      user: {
        account: ''
      }
    }
  },
  methods: {
    init() {
      this.user.account = this.$route.query.account;
      console.log(this.$route.query.account);
    },
    scrollToTop() {
      window.scrollTo(0,0);
    },
    logout() {
      this.$router.push('/login');
    }
  },
  beforeCreate() {
    console.log("bcreate");
  },
  created() {
    console.log("created");
    this.init();
  },
  /* beforeRouteEnter(to, form, next) {
    next((vm) => {
      // 未登录状态
      console.log(vm);
      vm.$router.push("/login");
    });
  }, */
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
}

/**
  * 导航栏样式
 */

.Header-inner {
  min-width: 1200px;
  width: 100%;
  display: flex;
  flex-direction: row;
  align-items: center;
  position: fixed;
  z-index: 9999;
  background-color: white;
  box-shadow: 0 1px 3px rgba(26,26,26,.1);
}

.Header-link {
  margin-left: 15vw;
  text-decoration: none;
  font-size: 40px;
  letter-spacing: 3px;
  font-family: "楷体";
  color: rgba(0, 132, 255);
  margin-right: 20px;
}

.Header-menu >>> .el-menu-item {
  padding: 0 20px;
  font-size: 15px;
}

.Search-input {
  width: 21vw;
  margin-left: 20px;
  margin-right: 15px;
}

.Header-box {
  margin-left: 100px;
  margin-right: 15vw;
  display: flex;
}

.Header-box >>> .el-button {
  padding-left: 15px;
  font-size: 22px;
  color: grey;
}

.Header-box span {
  padding-left: 25px;
  cursor: pointer;
}


/**
  * 内容样式
 */


.Main-inner {
  width: 70vw;
  background-color: #f6f6f6;
  overflow: hidden;
  padding: 30px 15vw 0 15vw;
}

.topic span{
  color: black;
  font-size: 26px;
  font-weight: bold;
}

.topic >>> i {
  color: rgb(0, 132, 255);
  font-size: 26px;
  font-weight: bold;
  margin-right: 15px;
  margin-bottom: 10px;
}

.Main-newlyTopic
,.Main-roundDiscuss
,.Main-hotStar
,.Main-specialColumn
,.Main-footer{
  width: 70vw;
  margin-bottom: 50px;
}

.Main-row-1
,.Main-row-2
,.Main-row-3 {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-top: 20px;
}

.Main-Item-bottom {
  margin-top: 40px;
  text-align: center;
}

.Main-Item-bottom >>> .el-button
,.Main-Item-bottom >>> i {
  color: rgb(133, 144, 166);
  font-weight: bold;
}

.content {
  border: 1px solid #ebebeb;
  padding: 50px;
}

.Main-footer {
  text-align: center;
  margin-bottom: 100px;
}

.Main-footer a {
  text-decoration: none;
  color: grey;
}

.back-to-top {
  position: fixed;
  top: 91vh;
  right: 1vw;
  
}
</style>