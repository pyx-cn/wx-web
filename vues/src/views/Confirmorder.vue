<template>
  <!-- 总容器 -->
  <div class="wrapper">
    <header>
      <LastPage></LastPage>
      <!-- <i class="fa fa-angle-left" onclick="history.go(-1)"></i> -->
      <p>确认您的订单</p>
      <div></div>
    </header>
    <div class="top-ban"></div>

    <section>
      <div class="title">
        <p>体检人信息</p>
      </div>
      <table>
        <tr>
          <td>姓名:</td>
          <td>{{ user.realname }}</td>
        </tr>
        <tr>
          <td>证件号码:</td>
          <td>{{ user.identitycard }}</td>
        </tr>
        <tr>
          <td>出生日期:</td>
          <td>{{ user.birthday }}</td>
        </tr>
      </table>
      <div class="title">
        <p>体检日期</p>
      </div>
      <table>
        <tr>
          <td>{{ selectDay }}</td>
        </tr>
      </table>
      <div class="title">
        <p>体检机构</p>
      </div>
      <table>
        <tr>
          <td colspan="2">{{ hospital.data?.name }}</td>
        </tr>
        <tr>
          <td>营业时间:</td>
          <td>{{ hospital.data?.businesshours }}</td>
        </tr>
        <tr>
          <td>采血截止:</td>
          <td>{{ hospital.data?.deadline }}</td>
        </tr>
        <tr>
          <td>机构电话:</td>
          <td>{{ hospital.data?.telephone }}</td>
        </tr>
        <tr>
          <td>机构地址:</td>
          <td>{{ hospital.data?.address }}</td>
        </tr>
      </table>
      <div class="title">
        <p>套餐类型</p>
      </div>
      <table>
        <tr>
          <td>{{ setmeal.data?.name }}</td>
        </tr>
      </table>
    </section>

    <div class="bottom-btn">
      <div class="first">
        实付款: <span>￥{{ setmeal.data?.price }}</span>
      </div>
      <div class="last" @click="toSuccess">确认支付</div>
    </div>

    <div class="bottom-ban"></div>
    <Footer></Footer>
  </div>
</template>

<script setup>
import Footer from "@/components/Footer.vue";
import LastPage from "@/components/LastPage.vue";
import {
  ref,
  reactive,
  toRefs,
  onMounted,
  toDisplayString,
  onRenderTriggered,
} from "vue";
import { useRoute, useRouter } from "vue-router";
import { getSessionStorage, setSessionStorage } from "../common.js";
import axios from "axios";

const router = useRouter();
const route = useRoute();

const hpId = route.query.hpId;
const smId = route.query.smId;
const selectDay = route.query.selectDay;

const user = getSessionStorage("user");
const orderid = ref();
//创建对象
const hospital = reactive({});
const setmeal = reactive({});

const getHospital = async () => {
  const token = getSessionStorage("token");
  // console.log(hpId);
  // axios.get('http://10.25.161.174:8080/getHospitalById', {
  await axios
    .get("http://localhost:8080/getHospitalById", {
      params: {
        hpId: hpId,
      },
      headers: {
        Authorization: `${token}`,
      },
    })
    .then((res) => {
      hospital.data = res.data.result;
      // console.log(res.data.result)
      console.log(hospital.data);
    });
};

const getSetmealById = async () => {
  const token = getSessionStorage("token");
  await axios
    .get("http://localhost:8080/getSetmealById", {
      params: {
        smId: smId,
      },
      headers: {
        Authorization: `${token}`,
      },
    })
    .then((res) => {
      setmeal.data = res.data.result;
      console.log(setmeal.data);
    });
};

const toSuccess = () => {
  // console.log(selectDay);
  // console.log(user.userid);
  // console.log(hpId);
  // console.log(smId)

  const token = getSessionStorage("token");
  console.log(token);
  // axios.post('http://10.25.161.174:8080/addOrder', {
  axios
    .post(
      "http://localhost:8080/addOrder",
      {
        orderdate: selectDay,
        userid: user.userid,
        hpid: hpId,
        smid: smId,
      },
      {
        headers: {
          Authorization: `${token}`,
        },
      }
    )
    .then((res) => {
      if (res.data.code == 111) {
        alert("不可重复预约");
      } else {
        orderid.value = res.data.result;
        // console.log(res.data.result)
        console.log("订单编号");
        console.log(orderid.value);
        toPay();
      }
    });

  // router.push("/appointmentsuccess");
};

function toPay() {
  const url = `http://localhost:8080/alipay?orderId=${orderid.value}`;
  window.location.href = url;
}

const init = () => {
  console.log("-----------订单详情---------");
  // console.log("hpId: " + hpId);
  // console.log("smId: " + smId);
  // console.log(selectDay);
  getSetmealById();
  getHospital();
};

onMounted(init);
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
  height: 26.2vw;
}

/*********************** section ***********************/
section {
  width: 86vw;
  margin: 0 auto;
}

section .title {
  width: 100%;
  height: 12vw;
  border-bottom: solid 1px #eee;

  display: flex;
  align-items: center;
}

section .title p {
  height: 3.4vw;
  line-height: 3.4vw;
  font-size: 4.2vw;
  font-weight: 600;
  box-sizing: border-box;
  padding-left: 3vw;
  border-left: solid 2px #127a90;
}

section table {
  font-size: 3.6vw;
  color: #555;
  margin-top: 2vw;
}

section table tr {
  line-height: 8vw;
}

section table tr td:first-child {
  width: 22%;
}

/*********************** bottom-btn ***********************/
.bottom-btn {
  width: 100%;
  height: 12vw;
  background-color: #fff;

  position: fixed;
  left: 0;
  bottom: 14.2vw;

  display: flex;
}

.bottom-btn .first {
  flex: 2;
  line-height: 12vw;
  font-size: 4.6vw;
  box-sizing: border-box;
  padding-left: 6vw;
}

.bottom-btn .first span {
  color: #f77b2d;
}

.bottom-btn .last {
  flex: 1;
  background-color: #117c94;
  line-height: 12vw;
  text-align: center;
  font-size: 5vw;
  color: #fff;

  user-select: none;
  cursor: pointer;
}
</style>