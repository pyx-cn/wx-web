<template>
    <!-- 总容器 -->
    <div class="wrapper">
        <header>
            <el-icon style="font-size: 24px;" @click="goBack()"><ArrowLeft /></el-icon>
            <!-- <i class="fa fa-angle-left" onclick="history.go(-1)"></i> -->
            <!-- <svg @click="history.go(-1)" t="1718607359236" class="icon" viewBox="0 0 1024 1024" version="1.1"
                    xmlns="http://www.w3.org/2000/svg" p-id="4232" width="20" height="20">
                    <path
                        d="M401.066667 512l302.933333 302.933333-59.733333 59.733334L341.333333 571.733333 281.6 512 341.333333 452.266667l302.933334-302.933334 59.733333 59.733334L401.066667 512z"
                        fill="#444444" p-id="4233"></path>
                </svg> -->
            <p>选择体检日期</p>
            <div></div>
        </header>
        <div class="top-ban"></div>

        <section>
            <!-- xx年 xx月 -->
            <div class="date-box">
                <!-- <i class="fa fa-caret-left"></i> -->
                <svg @click="subtractMonth" t="1718607359236" class="icon" viewBox="0 0 1024 1024" version="1.1"
                    xmlns="http://www.w3.org/2000/svg" p-id="4232" width="20" height="20">
                    <path
                        d="M401.066667 512l302.933333 302.933333-59.733333 59.733334L341.333333 571.733333 281.6 512 341.333333 452.266667l302.933334-302.933334 59.733333 59.733334L401.066667 512z"
                        fill="#444444" p-id="4233"></path>
                </svg>

                <p>{{ year + "年" + month + "月" }}</p>

                <!-- <i class="fa fa-caret-right"></i> -->
                <svg @click="addMonth" t="1718607430723" class="icon" viewBox="0 0 1024 1024" version="1.1"
                    xmlns="http://www.w3.org/2000/svg" p-id="5321" width="20" height="20">
                    <path
                        d="M761.055557 532.128047c0.512619-0.992555 1.343475-1.823411 1.792447-2.848649 8.800538-18.304636 5.919204-40.703346-9.664077-55.424808L399.935923 139.743798c-19.264507-18.208305-49.631179-17.344765-67.872168 1.888778-18.208305 19.264507-17.375729 49.631179 1.888778 67.872168l316.960409 299.839269L335.199677 813.631716c-19.071845 18.399247-19.648112 48.767639-1.247144 67.872168 9.407768 9.791372 21.984142 14.688778 34.560516 14.688778 12.000108 0 24.000215-4.479398 33.311652-13.439914l350.048434-337.375729c0.672598-0.672598 0.927187-1.599785 1.599785-2.303346 0.512619-0.479935 1.056202-0.832576 1.567101-1.343475C757.759656 538.879828 759.199462 535.391265 761.055557 532.128047z"
                        fill="#575B66" p-id="5322"></path>
                </svg>

            </div>

            <table>
                <!-- 日历表头 -->
                <tr>
                    <th>日</th>
                    <th>一</th>
                    <th>二</th>
                    <th>三</th>
                    <th>四</th>
                    <th>五</th>
                    <th>六</th>
                </tr>
            </table>
            <ul>
                <li v-for="(calendar, index) in calendarArr" :key="calendar.ymd">
                    <p :class="{
                        fontcolor: calendar.remainder != null && calendar.remainder != 0,
                        pselect: calendar.selectDay == 1,
                    }" @click="selectDay(index)">
                        {{ calendar.day }}
                    </p>
                    <p>
                        {{ calendar.remainder != null && calendar.remainder != 0 ? "余" + calendar.remainder : "" }}
                    </p>
                </li>
            </ul>
        </section>

        <div class="bottom-btn">
            <div></div>
            <div @click="toConfirmOrder">下一步</div>
        </div>

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

const curDate = new Date();
const hpId = route.query.hpId;
const smId = route.query.smId;
const year = ref(curDate.getFullYear());
const month = ref(curDate.getMonth() + 1);
const calendarArr = ref([]);
// 对于不需要响应式的情况，想要跟踪其变化，直接使用 let
let selectedDay = ""; //用户选择的预约日期

function goBack() {
    router.go(-1); 
}

function getCalendar() {
    console.log("-----------日历展示---------")
    const token = getSessionStorage("token");
    // console.log(hpId);
    // console.log(smId);
    // console.log(month);
    // console.log(year.value);
    // console.log(month.value);
    axios
        // .get("http://10.25.161.174:8080/getCalendar", {
        .get("http://localhost:8080/getCalendar", {
            params: {
                hpId: hpId,
                year: year.value,
                month: month.value,
            },
            headers: {
                'Authorization': `${token}`
            }
        })
        .then((response) => {
            // console.log(response.data);
            calendarArr.value = response.data.result;
            console.log(calendarArr);
            //需要对返回数组进行再加工
            for (let i = 0; i < calendarArr.value.length; i++) {
                // console.log(calendarArr.value[i]);
                //返回数组的前几个元素可能为空
                if (calendarArr.value[i].ymd != null) {
                    //1、需要将日期day单独提取出来显示
                    calendarArr.value[i].day = parseInt(
                        calendarArr.value[i].ymd.substring(8) // ymd: '2024-07-28' 提取索引8及往后的字符串
                    );
                    //2、给每一个日期添加一个是否选中的标识（0：未选中；1：选中）
                    if (calendarArr.value[i].ymd == selectDay) {
                        calendarArr.value[i].selectDay = 1;
                    } else {
                        calendarArr.value[i].selectDay = 0;
                    }
                }
            }
        })
        .catch((error) => {
            console.error(error);
        });
}

//上一个月
function subtractMonth() {

    if (month.value > 1) {
        month.value--;
    } else {
        year.value--;
        month.value = 12;
    }
    getCalendar();
}
//下一个月
function addMonth() {
    if (month.value < 12) {
        month.value++;
    } else {
        year.value++;
        month.value = 1;
    }
    getCalendar();
}

function selectDay(index) {
    //验证当前选中日期是否为可预约日期
    if (calendarArr.value[index].remainder == null || calendarArr.value[index].remainder == 0) {
        return;
    }
    //将所有日期的选中状态清空
    for (let i = 0; i < calendarArr.value.length; i++) {
        calendarArr.value[i].selectDay = 0;
    }
    calendarArr.value[index].selectDay = 1;
    selectedDay = calendarArr.value[index].ymd;
}

function toConfirmOrder() {
    if (selectedDay == '') {
        alert('请选择体检预约日期！');
        return;
    }
    // console.log(hpId);
    // console.log(smId);
    // console.log(selectDay);
    router.push({ path: '/confirmOrder', query: { hpId: hpId, smId: smId, selectDay: selectedDay } });
}

onMounted(getCalendar);

</script>

<style scoped>
@import url('https://unpkg.com/tailwindcss@^2.0/dist/tailwind.min.css');

/*********************** 总容器 ***********************/
.wrapper {
    width: 100%;
    height: 100%;
    background-color: #F9F9F9;
}

/*********************** header ***********************/
header {
    width: 100%;
    height: 15.7vw;
    background-color: #FFF;

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
    border-top: solid 1px #E9E9E9;
    background-color: #FFF;

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
    width: 82vw;
    margin: 0 auto;
    margin-top: 12vw;
}

section .date-box {
    width: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    font-size: 4.5vw;
    font-weight: 600;
}

section .date-box p {
    color: #000;
}

section .date-box i {
    color: #999;
    user-select: none;
    cursor: pointer;
}

section table {
    width: 100%;
    font-size: 3.8vw;
}

section table tr th {
    text-align: center;
    font-weight: 600;
    line-height: 12vw;
}

section ul {
    width: 100%;
    display: flex;
    flex-wrap: wrap;
}

section ul li {
    width: 14.28%;
    height: 12vw;
    font-weight: 600;
    color: #999;
}

section ul li p:first-child {
    width: 6vw;
    height: 6vw;
    margin: 0 auto;
    border-radius: 3vw;

    display: flex;
    justify-content: center;
    align-items: center;

    font-size: 4.2vw;

    user-select: none;
    cursor: pointer;
}

section ul li p:last-child {
    font-size: 3vw;
    font-weight: 300;
    text-align: center;
    user-select: none;
}

.fontcolor {
    color: #333;
}

.pselect {
    background-color: #FB902B;
    color: #FFF;
}

/*********************** bottom-btn ***********************/
.bottom-btn {
    width: 100%;
    height: 12vw;
    background-color: #FFF;

    position: fixed;
    left: 0;
    bottom: 14.2vw;

    display: flex;
}

.bottom-btn div:first-child {
    flex: 2;
}

.bottom-btn div:last-child {
    flex: 1;
    background-color: #117C94;
    text-align: center;
    line-height: 12vw;
    font-size: 5vw;
    color: #FFF;

    user-select: none;
    cursor: pointer;
}
</style>