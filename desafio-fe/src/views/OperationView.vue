<template>
  <div class="home">
    <h2>Lista de Operaçoes</h2>
    <div>
      <table class="styled-table">
        <thead>
          <tr>
            <th>Filtro por Produto</th>
            <th>Filtro por Tipo de Operaçao</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>
              <select v-model="productId">
                <option value="-1">Selecione um elemento</option>
                <option
                  v-for="item of productList"
                  v-bind:key="item.id"
                  v-bind:value="item.id"
                >
                  {{ item.description }}
                </option>
              </select>
            </td>
            <td>
              <select v-model="typeOperationId">
                <option value="-1">Selecione um elemento</option>
                <option
                  v-for="item of typeOperationList"
                  v-bind:key="item.id"
                  v-bind:value="item.id"
                >
                  {{ item.description }}
                </option>
              </select>
            </td>
            <td>
              <button @click="doFilter">Filtrar</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <div>
      <table class="styled-table">
        <thead>
          <tr>
            <th></th>
            <th>data</th>
            <th>produto</th>
            <th>quantidade</th>
            <th>preço venda</th>
            <th>tipo de operaçao</th>
            <th>lucro</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item of operationList" :key="item.id">
            <td></td>
            <td>{{ item.datetime }}</td>
            <td>{{ item.product.description }}</td>
            <td>{{ item.quantity }}</td>
            <td>{{ item.salePrice }}</td>
            <td>{{ item.typeOperation.description }}</td>
            <td>{{ item.profit }}</td>
          </tr>
          <tr>
            <td colspan="7">Total lucro : {{ totalProfit }}</td>
          </tr>
        </tbody>
      </table>
    </div>
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

      productId: -1,
      typeOperationId: -1,
      totalProfit: 0,
    };
  },
  created() {
    HTTP.get(`/api/operation/`).then((response) => {
      this.operationList = response.data;
      this.operationList.forEach((element) => {
        this.totalProfit = this.totalProfit + Number(element.profit);
      });
    });
    HTTP.get(`/api/operation/types`).then((response) => {
      this.typeOperationList = response.data;
    });
    HTTP.get(`/api/product/`).then((response) => {
      this.productList = response.data;
    });
  },
  methods: {
    doFilter() {
      let filter =
        "productId=" +
        this.productId +
        "&typeOperationId" +
        this.typeOperationId;
      HTTP.get(`/api/operation/?` + filter).then((response) => {
        this.operationList = response.data;
        this.totalProfit = 0;
        this.operationList.forEach((element) => {
          this.totalProfit = this.totalProfit + Number(element.profit);
        });
      });
    },
  },
};
</script>
