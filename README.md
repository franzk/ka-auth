# KA Auth : Complete Authentication Service Project (auth + register) WIP

![VueJS 3](https://img.shields.io/badge/Vue.js%203-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D&style=flat-square)
![Keycloak 25.0.2](https://img.shields.io/badge/keycloak%2025.0.2-4169e1?style=for-the-badge&logo=keycloak&logoColor=white&style=flat-square)
![PostgreSQL](https://img.shields.io/badge/postgresql-4169e1?style=for-the-badge&logo=postgresql&logoColor=white&style=flat-square)
![Docker](https://img.shields.io/badge/-DOCKER-2496ed?style=for-the-badge&logo=docker&logoColor=white&style=flat-square)

## Installation

### 1. clone this repository

```console
git clone https://github.com/franzk/kauth.git
```

### 2. Rename the .env.dist File

Rename the `.env.dist` file to `.env` and fill in the environment variables with values.  
You can use default or random values for the environment variables as their specific values are not crucial for the setup.

### 3. Set up Keycloak

Navigate to the docker directory and start Keycloak using Docker Compose:

```console
cd docker
docker compose up
```

### 4. Set up VueJS

Navigate to the front-end directory, install dependencies, and run the development server:

```console
cd ../front-end
pnpm install
pnpm run dev
```

### 5. Test the Application

Open your browser and go to http://localhost:8080.

- user : vueuser
- password : vuepass
