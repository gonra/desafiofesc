<template>
  <div class="home">
    <h2>Detalhes do producto : {{ product.description }}</h2>
    <table class="styled-table">
      <thead>
        <tr>
          <th>id</th>
          <th>data</th>
          <th>produto</th>
          <th>quantidade</th>
          <th>preço</th>
          <th>tipo</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item of operationList" :key="item.id">
          <td>{{ item.id }}</td>
          <td>{{ item.datetime }}</td>
          <td>{{ item.product.description }}</td>
          <td>{{ item.quantity }}</td>
          <td>{{ item.salesPrice }}</td>
          <td>{{ item.typeOperation.description }}</td>
          <td></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
import { HTTP } from "../http-common";

export default {
  data: function() {
    return {
      productId: this.$route.params.id,
      product: {},
      operationList: {},
    };
  },
  created() {
    HTTP.get(`/api/product/` + this.productId).then((response) => {
      this.product = response.data;
    });
    HTTP.get(`/api/operation/?productId=` + this.productId).then((response) => {
      this.operationList = response.data;
    });
  },
};
</script>
