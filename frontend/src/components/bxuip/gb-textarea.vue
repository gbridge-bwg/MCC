<template>
	<div>
		<div style="display:inline-flex;">
			<label for="gbtextarea" class="textarealabel" readonly>{{textlabel}}</label>
			<textarea class="gbtextarea" id="gbtextarea" v-bind:cols=cols v-bind:rows=rows WRAP="VIRTUAL" style="overflow:hidden"></textarea>
		</div>
    </div>
</template>

<script>
    export default{
		props: {
			cols: String, 
			rows: String, 
			textlabel: String
		}
    }
</script>

<style scoped>
    .gbtextarea{
	border: 1px solid #cccccc;
	padding: 5px;
	font-family: Tahoma, sans-serif;
	background-position: bottom right;
	background-repeat: no-repeat;
	}
	.textarealabel{
    font-size: small;
    color: #cccccc;
    position: relative;
    clear: both;
    float: left;
    text-align: center;
	border: 1px solid #cccccc;
	padding: 10px;
	font-family: Tahoma, sans-serif;
	background-position: bottom right;
	background-repeat: no-repeat;
	}	
</style>