<template>
	<section>
		<h3>Welcome to the home page!</h3>
		<p>{{ apiResult || "waiting" }}</p>
	</section>
</template>

<script setup lang="ts">
import { ref } from "vue";
import { useAuthStore } from "../store/authStore";

const authStore = useAuthStore();

const apiResult = ref("");

fetch("http://localhost:5027/me", {
	method: "GET",
	headers: {
		Authorization: `Bearer ${authStore.token}`,
		"Content-Type": "application/json",
	},
})
	.then((response) => {
		if (response.ok) {
			response
				.json()
				.then((data) => {
					apiResult.value = data;
				})
				.catch((error) => {
					console.error("Error parsing JSON:", error);
				});
		} else {
			console.error("Response is not ok");
		}
	})
	.catch((error) => {
		console.error("Error fetching data:", error);
	});
</script>
