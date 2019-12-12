<template>
  <div id="app">
      <h2>Grid 컴포넌트</h2>
        <gb-grid></gb-grid>
        <br>

        <h2>Input 컴포넌트1</h2>
        <gb-input1></gb-input1>
        <br>

        <h2>Input 컴포넌트2</h2>
        <gb-input2></gb-input2>
        <br>

        <h2>Dialog 컴포넌트</h2>
        <gb-dialog></gb-dialog>
        <br>
  </div>
</template>

<script>
import Grid from '../components/bxuip/gb-grid.vue'
import Input1 from '../components/bxuip/gb-input1.vue'
import Input2 from '../components/bxuip/gb-input2.vue'
import Dialog from '../components/bxuip/gb-dialog.vue'

export default {

    components :{
        'gb-grid' : Grid,
        'gb-input1' : Input1,
        'gb-input2' : Input2,
        'gb-dialog' : Dialog
    }
}
</script>


<style>
#app {
  text-align: center;
  margin-top: 60px;
}
</style>