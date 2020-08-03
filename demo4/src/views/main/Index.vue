<template>
  <div>
      
  </div>
</template>

<script>
export default {
  name: 'index',
  methods: {
    beforeCreate() {
      console.log("bcreate");
    },
    created() {
      console.log("created");
    },
    beforeRouteEnter(to, form, next) {
      next((vm) => {
        console.log(vm);
        vm.$router.push("/login");
      });
    },
  },
};
</script>

<style>
</style>