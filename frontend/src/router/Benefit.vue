<template>
    <div>
        <form name = "form1" class ="benefitform" style="width: 100%; height: 100%;" action="/benefit/getImage" method="POST" target="param">
            <fieldset class="benefitset">
                <h1>MCC 카드 검색</h1>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="credit" name="credit" value="신용카드" /><label for="credit" style="color:palevioletred; font-weight: bold;"> <span></span>신용카드</label>
                </span>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="check" name="check" value="체크카드" /><label for="check" style="color:palevioletred; font-weight: bold;"> <span></span>체크카드</label>
                </span>
                <br>
                <br>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="1" name="1" value="카페/디저트" /><label for="1"> <span></span>카페/디저트</label>
                </span>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="2" name="2" value="여행/숙박" /><label for="2"> <span></span>여행/숙박</label>
                </span>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="3" name="3" value="영화/문화" /><label for="3"> <span></span>영화/문화</label>
                </span>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="4" name="4" value="교통" /><label for="4"> <span></span>교통</label>
                </span>
                <br>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="5" name="5" value="통신" /><label for="5"> <span></span>통신</label>
                </span>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="6" name="6" value="항공" /><label for="6"> <span></span>항공</label>
                </span>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="7" name="7" value="음식" /><label for="7"> <span></span>음식</label>
                </span>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="8" name="8" value="쇼핑" /><label for="8"> <span></span>쇼핑</label>
                </span>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="9" name="9" value="병원" /><label for="9"> <span></span>병원</label>
                </span>
                <br>
                    <input type="button" value="조회" v-on:click="getList">
                    <input type="button" value="저장" v-on:click="saveNum">
                    <input type="button" value="로그아웃" v-on:click="logout" style="background: mediumvioletred;">
                    <gb-dialog id="dialog"></gb-dialog>

                <br>
                <div>
                    <cardlist v-for="(cards,index) in shots" :key="index" :src=cards.srcs :bankName=cards.bankName :cardCategory=cards.cardCategory :cardDetail=cards.cardDetail :cardName=cards.cardName :registerSrc=cards.registerLink v-on:getData="getList"></cardlist>
                </div>
            </fieldset>
        </form>
        <iframe id="if" name="param"></iframe>
    </div>
</template>

<script>
import axios from 'axios'
import cardList from '../components/cardList.vue'
import GBdialog from '../components/gb-dialog.vue'
export default{
    data(){
        return{
            shots: []
        }
    },

    components: {
        'cardlist': cardList,
        'gb-dialog': GBdialog
    },
    beforeMount : function() {
        axios.get('/benefit/getSavedNum')
        .then(response => {
            if(response.data != ""){
                const frm = new FormData();
                var temp = response.data+"";
                if(temp.indexOf(',') != -1) {
                    var arr = response.data.split(',');
                    arr.forEach((data, index) => {
                        frm.append(''+data, ''+data);
                    });
                }
                else{
                    frm.append(''+response.data, ''+response.data);
                }
                axios.get('/benefit/getSavedClassify').then((res)=>{
                    console.log(res.data);
                    if(res.data == 1)
                        {frm.append('credit', 'credit');}
                    else if(res.data == 2){
                        frm.append('check', 'check');
                    }
                    else{
                        frm.append('credit', 'credit');
                        frm.append('check', 'check');
                    }
                    axios.post('/benefit/getNum', frm)
                    .then((response) => {
                        var temp = response.data+"";
                        var arr = new Array();
                        if(temp.indexOf(",") == -1){
                            arr[0] = temp;
                        }
                        else
                            arr = response.data.split(',');
                        arr.forEach((data, index)=>{
                            var frm2 = new FormData();
                            frm2.append('num', data);
                            axios.post('/benefit/Image', frm2, { responseType: 'arraybuffer' })
                            .then((response)=>{
                                axios.post('/benefit/data', frm2,)
                                .then((res)=>{
                                    let blob = new Blob([response.data],{ type: response.headers['content-type'] });
                                    let image = URL.createObjectURL(blob);
                                    this.shots.push({'srcs':image, 'cardName': res.data.cardName, 'cardCategory': res.data.cardCategory, 'bankName': res.data.bankName, 'cardDetail': res.data.cardDetail, 'registerLink': res.data.registerLink});
                                })
                            })
                        });
                    })
                });
            }
        });
    },
    methods: {
        getList: function(){
            this.shots =[];
            const frm = new FormData();
            for(var i=1; i<10; i++){
                if(document.getElementById(''+i).checked)
                    frm.append(''+i, ''+i);
            }
            if(document.getElementById('credit').checked)
                frm.append('credit', 'credit');
            if(document.getElementById('check').checked)
                frm.append('check', 'check');
            axios.post('/benefit/getNum', frm)
            .then((response) => {
                var arr = new Array();
                var temp = response.data+"";
                if(temp.indexOf(',') != -1)
                    arr = response.data.split(',');
                else
                    arr[0] = response.data;
                arr.forEach((data, index)=>{
                    var frm2 = new FormData();
                    frm2.append('num', data);
                    axios.post('/benefit/Image', frm2, { responseType: 'arraybuffer' })
                    .then((response)=>{
                        axios.post('/benefit/data', frm2,)
                        .then((res)=>{
                            let blob = new Blob([response.data],{ type: response.headers['content-type'] });
                            let image = URL.createObjectURL(blob);
                            this.shots.push({'srcs':image, 'cardName': res.data.cardName, 'cardCategory': res.data.cardCategory, 'bankName': res.data.bankName, 'cardDetail': res.data.cardDetail, 'registerLink': res.data.registerLink});
                        })
                    })
                });
            })
            
        },

        saveNum: function(){
            const frm = new FormData();
            for(var i=1; i<10; i++){
                if(document.getElementById(''+i).checked)
                    frm.append(''+i, ''+i);
            }
            if(document.getElementById('credit').checked)
                frm.append('credit', 'credit');
            if(document.getElementById('check').checked)
                frm.append('check', 'check');
            axios.post('/benefit/saveNum', frm)
            .then((reponse) => {
                document.getElementById('dialog1').click();
            });
        },

        logout: function() {
            axios.get('/logout').then((res)=>{
                window.location = '/';
            });
        }
    }
}
</script>

<style scoped>

    body, html{
        height: 100%;
    }
    .benefitform{
        position: relative;
        display: flex;
        justify-content: center;
        vertical-align: middle;
        margin-top: auto;
         margin-bottom: 300px; /*auto */
    }
    .benefitset{
        height:auto;
        margin-top: auto;
        margin-bottom: auto;
        background:aliceblue;
        padding: 10px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        -webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        -moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        border-radius: 5px;
    }
    input[type="checkbox"] {
    display:none;
    }
    input[type="checkbox"] + label span {
    display: inline-block;
    width: 24px;
    height: 24px;
    margin: -2px 10px 0 0;
    vertical-align: middle;
    background: url(../img/checkbox.svg) left top no-repeat;
    cursor: pointer;
    background-size: cover;
    }
    input[type="checkbox"]:checked + label span {
    background:url(../img/checkbox.svg)  -26px top no-repeat;
    background-size: cover;
    }
    input[type="button"] {
    background:midnightblue;
    border: 3px solid #fff;
    border-radius: 5px;
    color: #fff;
    /* display: block; */
    font-size: 1em;
    font-weight: bold;
    margin: 1em auto;
    padding: .5em 1.5em;
    position: relative;
    text-transform: uppercase;
    }
    /* iframe을 숨기기 위한 css*/
    #if{
        width: 0px;
        height: 0px;
        border: 0px;
    }
</style>