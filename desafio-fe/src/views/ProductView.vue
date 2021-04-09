<template>
  <div class="home">
    <h2>Lista Produtos</h2>
    <div v-if="!newProduct">
      <table class="styled-table">
        <thead>
          <tr>
            <th>id</th>
            <th>codigo</th>
            <th>descriçao</th>
            <th>preço fornecedor</th>
            <th>stock</th>
            <th>tipo de produto</th>
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
            <td>
              <button @click="goToDetail(item.id)">Ver detalhe</button>
              <button @click="showConfirm(item.id)">Eliminar</button>
            </td>
          </tr>
        </tbody>
      </table>
      <button @click="addProduct">
        Novo produto
      </button>
    </div>
    <div v-if="newProduct">
      <form @submit="createProduct">
        <table class="styled-table">
          <thead>
            <tr>
              <th colspan="2">Novo produto</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                <label for="name">Descriçao</label>
              </td>
              <td>
                <input
                  id="description"
                  v-model="description"
                  type="text"
                  name="description"
                  required
                  autofocus
                />
              </td>
            </tr>
            <tr>
              <td>
                <label for="code">Codigo</label>
              </td>
              <td>
                <input
                  id="code"
                  v-model="code"
                  type="text"
                  name="code"
                  required
                />
              </td>
            </tr>
            <tr>
              <td>
                <label for="providerPrice">Preço fornecedor</label>
              </td>
              <td>
                <input
                  id="providerPrice"
                  v-model="providerPrice"
                  type="text"
                  name="providerPrice"
                  required
                />
              </td>
            </tr>
            <tr>
              <td>
                <label for="typeProductId">Tipo de produto</label>
              </td>
              <td>
                <select v-model="typeProductId">
                  <option disabled value="">Seleccione un elemento</option>
                  <option
                    v-for="item of typeProductList"
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
    <confirm-modal ref="confirmModal"></confirm-modal>
  </div>
</template>

<script>
import { HTTP } from "../http-common";
import ConfirmModal from "@/components/ConfirmModal";

export default {
  name: "productlistview",
  components: {
    ConfirmModal,
  },
  data: function() {
    return {
      newProduct: false,
      productList: {},
      typeOperationList: {},

      code: undefined,
      description: undefined,
      providerPrice: undefined,
      typeProductId: undefined,
    };
  },
  created() {
    HTTP.get(`/api/product/`).then((response) => {
      this.productList = response.data;
    });
    HTTP.get(`/api/product/types`).then((response) => {
      this.typeProductList = response.data;
    });
  },
  methods: {
    addProduct() {
      this.newProduct = true;
    },
    goToDetail(parId) {
      this.$router.push({ name: "productDetailView", params: { id: parId } });
    },
    createProduct(e) {
      let pars = {
        code: this.code,
        description: this.description,
        providerPrice: this.providerPrice,
        typeProductId: this.typeProductId,
      };
      let pprice = Number(this.providerPrice);
      if (pprice > 0) {
        HTTP.post(`/api/product/add`, pars).then((response) => {
          this.productList.push(response.data);
          this.newProduct = false;
          return true;
        });
      } else {
        alert("Preço deve ser numerico");
      }
      e.preventDefault();
    },
    async showConfirm(id) {
      const ok = await this.$refs.confirmModal.show({
        title: "Eliminar",
        message: "Esta seguro de eliminar?",
      });
      // If you throw an error, the method will terminate here unless you surround it wil try/catch
      if (ok) {
        HTTP.delete(`/api/product/` + id).then((response) => {
          alert("Registro eliminado");
          console.log(response.data);

          for (var i = 0; i < this.productList.length; i++) {
            if (this.productList[i].id === id) {
              this.productList.splice(i, 1);
              break;
            }
          }
        });
      }
    },
  },
};
</script>
