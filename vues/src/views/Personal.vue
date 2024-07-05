<template>
  <!-- 总容器 -->
  <div class="wrapper">
    <header>
      <!-- <i class="fa fa-angle-left" onclick="history.go(-1)"></i> -->
      <LastPage></LastPage>
      <p>个人中心</p>
      <div></div>
    </header>
    <div class="top-ban"></div>

    <section>
      <div class="info">
        <div class="content">
          <img src="../assets/img/user.png" />
          <div>
            <p>{{ user.realname }}</p>
            <p>账号: {{ user.userid }}</p>
          </div>
        </div>
      </div>
      <ul>
        <li @click="toApplist">
          <div class="left">
            <i class="fa fa-user-plus"></i>
            <p>我的预约</p>
          </div>
          <div class="right">
            <i class="fa fa-angle-right"></i>
          </div>
        </li>
        <li>
          <div class="left">
            <i class="fa fa-phone"></i>
            <p>我的服务</p>
          </div>
          <div class="right">
            <i class="fa fa-angle-right"></i>
          </div>
        </li>
        <li>
          <div class="left">
            <i class="fa fa-bed"></i>
            <p>我的医生</p>
          </div>
          <div class="right">
            <i class="fa fa-angle-right"></i>
          </div>
        </li>
        <li>
          <div class="left">
            <i class="fa fa-sticky-note"></i>
            <p>问诊订单</p>
          </div>
          <div class="right">
            <i class="fa fa-angle-right"></i>
          </div>
        </li>
        <li>
          <div class="left">
            <i class="fa fa-cart-plus"></i>
            <p>商城订单</p>
          </div>
          <div class="right">
            <i class="fa fa-angle-right"></i>
          </div>
        </li>
        <li @click="toLogin">
          <div class="left">
            <i class="fa fa-sign-out-alt"></i>
            <p>退出登录</p>
          </div>
          <div class="right">
            <i class="fa fa-angle-right"></i>
          </div>
        </li>
      </ul>
    </section>

    <div class="bottom-ban"></div>
    <Footer></Footer>
  </div>
</template>

<script setup>
import LastPage from "@/components/LastPage.vue";
import Footer from "@/components/Footer.vue";
import { ref, reactive, toRefs, onMounted, onBeforeMount } from "vue";
import { useRoute, useRouter } from "vue-router";
import { getSessionStorage, setSessionStorage } from "../common.js";
import axios from "axios";

const router = useRouter();
const route = useRoute();

let user = reactive({
  userid: "",
  password: "",
  realname: "",
  sex: 0,
  identitycard: "254852364142366454",
  birthday: "1990-06-22",
});

function getCurUser() {
  user = getSessionStorage("user");
  //   console.log(user);
}

function toApplist() {
  router.push("/appointmentlist");
}

function toLogin() {
  router.push("/");
}

onBeforeMount(getCurUser);
</script>

<style scoped>
/*********************** 总容器 ***********************/
.wrapper {
  width: 100%;
  height: 100%;
  background-color: #f9f9f9;
}

/*********************** header ***********************/
header {
  width: 100%;
  height: 15.7vw;
  background-color: #fff;

  position: fixed;
  left: 0;
  top: 0;

  display: flex;
  align-items: center;
  justify-content: space-between;

  box-sizing: border-box;
  padding: 0 3.6vw;
}

header .fa {
  font-size: 8vw;
}

/*********************** footer ***********************/
footer {
  width: 100%;
  height: 14.2vw;
  box-sizing: border-box;
  border-top: solid 1px #e9e9e9;
  background-color: #fff;

  position: fixed;
  left: 0;
  bottom: 0;
}

footer ul {
  width: 100%;
  height: 14.2vw;
  display: flex;
  align-items: center;
  justify-content: space-around;
}

footer ul li {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;

  font-size: 3vw;
  color: #999;

  user-select: none;
  cursor: pointer;
}

footer ul li .fa {
  font-size: 5vw;
}

/*********************** common样式 ***********************/
.top-ban {
  width: 100%;
  height: 15.7vw;
}

.bottom-ban {
  width: 100%;
  height: 14.2vw;
}

/*********************** section ***********************/
section {
  width: 100%;
}

section .info {
  width: 100%;
  height: 30vw;
  background-image: linear-gradient(135deg, #7db35d, #02a6c9, #02a6c9);
  display: flex;
  align-items: center;
}

section .info .content {
  width: 90vw;
  margin: 0 auto;
  display: flex;
}

section .info .content img {
  width: 14vw;
  height: 14vw;
  border-radius: 7vw;
}

section .info .content div {
  height: 14vw;
  margin-left: 3vw;
  color: #fff;
}

section .info .content div p:first-child {
  font-size: 4.8vw;
}

section .info .content div p:last-child {
  font-size: 3.2vw;
  margin-top: 2.6vw;
}

section ul {
  width: 86vw;
  margin: 0 auto;
}

section ul li {
  width: 100%;
  height: 14vw;
  border-bottom: solid 1px #eee;
  color: #555;
  font-size: 4.2vw;
  font-weight: 600;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

section ul li .left {
  display: flex;
  align-items: center;
}

section ul li .left p {
  margin-left: 3vw;
}

section ul li .right {
  user-select: none;
  cursor: pointer;
}

section ul li .right i {
  font-size: 6vw;
}

section .fa {
  width: 21px;
}
</style>
