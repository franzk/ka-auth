<template>
    <Banner />
    <router-view />
    <!-- Footer here -->
</template>

<script setup lang="ts">
import Banner from '@/components/Banner.vue'
</script>

<style lang="scss">

body {
  font-family: Roboto;
  color: $color-text;
  background-color: $color-secondary;
}

</style>
