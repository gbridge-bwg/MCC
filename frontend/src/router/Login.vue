<template>
    <div>
        <img src='../img/card.png' class="photo"/>
        <form class ="loginform" style="width: 100%; height: 100%;" action="/" method="POST">
            <fieldset class="loginset">
                <input type="text" id="name" name="name" placeholder="아이디" style="margin-top:10px;"/>
                <br>
                <input type="password" id="password" name="password" placeholder="비밀번호" style="margin-bottom: 3em;"/>
                <input type="submit" class="btn-1" value="로그인">
                
            </fieldset>
        </form>
    </div>
</template>

<script>
// import Modal from './common/Modal.vue'

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
        background:darkcyan;
        position: relative;
        display: flex;
        justify-content: center;
        flex-direction: column;
        padding: 40px;
        padding-bottom: 10px;
        padding-top: 70px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        -webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        -moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        border-radius: 5px;

    }
    input[type="text"], 
    input[type="password"]{ 
        height: auto; /* 높이 초기화 */ 
        line-height: normal; /* line-height 초기화 */ 
        padding: .8em .5em; /* 여백 설정 */
    }
    
    input[type="submit"],
    input[type="submit"]::after {
    -webkit-transition: all 0.3s;
        -moz-transition: all 0.3s;
    -o-transition: all 0.3s;
        transition: all 0.3s;
    }

    input[type="submit"] {
    background:midnightblue;
    border: 3px solid #fff;
    border-radius: 5px;
    color: #fff;
    display: block;
    font-size: 1em;
    font-weight: bold;
    margin: 1em auto;
    padding: .5em 1.5em;
    position: relative;
    text-transform: uppercase;
    }

    input[type="submit"]::before,
    input[type="submit"]::after {
    background: #fff;
    content: '';
    position: absolute;
    z-index: -1;
    }

    input[type="submit"]:hover {
    color: #2ecc71;
    }

    .btn-1::after {
    height: 0;
    left: 0;
    top: 0;
    width: 100%;
    }

    .btn-1:hover:after {
    height: 100%;
    }

    .photo {
        text-align: center;
        background-color: #fff;
        width: 100px; height: 100px;
        object-fit: cover;
        border-radius: 80%;
        position: relative;
        z-index: 1;
        display: flex;
        justify-content: center;
        vertical-align: middle;
        margin: auto;
        padding: 10px;
        top: 60px;
         box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        -webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        -moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    
    }


</style>