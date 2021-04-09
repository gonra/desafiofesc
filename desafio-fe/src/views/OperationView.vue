<template>
  <div class="home">
    <h2>Lista de Operaçoes</h2>
    <div v-if="!newOperation">
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
            <td>{{ item.salePrice }}</td>
            <td>{{ item.typeOperation.description }}</td>
            <td></td>
          </tr>
        </tbody>
      </table>
    </div>
    <div v-if="newOperation"></div>
  </div>
</template>
<script>
import { HTTP } from "../http-common";

export default {
  name: "operations",
  data: function() {
    return {
      newOperation: false,
      operationList: {},
      productList: {},
      typeProductList: {},
      typeOperationList: {},
    };
  },
  created() {
    HTTP.get(`/api/operation/`).then((response) => {
      this.operationList = response.data;
    });
    HTTP.get(`/api/operation/types`).then((response) => {
      this.typeOperationList = response.data;
    });
    HTTP.get(`/api/product/`).then((response) => {
      this.productList = response.data;
    });
    HTTP.get(`/api/product/types/`).then((response) => {
      this.typeProductList = response.data;
    });
  },
  methods: {
    checkForm: function(e) {
      if (this.name && this.age) {
        return true;
      }

      this.errors = [];

      if (!this.name) {
        this.errors.push("El nombre es obligatorio.");
      }
      if (!this.age) {
        this.errors.push("La edad es obligatoria.");
      }

      e.preventDefault();
    },
  },
};
</script>
