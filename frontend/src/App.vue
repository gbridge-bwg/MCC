<template>
  <div id="app">
    <h2>Text Area</h2>
    <br>
    <gb-textarea v-bind:cols="cols" v-bind:rows="rows" v-bind:textlabel="label"></gb-textarea>
    <br>
    <h2>ToolTip</h2>
    <br>
    <gb-tooltip v-bind:tooltiptext="tooltipmessage" v-bind:origintext="message" v-bind:tooltipstyle="tooltipstyle"></gb-tooltip>
    <br>
    <br>
    <br>
    <br>
    <h2>File Upload</h2>
    <gb-inputfile v-bind:prolabel="labelf" v-bind:proaccept="accept" v-bind:prohint="hint" v-bind:prowidth="width"></gb-inputfile>
  </div>
</template>

<script>
import TextArea from './components/gb-textarea.vue'
import ToolTip from './components/gb-tooltip.vue'
import InputFile from './components/gb-fileupload.vue'

export default {
  // 컴포넌트 등록
  components:{
    'gb-textarea': TextArea,
    'gb-tooltip': ToolTip,
    'gb-inputfile': InputFile
  },
  
  data(){
    return{
    cols: 50,
    rows: 5,
    label: "주소입력",
    hint: '이미지 파일만 가능합니다',
    labelf: 'file1',
    accept: '.gif, .jpg, .png',
    width: 'width: 100px',
    message: "뷰를 이용한 메세지 입니다.",
    tooltipmessage: "뷰를 이용한 툴팁 메시지 입니다.", 
    tooltipstyle:"width: 130px; height: 35px; line-height: 35px; background: #030709; color: #fff; border: 1px solid #190508;"   
    }
  }

}
</script>

<style scoped>
  gb-tooltip{
    width: 130px;
    height: 35px;
    line-height: 35px;
    background: #030709;
    color: #fff;
    border: 1px solid #190508;
  }
</style>