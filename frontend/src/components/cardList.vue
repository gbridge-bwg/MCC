<template>
    <div>
        <table>
            <tr>
                <td>
                    <img v-bind:src=src style="width:300px; height:auto;">
                </td>
                <td>
                    <h2>{{cardName}}</h2>
                    <h4>{{bankName}}</h4>
                    <h4>{{cardCategory}}</h4>
                    <h6>{{cardDetail}}</h6>
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
    export default{
        props: ['src', 'cardName', 'bankName', 'cardCategory', 'cardDetail']
            
        
        // props:['prolabel', 'proaccept', 'prohint', 'prowidth'],
        // methods: {
        //         sub : function(){
        //             var obj = document.getElementById("testbox")
        //             var file = obj.value;
        //             var fileName = file.split("\\");
        //             document.getElementById("testurl").value = fileName[fileName.length - 1];
        //             event.preventDefault();
        //         }
        // }
    }
</script>

<style scoped>

</style>