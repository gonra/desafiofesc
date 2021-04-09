<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Produtos</router-link> |
      <router-link to="/producttype">Tipos de Produtos</router-link> |
      <router-link to="/operation">Operaçoes</router-link> |
      <router-link to="/operationtype">Tipos de Operaçoes</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
.styled-table {
  border-collapse: collapse;
  margin: 25px 0;
  font-size: 0.9em;
  font-family: sans-serif;
  min-width: 400px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
.styled-table thead tr {
  background-color: #009879;
  color: #ffffff;
  text-align: left;
}
.styled-table th,
.styled-table td {
  padding: 12px 15px;
}
.styled-table tbody tr {
  border-bottom: 1px solid #888888;
}
.styled-table tbody tr:hover {
  background-color: #eeeeee;
  color: #00705a;
}
.styled-table tbody tr:last-of-type {
  border-bottom: 2px solid #009879;
}
</style>
