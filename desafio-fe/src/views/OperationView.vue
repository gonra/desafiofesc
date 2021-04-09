<template>
  <div class="home">
    <h2>Lista de Operaçoes</h2>
    <div>
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
  </div>
</template>
<script>
import { HTTP } from "../http-common";

export default {
  name: "Operacoes",
  data: function() {
    return {
      operationList: {},
    };
  },
  created() {
    HTTP.get(`/api/operation/`).then((response) => {
      this.operationList = response.data;
    });
  },
};
</script>
