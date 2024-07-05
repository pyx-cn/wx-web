<template>
  <!-- 总容器 -->
  <div class="wrapper">
    <header>
      <i class="fa fa-angle-left" onclick="history.go(-1)"></i>
      <p>我的预约</p>
      <div></div>
    </header>
    <div class="top-ban"></div>

    <ul>
      <li v-for="(item, index) in list.data" :key="index">
        <div class="left">
          <p>{{ item.orders.orderdate }}</p>
          <p>{{ item.setmeal.name }}</p>
        </div>
        <div
          class="right"
          v-if="item.orders.state === 1"
          @click="toCancel(index)"
        >
          取消预约
        </div>
        <div class="right" v-if="item.orders.state === 0">
          <div @click="toApp(index)">重新预约</div>
          <!-- <div @click="delApp(index)">删除记录</div> -->
        </div>
        <div class="right" v-if="item.orders.state === 3">已归档</div>
      </li>
    </ul>

    <div class="bottom-ban"></div>
    <Footer></Footer>
  </div>
</template>

<script setup>
import Footer from "@/components/Footer.vue";
import { ref, reactive, toRefs, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { getSessionStorage, setSessionStorage } from "../common.js";
import axios from "axios";

const router = useRouter();
const route = useRoute();

const user = getSessionStorage("user");
const list = reactive({});

function getOrdersByUserId() {
  const token = getSessionStorage("token");
  // axios.get('http://10.25.161.174:8080/getOrdersByUserId', {
  axios
    .get("http://localhost:8080/getOrdersByUserId", {
      params: {
        userId: user.userid,
      },
      headers: {
        Authorization: `${token}`,
      },
    })
    .then((res) => {
      list.data = res.data.result;
      console.log(list.data);
    });
}

const toCancel = (index) => {
  const token = getSessionStorage("token");
  const item = list.data[index];
  item.orders.state = 1;
  // axios.post('http://10.25.161.174:8080/cancelOrder', `orderId=${item.orders.orderid}`)
  axios
    .post(
      "http://localhost:8080/cancelOrder",
      `orderId=${item.orders.orderid}`,
      {
        headers: {
          Authorization: `${token}`,
        },
      }
    )
    .then((res) => {
      getOrdersByUserId();
    });
};

const toApp = (index) => {
  const token = getSessionStorage("token");
  const item = list.data[index];
  item.orders.state = 0;
  console.log(item.orders.state);
  // axios.post('http://10.25.161.174:8080/reOrder', `orderId=${item.orders.orderid}`)
  axios
    .post("http://localhost:8080/reOrder", `orderId=${item.orders.orderid}`, {
      headers: {
        Authorization: `${token}`,
      },
    })
    .then((res) => {
      getOrdersByUserId();
    });
};

const delApp = (index) => {
  const token = getSessionStorage("token");
  const item = list.data[index];
  item.orders.state = 1;
  axios
    .post(
      "http://localhost:8080/delOrder",
      `orderId=${item.orders.orderid}`,
      {
        headers: {
          Authorization: `${token}`,
        },
      }
    )
    .then((res) => {
      getOrdersByUserId();
    });
}

onMounted(getOrdersByUserId);
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

/*********************** ul ***********************/
ul {
  width: 86vw;
  margin: 0 auto;
}

ul li {
  width: 100%;
  height: 14vw;
  border-bottom: solid 1px #eee;

  display: flex;
  justify-content: space-between;
  align-items: center;
}

ul li .left {
  user-select: none;
  cursor: pointer;
}

ul li .left p:first-child {
  color: #555;
  font-size: 3.3vw;
}

ul li .left p:last-child {
  color: #333;
  font-size: 4.2vw;
  font-weight: 600;
}

ul li .right {
  font-size: 4vw;
  color: #e6a23c;
}
</style>