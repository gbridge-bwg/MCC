<template>
    <div class="card">
        <table style="text-align:center; width:703px;">
            <tr>
                <td style="width:300px">
                    <img v-bind:src=src style="width:300px; height:auto; margin-left: 10px">
                </td>
                <td>
                    <h2>{{cardName}}</h2>
                    <h4>{{bankName}}</h4>
                    <input v-for="(cards,index) in catergoryArr" :key="index"  type="button" :value=cards.category class="categoryButton" v-on:click="setCategory($event.target.value)">
                    <h6>{{cardDetail}}</h6>
                    <input type="button" v-on:click="openRegister(registerSrc)" value="가입 신청" class="toRegister">
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
    export default{
        props: ['src', 'cardName', 'bankName', 'cardCategory', 'cardDetail', 'registerSrc'],
        data: function(){
            return{
                catergoryArr: []
            }
        },
        methods: {
                openRegister : function(registerSrc){
                    window.open(registerSrc);
                },
                setCategory: function(value){
                    for(var i=1; i<10; i++){
                        if(value == document.getElementById(''+i).value)
                            document.getElementById(''+i).checked = true;
                        else
                            document.getElementById(''+i).checked = false;
                    }
                    this.$emit('getData');
                }
        },
        beforeMount: function(){
            var arr = this.cardCategory.split(',');
            if(arr.length > 0){
                arr.forEach((data, index)=>{
                    console.log(data);
                    this.catergoryArr.push({'category': data});
                });   
            }
        }
    }
</script>

<style scoped>
    .toRegister {
    background:midnightblue;
    border: 3px solid #fff;
    border-radius: 5px;
    color:#fff;
    display: block;
    font-size: 1em;
    font-weight: bold;
    margin: 1em auto;
    padding: .5em 1.5em;
    position: relative;
    text-transform: uppercase;
    }
    .card{
        margin: 1em;
    }
    .categoryButton{
    background:gold;
    border: 3px solid #fff;
    border-radius: 5px;
    color:black;
    font-size: xx-small;
    font-weight: bold;
    margin: 1em auto;
    padding: .5em 1.5em;
    text-transform: uppercase; 
    }
</style>