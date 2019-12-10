<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  // 컴포넌트 등록
}

</script>

<style>
  body{
    text-align: center;
    background-color:cadetblue;
    position:absolute;
    top:0; left:0; bottom:0; right:0;
    height:10%; 
    margin:10% auto;

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
