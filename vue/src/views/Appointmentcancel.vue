<template>
    <!-- 总容器 -->
    <div class="wrapper">
        <header>
            <i class="fa fa-angle-left" onclick="history.go(-1)"></i>
            <p>取消预约</p>
            <div></div>
        </header>
        <div class="top-ban"></div>

        <section>
            <div class="success">
                <div class="icon-box">
                    <div class="icon">
                        <i class="fa fa-check"></i>
                    </div>
                </div>
                <h1>取消预约成功！</h1>
                <p>退款将在24小时之内到账</p>
            </div>
            <div class="order-btn" onclick="location.href='appointmentlist.html'">查看订单</div>
            <div class="continue" @click="toAppointment">继续为家人预约</div>
            <div class="info">
                <p>您的信息已经发送至体检机构</p>
                <p>取消预约后会发送短信至您的手机</p>
                <p>客服电话<span>4008-XXX-XXX</span></p>
            </div>
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

const toAppointment = () => {
    router.push("/appointment")
}
</script>

<style scoped></style>
