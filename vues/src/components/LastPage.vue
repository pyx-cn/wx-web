<template>
  <el-icon style="font-size: 24px;" @click="goBack()"><ArrowLeft /></el-icon>
</template>

<script setup>
import { useRoute, useRouter } from "vue-router";

const router = useRouter()

function goBack() {
    router.go(-1); 
}
</script>