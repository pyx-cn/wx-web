<template>
    <!-- 总容器 -->
    <div class="wrapper">
        <header>
            <i class="fa fa-angle-left" onclick="history.go(-1)"></i>
            <p>健康档案</p>
            <div></div>
        </header>
        <div class="top-ban"></div>

        <section>
            <img src="../assets/img/report.png">
            <ul>
                <li v-for="(item, index) in reportList.data" :key="index">
                    <div class="left">
                        <div>
                            <p> {{ item.orderdate }} 体检报告</p>
                            <p> {{ item.hospitalName }}</p>
                        </div>
                    </div>
                    <div class="right" @click="toReport(item.orderid)">
                        <i class="fa fa-angle-right"></i>
                        <i class="fa fa-file-text-o"></i>
                        <svg t="1718607430723" class="icon" viewBox="0 0 1024 1024" version="1.1"
                            xmlns="http://www.w3.org/2000/svg" p-id="5321" width="20" height="20">
                            <path
                                d="M761.055557 532.128047c0.512619-0.992555 1.343475-1.823411 1.792447-2.848649 8.800538-18.304636 5.919204-40.703346-9.664077-55.424808L399.935923 139.743798c-19.264507-18.208305-49.631179-17.344765-67.872168 1.888778-18.208305 19.264507-17.375729 49.631179 1.888778 67.872168l316.960409 299.839269L335.199677 813.631716c-19.071845 18.399247-19.648112 48.767639-1.247144 67.872168 9.407768 9.791372 21.984142 14.688778 34.560516 14.688778 12.000108 0 24.000215-4.479398 33.311652-13.439914l350.048434-337.375729c0.672598-0.672598 0.927187-1.599785 1.599785-2.303346 0.512619-0.479935 1.056202-0.832576 1.567101-1.343475C757.759656 538.879828 759.199462 535.391265 761.055557 532.128047z"
                                fill="#575B66" p-id="5322"></path>
                        </svg>
                    </div>
                </li>
            </ul>
        </section>

        <div class="bottom-ban"></div>
        <Footer></Footer>
    </div>
</template>a

<script setup>
import Footer from "@/components/Footer.vue";
import { ref, reactive, toRefs, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { getSessionStorage, setSessionStorage } from "../common.js";
import axios from "axios";
import router from "@/router";

const reportList = reactive({})
const user = ref();

const init = () => {
    user.value = getSessionStorage("user");
    console.log(user.value)
    console.log(user.value.userid)
    const token = getSessionStorage("token");
    console.log(token)
    // axios.get('http://10.25.161.174:8080/getHospitals').then(res => {
    axios.get('http://localhost:8080/getReporterList', {
        params: {
            userId: user.value.userid
        },
        headers: {
            'Authorization': `${token}`
        }
    }).then(res => {
        reportList.data = res.data.result;
        console.log(reportList.data)
    })
}

function toReport(orderid) {
    router.push({ path: '/report', query: { orderid: orderid } });
}

onMounted(init);
</script>

<style scoped>
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
    width: 100%;
}

section img {
    width: 100%;
    display: block;
}

section ul {
    width: 86vw;
    margin: 0 auto;
}

section ul li {
    width: 100%;
    height: 18vw;
    border-bottom: solid 1px #EEE;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

section ul li .left {
    display: flex;
    align-items: center;
}

section ul li .left i {
    font-size: 8vw;
    color: #6BB9B6;
    margin-right: 3vw;
}

section ul li .left p:first-child {
    color: #555;
    font-size: 4.2vw;
    font-weight: 600;
}

section ul li .left p:last-child {
    color: #999;
    font-size: 3.2vw;
    font-weight: 600;
    margin-top: 1vw;
}

section ul li .right {
    user-select: none;
    cursor: pointer;
}

section ul li .right i {
    color: #999;
    font-size: 6vw;
}
</style>
