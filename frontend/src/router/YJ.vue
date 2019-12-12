<template>
  <div id="app">
    <h2>Text Area</h2>
    <gb-textarea cols="50" rows="5" textlabel="주소입력"></gb-textarea>
    <br>
    <br>
    <br>
    <h2>ToolTip</h2>
    <gb-tooltip tooltiptext="뷰를 이용한 툴팁 메시지 입니다." origintext="뷰를 이용한 메세지 입니다."></gb-tooltip>
    <br>
    <br>
    <br>
    <h2>File Upload</h2>
    <gb-inputfile prolabel="file1" proaccept=".gif, .jpg, .png" prohint="이미지 파일만 가능합니다" prowidth="width: 100px"></gb-inputfile>
  </div>
</template>

<script>
import TextArea from '../components/bxuip/gb-textarea.vue'
import ToolTip from '../components/bxuip/gb-tooltip.vue'
import InputFile from '../components/bxuip/gb-fileupload.vue'

export default {
  // 컴포넌트 등록
  components:{
    'gb-textarea': TextArea,
    'gb-tooltip': ToolTip,
    'gb-inputfile': InputFile,
  },
}
</script>