<template>
  <div id="app">
        <gb-tooltip v-bind:tooltiptext="tooltipmessage" v-bind:origintext="message"></gb-tooltip>
  </div>
</template>

<script>

import ToolTip from './components/gb-tooltip.vue'

export default {
  // 컴포넌트 등록
  components:{
    'gb-tooltip': ToolTip
  },
  
  data(){
    return{
      message: "뷰를 이용한 메세지 입니다.",
      tooltipmessage: "뷰를 이용한 툴팁 메시지 입니다."
    }
  }
}
</script>
