<template>
  <div class="home">
    <h2>Detalhes do producto : {{ product.description }}</h2>
    <div v-if="!newOperation">
      <table class="styled-table">
        <thead>
          <tr>
            <th>codigo</th>
            <th>descriçao</th>
            <th>preço fornecedor</th>
            <th>stock</th>
            <th>tipo</th>
            <th>ultima atualizaçao</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{{ product.code }}</td>
            <td>{{ product.description }}</td>
            <td>{{ product.providerPrice }}</td>
            <td>{{ product.stock }}</td>
            <td>{{ product.typeProduct.description }}</td>
            <td>{{ product.lastUpdate }}</td>
            <td></td>
          </tr>
          <tr v-if="edit">
            <td>{{ product.code }}</td>
            <td>{{ product.description }}</td>
            <td>{{ product.providerPrice }}</td>
            <td>{{ product.stock }}</td>
            <td>{{ product.typeProduct.description }}</td>
            <td>{{ product.lastUpdate }}</td>
            <td></td>
          </tr>
        </tbody>
      </table>
      <button @click="addOperation">
        Nova operaçao
      </button>
    </div>
    <div v-if="newOperation">
      <form @submit="createOperation">
        <table class="styled-table">
          <thead>
            <tr>
              <th colspan="2">Nova operaçao</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td width="240">
                <label for="quantity">Quantidade</label>
                <p>
                  <small>
                    (use valor positivo para adicionar e negativo para retirar)
                  </small>
                </p>
              </td>
              <td>
                <input
                  id="quantity"
                  v-model="quantity"
                  type="number"
                  name="quantity"
                  required
                  alt=""
                />
              </td>
            </tr>
            <tr>
              <td>
                <label for="salePrice">Preço venda</label>
              </td>
              <td>
                <input
                  id="salePrice"
                  v-model="salePrice"
                  type="text"
                  name="cosalePricede"
                  required
                />
              </td>
            </tr>
            <tr>
              <td>
                <label for="typeProductId">Tipo de operaçao</label>
              </td>
              <td>
                <select v-model="typeOperationId">
                  <option disabled value="">Selecione un elemento</option>
                  <option
                    v-for="item of typeOperationList"
                    v-bind:key="item.id"
                    v-bind:value="item.id"
                  >
                    {{ item.description }}
                  </option>
                </select>
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <input type="submit" value="Enviar" />
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  </div>
</template>
<script>
import { HTTP } from "../http-common";

export default {
  data: function() {
    return {
      edit: false,
      newOperation: false,
      productId: this.$route.params.id,
      product: {},
      typeOperationList: {},

      salePrice: undefined,
      quantity: undefined,
      typeOperationId: undefined,
    };
  },
  created() {
    HTTP.get(`/api/product/` + this.productId).then((response) => {
      this.product = response.data;
    });
    HTTP.get(`/api/operation/types`).then((response) => {
      this.typeOperationList = response.data;
    });
  },
  methods: {
    addOperation() {
      this.newOperation = true;
    },
    createOperation(e) {
      let pars = {
        productId: this.productId,
        salePrice: this.salePrice,
        quantity: this.quantity,
        typeOperationId: this.typeOperationId,
      };
      let fluxo = 1 * this.product.stock + 1 * this.quantity;
      if (fluxo > -1) {
        HTTP.post(`/api/operation/`, pars).then((response) => {
          this.product = response.data;
          this.newOperation = false;
          return true;
        });
      } else {
        alert("Quantidade a retirar excede o disponivel");
      }
      e.preventDefault();
    },
  },
};
</script>
