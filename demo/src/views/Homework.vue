<template>
  <div class="main">
    <van-overlay :show="show" @click="close()" z-index="9999">
      <div class="searchInput">
        <input
          :value="info.search"
          :placeholder="tips.search"
          class="sInput"
          @click.stop="stopClosing()"
          @keydown="toSearch()"
        />
      </div>
    </van-overlay>

    <van-nav-bar
      :left-text="text.title"
      z-index="999"
      fixed
      @click-right="show = true"
      class="navBar"
    >
      <template #right>
        <van-icon name="search" size="20" />
      </template>
    </van-nav-bar>

    <div class="homework-middle">
      <van-button
        round
        type="primary"
        size="small"
        @click="showHW = true"
        class="create-btn"
        :text="text.createBtn"
      />

      <van-overlay :show="showHW" @click="close()" z-index="9999">
        <div class="hwTmp">
          <input class="inputTmp" type="text" :value="info.subjectName" />
          <textarea class="inputTmp" :value="info.homeworkInfo" />
          <input class="inputTmp" type="text" :value="info.deadline" />
          <input
            class="inputTmp"
            type="button"
            :value="text.commitBtn"
            @click="createHW()"
          />
        </div>
      </van-overlay>

      <!-- 作业信息 -->
      <div class="hw-container">
        <!-- <div class="hw">
          <input class="input" type="text" :value="info.subjectName" />
          <textarea class="input" :value="info.homeworkInfo" />
          <input class="input" type="text" :value="info.deadline" />
          <div class="btn-box">
            <van-button
              round
              type="primary"
              size="small"
              class="btn"
              :text="text.modifyBtn"
            />
            <van-button
              round
              type="primary"
              size="small"
              class="btn"
              :text="text.deleteBtn"
            />
          </div>
        </div> -->
      </div>
    </div>

    <van-tabbar v-model="text.active" class="tabbar" z-index="999">
      <van-tabbar-item icon="home-o" replace to="/main" />
      <van-tabbar-item icon="todo-list-o" />
      <van-tabbar-item icon="calender-o" replace to="/subject" />
    </van-tabbar>
  </div>
</template>

<script>
import { Button, NavBar, Icon, Overlay, Tabbar, TabbarItem } from "vant";

export default {
  name: "homework",
  data() {
    return {
      info: {
        search: "",
        subjectName: "Javaweb",
        homeworkInfo: "实验三",
        deadline: "2020-5-11",
      },
      text: {
        title: "作业板",
        active: 1,
        createBtn: "创 建",
        commitBtn: "确 认",
        modifyBtn: "修 改",
        deleteBtn: "删 除",
      },
      show: false,
      tips: {
        search: "请输入搜索的内容",
      },
      showHW: false,
    };
  },
  components: {
    [Button.name]: Button,
    [NavBar.name]: NavBar,
    [Icon.name]: Icon,
    [Overlay.name]: Overlay,
    [Tabbar.name]: Tabbar,
    [TabbarItem.name]: TabbarItem,
  },
  methods: {
    toSearch() {
      /* 处理搜索事务，返回搜索结果 */
      if (event.keyCode == 13) alert("结果");
    },
    close() {
      this.show = false;
      this.info.search = "";

      this.showHW = false;
    },
    stopClosing() {
      let sInput = document.querySelector(".sInput");
      sInput.addEventListener("click", (e) => {
        e.stopPropagation();
      });

      let hwTmp = document.querySelector(".hwTmp");
      hwTmp.addEventListener("click", (e) => {
        e.stopPropagation();
      });
    },
    createHW() {
      let hwContainer = document.querySelector(".hw-container");
      let hwObject = document.querySelector(".hwTmp");
      hwObject.className = "hw";
      hwContainer.append(hwObject);
    },
  },
};
</script>

<style>
.main {
  width: 100vw;
  font-family: "Times New Roman", Times, serif;
}

.navBar {
  height: 8vh;
  background-color: rgba(65, 184, 131, 0.7);
}

.searchInput {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.sInput {
  height: 60px;
  width: 50vw;
  padding-left: 30px;
  border-radius: 20px;
  border: 0;
  outline: 0;
}

.create-btn {
  background-color: #41b883;
  margin: 10px;
}

.create-btn:hover {
  color: black;
  background-color: #339167;
  transition: background-color 0.5s;
}

.btn {
  background-color: #bd6721;
  margin: 10px;
}

.btn:hover {
  color: black;
  background-color: #f83d04;
  transition: background-color 0.5s;
}

.homework-middle {
  margin-top: 8vh;
  height: 84vh;
  background: center url(../assets/logo.png) no-repeat;
  opacity: 0.7;
}

.tabbar {
  height: 8vh;
  background-color: rgba(65, 184, 131, 1);
}

.hw {
  border: 3px solid rgba(65, 184, 131, 0.5);
  margin-bottom: 40px;
  box-shadow: 0 0 10px rgba(65, 184, 131, 0.7);
}

.input {
  display: block;
  border-color: rgba(65, 184, 131, 0.7);
  width: 95vw;
  border: 0;
  padding: 5px;
}

.btn-box {
  display: flex;
  flex-direction: row;
  justify-content: center;
}

/* .btn-box input {
		background-color: inherit;
		border: 0;
	}
	
	.btn-box input:hover {
		cursor: pointer;
		color: rgb(65,184,131);
		transition: color .5s;
	} */

.hwTmp {
  border: 1px solid rgba(65, 184, 131, 0.5);
  box-shadow: 0 0 30px rgba(65, 184, 131, 0.7);
  background-color: white;
  display: flex;
  flex-direction: column;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
</style>