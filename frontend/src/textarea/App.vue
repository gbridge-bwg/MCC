<template>
  <div id="app">
    <gb-textarea v-bind:cols="cols" v-bind:rows="rows" v-bind:textlabel="label"></gb-textarea>
  </div>
</template>

<script>

import TextArea from './components/gb-textarea.vue'

export default {
  // 컴포넌트 등록
  components:{
    'gb-textarea': TextArea
  },
  
  data(){
    return{
    cols: 50,
    rows: 5,
    label: "주소입력"    
    }
  }
}
</script>
