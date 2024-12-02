<template>
  <header class="banner">
    <h2>KA Auth - Let's get auth !!</h2>
    <nav>
      <ul>
        <li><router-link to="/">Home</router-link></li>
        <li><router-link to="/account">My Account</router-link></li>
        <li class="logout"><button @click="logout">Logout</button></li>                
    </ul>
  </nav>
  </header>
</template>

<script setup lang="ts">
import { useAuthStore } from '@/store/authStore'
const authStore = useAuthStore();

const logout = () => {
  authStore.logout()
}
</script>

<style scoped lang="scss">
.banner {
  padding: 1em;
  border-bottom: 1px solid $color-primary;
  display: flex;
  flex-direction: column;
}

h2 {
  flex: 1;
  text-align: center;
}

nav ul {
  list-style: none;
  flex: 1;
  display: flex;
  margin: 0;

  li {
    margin-left: 2rem;
    a {
      text-decoration: none;
    }
  }

  .logout {
    margin-left: auto;
  }
}

button {
  font-size: 1em;
  color: $color-white;
  background-color: $color-primary;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

</style>