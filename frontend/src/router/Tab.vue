 <template> 
    <div>
        <div id="app" class="tabmenu">
        <ul>
            <li id="tab1" class="btnCon"> <input type="radio" checked name="tabmenu" id="tabmenu1">
            <label for="tabmenu1">유석환</label>
            <div class="tabCon" style="margin-bottom: 150px;"><sh></sh></div>
            
            </li>
            <li id="tab2" class="btnCon"><input type="radio" name="tabmenu" id="tabmenu2">
            <label for="tabmenu2">신윤재</label>
            <div class="tabCon" style="margin-bottom: 150px;"><yj></yj></div>
            
            </li>    
            <li id="tab3" class="btnCon"><input type="radio" name="tabmenu" id="tabmenu3">
            <label for="tabmenu3">최장훈</label>
            <div class="tabCon" style="margin-bottom: 150px;"><jh></jh></div>
            
            </li>
        </ul>
        </div>
    </div>
</template>
<script>
    import YJ from './YJ.vue'
    import SH from './SH.vue'
    import JH from './JH.vue'
    import Vue from 'vue'

    export default {
        components: {
            'yj': YJ,
            'sh': SH,
            'jh' : JH
            }
    }
</script>
<style scoped>
    *{
    margin:0; padding:0;
    font-size:15px; 
    line-height:1.3;
    background-color: white;
    }
    ul{list-style:none;}

    .tabmenu{ 
    max-width:600px; 
    margin: 0 auto; 
    position:relative; 
    }
    .tabmenu ul li{
    display:  inline-block;
    width:33.33%; 
    float:left;  
    text-align:center; 
    background :#f9f9f9;
    line-height:40px;
    }
    .tabmenu label{
    display:block;
    width:100%; 
    height:40px;
    line-height:40px;
    }
    .tabmenu input{display:none;}
    .tabCon{
    width: 600px;
    display:none; 
    text-align:left; 
    padding: 20px;
    position:absolute; 
    left:0; top:40px; 
    box-sizing: border-box; 
    border : 5px solid #f9f9f9;
    }
    .tabmenu input:checked ~ label{
    background:#ccc;
    }
    .tabmenu input:checked ~ .tabCon{
    display:block;
    }
</style>