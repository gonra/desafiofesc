<template>
  <div class="home">
    <h2>Tipos de productos</h2>
    <div v-if="!newProductType">
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
            <td>
              <button @click="showConfirm(item.id)">Eliminar</button>
            </td>
          </tr>
        </tbody>
      </table>
      <button @click="addProductType">
        Novo tipo produto
      </button>
    </div>
    <div v-if="newProductType">
      <form @submit="createTypeProduct">
        <p>
          <label for="name">Descriçao</label>
          <input
            id="description"
            v-model="description"
            type="text"
            name="description"
            required
            autofocus
          />
        </p>
        <p>
          <input type="submit" value="Enviar" />
        </p>
      </form>
    </div>
    <confirm-modal ref="confirmModal"></confirm-modal>
  </div>
</template>
<script>
import { HTTP } from "../http-common";
import ConfirmModal from "@/components/ConfirmModal";

export default {
  name: "producttypeview",
  components: {
    ConfirmModal,
  },
  data: function() {
    return {
      newProductType: false,
      description: null,
      typeProductList: {},
    };
  },
  created() {
    HTTP.get(`/api/product/types`).then((response) => {
      this.typeProductList = response.data;
    });
  },
  methods: {
    addProductType() {
      this.newProductType = true;
    },
    createTypeProduct() {
      HTTP.post(`/api/product/addtype`, { description: this.description }).then(
        (response) => {
          this.typeProductList.push(response.data);
        }
      );
      this.newProductType = false;
      return true;
    },
    async showConfirm(id) {
      const ok = await this.$refs.confirmModal.show({
        title: "Eliminar",
        message: "Esta seguro de eliminar?",
      });
      // If you throw an error, the method will terminate here unless you surround it wil try/catch
      if (ok) {
        HTTP.delete(`/api/product/types/` + id).then((response) => {
          console.log(response.data);
        });
        alert("Registro eliminado");
      }
    },
  },
};
</script>
