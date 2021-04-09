<template>
  <div class="home">
    <h2>Lista Produtos</h2>
    <div>
      <table class="styled-table">
        <thead>
          <tr>
            <th>id</th>
            <th>codigo</th>
            <th>descriçao</th>
            <th>preço fornecedor</th>
            <th>stock</th>
            <th>tipo</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item of productList" :key="item.id">
            <td>{{ item.id }}</td>
            <td>{{ item.code }}</td>
            <td>{{ item.description }}</td>
            <td>{{ item.providerPrice }}</td>
            <td>{{ item.stock }}</td>
            <td>{{ item.typeProduct.description }}</td>
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
  name: "Produto",
  data: function() {
    return {
      productList: {},
    };
  },
  created() {
    HTTP.get(`/api/product/`).then((response) => {
      this.productList = response.data;
    });
  },
};
</script>
