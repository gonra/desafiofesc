<template>
  <popup-modal ref="popup">
    <h2 style="margin-top: 0">{{ title }}</h2>
    <p>{{ message }}</p>
    <div class="btns">
      <button class="cancel-btn" @click="_cancel">Cancelar</button>
      <button class="ok-btn" @click="_confirm">Ok</button>
    </div>
  </popup-modal>
</template>

<script>
import PopupModal from "./PopupModal.vue";

export default {
  name: "ConfirmModal",

  components: { PopupModal },

  data: () => ({
    title: undefined,
    message: undefined,

    // Private variables
    resolvePromise: undefined,
    rejectPromise: undefined,
  }),

  methods: {
    show(opts = {}) {
      this.title = opts.title;
      this.message = opts.message;

      // Once we set our config, we tell the popup modal to open
      this.$refs.popup.open();
      // Return promise so the caller can get results
      return new Promise((resolve, reject) => {
        this.resolvePromise = resolve;
        this.rejectPromise = reject;
      });
    },

    _confirm() {
      this.$refs.popup.close();
      this.resolvePromise(true);
    },

    _cancel() {
      this.$refs.popup.close();
      this.resolvePromise(false);
    },
  },
};
</script>

<style scoped>
.btns {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.ok-btn {
  padding: 0.5em 1em;
  background-color: #1ea01e;
  color: #16261f;
  border: 1px solid #0ec5a4;
  border-radius: 5px;
  font-weight: bold;
  font-size: 16px;
  cursor: pointer;
}

.cancel-btn {
  padding: 0.5em 1em;
  background-color: #8a887a;
  color: #16261f;
  border: 1px solid #0ec5a4;
  border-radius: 5px;
  font-weight: bold;
  font-size: 16px;
  cursor: pointer;
}
</style>
