<template>
  <div class="home">
    <h2>Lista Tipos de Operaçoes</h2>
    <div v-if="!newOperationType">
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
            <td><button @click="showConfirm(item.id)">Eliminar</button></td>
          </tr>
        </tbody>
      </table>
      <button @click="addOperationType">
        Novo tipo de operaçao
      </button>
    </div>
    <div v-if="newOperationType">
      <form @submit="createTypeOperation">
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
  name: "operationtypes",
  components: {
    ConfirmModal,
  },
  data: function() {
    return {
      newOperationType: false,
      description: null,
      typeOperationList: {},
    };
  },
  created() {
    HTTP.get(`/api/operation/types`).then((response) => {
      this.typeOperationList = response.data;
    });
  },
  methods: {
    addOperationType() {
      this.newOperationType = true;
    },
    createTypeOperation() {
      HTTP.post(`/api/operation/types`, {
        description: this.description,
      }).then((response) => {
        this.typeOperationList.push(response.data);
      });
      this.newOperationType = false;
      return true;
    },
    async showConfirm(id) {
      const ok = await this.$refs.confirmModal.show({
        title: "Eliminar",
        message: "Esta seguro de eliminar?",
      });
      // If you throw an error, the method will terminate here unless you surround it wil try/catch
      if (ok) {
        HTTP.delete(`/api/operation/types/` + id).then((response) => {
          console.log(response.data);
          alert("Registro eliminado");
          for (var i = 0; i < this.typeOperationList.length; i++) {
            if (this.typeOperationList[i].id === id) {
              this.typeOperationList.splice(i, 1);
              break;
            }
          }
        });
      }
    },
  },
};
</script>
