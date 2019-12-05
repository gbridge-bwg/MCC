<template>
    <div>
        <p style="color:gray; font-size:xx-small">{{prohint}}</p>
        <span class="filelabel" type="testtext">
            <label for="testtext">{{prolabel}}</label>
        </span>
        <span class="filetextarea">
            <input type="text" id="testurl" v-bind:style=prowidth readonly/>
        </span>
        <span class="filebox" type="file">
            <label for="testbox">+</label>
            <input type="file" id="testbox" v-bind:accept=proaccept @change=sub()>
        </span>
    </div>
</template>

<script>
    export default{
        props:['prolabel', 'proaccept', 'prohint', 'prowidth'],
        methods: {
                sub : function(){
                    var obj = document.getElementById("testbox")
                    var file = obj.value;
                    var fileName = file.split("\\");
                    document.getElementById("testurl").value = fileName[fileName.length - 1];
                    event.preventDefault();
                }
        }
    }
</script>

<style scoped>
    .filebox label { 
    display: inline-block; 
    padding: .3em .7em; 
    color: #999; 
    font-size: inherit; 
    line-height: normal; 
    vertical-align: middle; 
    background-color: #fdfdfd; 
    cursor: pointer; 
    border: 1px solid #ebebeb; 
    border-bottom-color: #e2e2e2; 
    border-radius: .25em; 
    } 
    .filebox input[type="file"] {   
    position: absolute; 
    width: 1px; 
    height: 1px; 
    padding: 0; 
    margin: -1px; 
    overflow: hidden; 
    clip:rect(0,0,0,0); 
    border: 0; 
    } 

    .filelabel label
    { 
        display: inline-block; 
        padding: .3em .7em; 
        color: #999; 
        font-size: inherit; 
        line-height: normal; 
        vertical-align: middle; 
        background-color: #fdfdfd; 
        border: 1px solid #ebebeb; 
        border-bottom-color: #e2e2e2; 
        border-radius: .25em;
    }

    .filetextarea input[type="text"]
    { 
        display: inline-block; 
        padding: .4em .7em; 
        color: #999; 
        font-size: inherit; 
        line-height: normal; 
        vertical-align: middle; 
        background-color: #fdfdfd; 
        border: 1px solid #ebebeb; 
        border-bottom-color: #e2e2e2; 
        border-radius: .25em;
    }
</style>