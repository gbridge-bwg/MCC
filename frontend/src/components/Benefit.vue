<template>
    <div>Benefit</div>
</template>

<script>
import Modal from './common/Modal.vue'

export default{
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
    components:{
        Modal: Modal
    }
}
</script>

<style scoped>

</style>