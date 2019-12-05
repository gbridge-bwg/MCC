<template>
    <div>
        {{vas}}
        <strong th:text="${vas}"></strong>
        <strong th:text="${list}"></strong>
    </div>
    
</template>

<script>
// import Modal from './common/Modal.vue'
import axios from 'axios'

export default{
    mounted: function(){
        axios.get('/benefit/data') .then(res => { // 불러온 값을 Console에 뿌려줍니다. 
        console.log(res.data) })
    }
//     data(){
//         return {
//             newTodoItem: '',
//             showModal: false
//         }
//     },
//     methods:{
//         addTodo(){
//             if(this.newTodoItem !== ""){
//                 var value = this.newTodoItem && this.newTodoItem.trim();
//                 this.$emit("addTodo",value);
//                 this.clearInput();
//             }else{
//                 this.showModal = !this.showModal;
//             }
//         },
//         clearInput(){
//             this.newTodoItem = '';
//         }
//     },
    // components:{
    //     Modal: Modal
    // }
}
</script>

<style scoped>
    body, html{
        height: 100%;
    }
    .loginform{
        position: relative;
        display: flex;
        justify-content: center;
        vertical-align: middle;
        margin-top: auto;
        margin-bottom: auto;
    }
    .loginset{
        height:auto;
        width: fit-content;
        margin-top: auto;
        margin-bottom: auto;
        background: rgb(228, 145, 228);
        position: relative;
        display: flex;
        justify-content: center;
        flex-direction: column;
        padding: 10px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        -webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        -moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        border-radius: 5px;

    }
</style>