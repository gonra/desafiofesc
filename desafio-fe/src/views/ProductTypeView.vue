<template>
  <div class="home">
    <h2>Tipos de productos</h2>
    <div>
      <table class="styled-table">
        <thead>
          <tr>
            <th>id</th>
            <th>descriçao</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item of typeProductList" :key="item.id">
            <td>{{ item.id }}</td>
            <td>{{ item.description }}</td>
            <td></td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
<script>
import { HTTP } from "../http-common";

export default {
  name: "Tipo de Produtos",
  data: function() {
    return {
      typeProductList: {},
    };
  },
  created() {
    HTTP.get(`/api/product/types`).then((response) => {
      this.typeProductList = response.data;
    });
  },
};
</script>
