<template>
    <!-- 总容器 -->
    <div class="wrapper">
        <header>
            <i class="fa fa-angle-left" onclick="history.go(-1)"></i>
            <p>个人中心</p>
            <div></div>
        </header>
        <div class="top-ban"></div>

        <section>
            <div class="info">
                <div class="content">
                    <img src="../assets/img/user.png">
                    <div>
                        <p>黄药师</p>
                        <p>账号: 156****4589</p>
                    </div>
                </div>
            </div>
            <ul>
                <li>
                    <div class="left">
                        <i class="fa fa-user-plus"></i>
                        <p>我的预约</p>
                    </div>
                    <div class="right" @click="toApplist">
                        <i class="fa fa-angle-right"></i>
                        <svg t="1718694981728" class="icon" viewBox="0 0 1024 1024" version="1.1"
                            xmlns="http://www.w3.org/2000/svg" p-id="1445" width="30" height="30">
                            <path
                                d="M761.055557 532.128047c0.512619-0.992555 1.343475-1.823411 1.792447-2.848649 8.800538-18.304636 5.919204-40.703346-9.664077-55.424808L399.935923 139.743798c-19.264507-18.208305-49.631179-17.344765-67.872168 1.888778-18.208305 19.264507-17.375729 49.631179 1.888778 67.872168l316.960409 299.839269L335.199677 813.631716c-19.071845 18.399247-19.648112 48.767639-1.247144 67.872168 9.407768 9.791372 21.984142 14.688778 34.560516 14.688778 12.000108 0 24.000215-4.479398 33.311652-13.439914l350.048434-337.375729c0.672598-0.672598 0.927187-1.599785 1.599785-2.303346 0.512619-0.479935 1.056202-0.832576 1.567101-1.343475C757.759656 538.879828 759.199462 535.391265 761.055557 532.128047z"
                                fill="#575B66" p-id="1446"></path>
                        </svg>
                    </div>
                </li>
                <li>
                    <div class="left">
                        <i class="fa fa-volume-control-phone"></i>
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
                <li>
                    <div class="left">
                        <i class="fa fa-sign-out"></i>
                        <p>退出登录</p>
                    </div>
                    <div class="right" @click="toLogin">
                        <i class="fa fa-angle-right"></i>
                        <svg t="1718694981728" class="icon" viewBox="0 0 1024 1024" version="1.1"
                            xmlns="http://www.w3.org/2000/svg" p-id="1445" width="30" height="30">
                            <path
                                d="M761.055557 532.128047c0.512619-0.992555 1.343475-1.823411 1.792447-2.848649 8.800538-18.304636 5.919204-40.703346-9.664077-55.424808L399.935923 139.743798c-19.264507-18.208305-49.631179-17.344765-67.872168 1.888778-18.208305 19.264507-17.375729 49.631179 1.888778 67.872168l316.960409 299.839269L335.199677 813.631716c-19.071845 18.399247-19.648112 48.767639-1.247144 67.872168 9.407768 9.791372 21.984142 14.688778 34.560516 14.688778 12.000108 0 24.000215-4.479398 33.311652-13.439914l350.048434-337.375729c0.672598-0.672598 0.927187-1.599785 1.599785-2.303346 0.512619-0.479935 1.056202-0.832576 1.567101-1.343475C757.759656 538.879828 759.199462 535.391265 761.055557 532.128047z"
                                fill="#575B66" p-id="1446"></path>
                        </svg>
                    </div>
                </li>
            </ul>
        </section>

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

function toApplist() {
    router.push("/appointmentlist");
}

function toLogin() {
    router.push("/");
}

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

section .info {
    width: 100%;
    height: 30vw;
    background-image: linear-gradient(135deg, #7DB35D, #02A6C9, #02A6C9);
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
    color: #FFF;
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
    border-bottom: solid 1px #EEE;
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
</style>
