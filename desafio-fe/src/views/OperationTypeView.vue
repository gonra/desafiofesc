<template>
  <div class="home">
    <h2>Lista Tipos de Operaçoes</h2>
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
          <tr v-for="item of typeOperationList" :key="item.id">
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
  name: "Tipo de Operacoes",
  data: function() {
    return {
      typeOperationList: {},
    };
  },
  created() {
    HTTP.get(`/api/operation/types`).then((response) => {
      this.typeOperationList = response.data;
    });
  },
};
</script>
