<template>
    <!-- 总容器 -->
    <div class="wrapper">
        <header>
            <LastPage></LastPage>
            <p>注册</p>
            <div></div>
        </header>
        <div class="top-ban"></div>
        <h1>欢迎注册</h1>
        <table>
            <tr>
                <td>手机号码</td>
                <td><input type="text" v-model="user.userid" placeholder="请输入手机号码"></td>
            </tr>
            <tr>
                <td>真实姓名</td>
                <td><input type="text" v-model="user.realname" placeholder="真实姓名便于查看体检报告"></td>
            </tr>
            <tr>
                <td>生日</td>
                <td><input type="date" v-model="user.birthday"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <input type="radio" id="male" value="男" v-model="user.sex" checked>
                    <label for="male">男</label>
                    <input type="radio" id="female" value="女" v-model="user.sex">
                    <label for="female">女</label>
                </td>
            </tr>
            <tr>
                <td>身份证号</td>
                <td><input type="text" v-model="user.identitycard" placeholder="请输入身份证号"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" v-model="user.password" placeholder="请输入密码"></td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input type="password" v-model="user.password" placeholder="请再次输入密码"></td>
            </tr>
        </table>
        <!-- <div class="btn" onclick="location.href='login.html'">完成</div> -->
        <p class="btn" @click="register">完成</p>
    </div>
</template>

<script setup>
import LastPage from "@/components/LastPage.vue";
import { ref, reactive, toRefs } from "vue";
import { useRoute, useRouter } from "vue-router";
import axios from "axios";
import { md5 } from 'js-md5'

const router = useRouter()

const user = reactive({
    "userid": 123,
    "password": "123",
    "realname": "叶文洁",
    "sex": 0,
    "identitycard": "254852364142366454",
    "birthday": "1990-06-22"
});

const register = () => {
    const salt = md5(user.password);
    console.log('插件加密后', salt);
    user.password = salt;

    // axios.post('http://10.25.161.174:8080/register', user).then(res => {
    axios.post('http://localhost:8080/register', user).then(res => {
        console.log(res.data);
        if (res.data.code == 200) {
            alert("注册成功");
            router.push({ path: "/" });
        }
        else if (res.data.code == 103) {
            alert("该用户已存在");
            router.push({ path: "/register" });
        }
    })

    router.push('/login');

}



</script>


<style scoped>
/*********************** 总容器 ***********************/
.wrapper {
    width: 100%;
    height: 100%;
    padding: 0 20px;
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

/*********************** 标题部分 ***********************/
h1 {
    font-size: 7.4vw;
    font-weight: 500;
    box-sizing: border-box;
    padding: 0 3.6vw;
    margin-top: 6vw;
}

/*********************** common样式 ***********************/
.top-ban {
    width: 100%;
    height: 15.7vw;
}

/*********************** table ***********************/
table {
    width: 92.8vw;
    margin: 0 auto;
    margin-top: 5vw;
    border-collapse: collapse;

    font-size: 4.2vw;
}

table tr td {
    height: 12vw;
    border-bottom: solid 1px #DDD;
}

table tr td input {
    border: none;
    outline: none;
}

/*********************** btn ***********************/
.btn {
    width: 92.8vw;
    margin: 0 auto;
    height: 12vw;
    margin-top: 8vw;
    background-color: #137E92;
    border-radius: 2vw;
    color: #FFF;
    font-size: 5vw;
    text-align: center;
    line-height: 12vw;

    user-select: none;
    cursor: pointer;
}
</style>