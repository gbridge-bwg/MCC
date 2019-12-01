<template>
  <div id="app">
    <Login></Login>  
  </div>
</template>

<script>
import Login from './components/Login.vue'

export default {
  // 컴포넌트 등록
  components:{
    'Login': Login
  }
}
</script>

<style>
  body{
      text-align: center;
      background-color: #F6F6F8;
  }
  input{
      border-style: groove;
      widows: 200px;
  }
  button{
      border-style: groove;
  }
  .shadow{
      box-shadow: 5px 10px 10px rgba(0,0,0,0.03);
  }
</style>
