<template>
    <div>
        <form name = "form1" class ="benefitform" style="width: 100%; height: 100%;" action="/benefit/getImage" method="POST" target="param">
            <fieldset class="benefitset">
                <h2>MCC 카드 검색</h2>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="1" name="1" value="checkCaffe" /><label for="1"> <span></span>카페/디저트</label>
                </span>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="2" name="2" value="checkTrip" /><label for="2"> <span></span>여행/숙박</label>
                </span>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="3" name="3" value="checkMovie" /><label for="3"> <span></span>영화/문화</label>
                </span>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="4" name="4" value="checkTraffic" /><label for="4"> <span></span>교통</label>
                </span>
                <br>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="5" name="5" value="checkTel" /><label for="5"> <span></span>통신</label>
                </span>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="6" name="6" value="checkAir" /><label for="6"> <span></span>항공</label>
                </span>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="7" name="7" value="checkFood" /><label for="7"> <span></span>음식</label>
                </span>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="8" name="8" value="checkShopping" /><label for="8"> <span></span>쇼핑</label>
                </span>
                <span style="margin-bottom:10px">
                    <input type="checkbox" id="9" name="9" value="checkHospital" /><label for="9"> <span></span>병원</label>
                </span>
                <br>
                <input type="button" value="조회" v-on:click="getList">
                <br>
                <div>
                    <cardlist v-for="(cards,index) in shots" :key="index" :src=cards.srcs :bankName=cards.bankName :cardCategory=cards.cardCategory :cardDetail=cards.cardDetail :cardName=cards.cardName></cardlist>
                </div>
            </fieldset>
        </form>
        <iframe id="if" name="param"></iframe>
    </div>
</template>

<script>
// import Modal from './common/Modal.vue'
import axios from 'axios'
import cardList from '../components/cardList.vue'
export default{
    data(){
        return{
            shots: [],
        }
    },

    components: {
        'cardlist': cardList
    },
    methods: {
        getList: function(){
            const frm = new FormData();
            var chk1=document.getElementById('1').checked;
            var chk2=document.getElementById('2').checked;
            var chk3=document.getElementById('3').checked;
            var chk4=document.getElementById('4').checked;
            var chk5=document.getElementById('5').checked;
            var chk6=document.getElementById('6').checked;
            var chk7=document.getElementById('7').checked;
            var chk8=document.getElementById('8').checked;
            var chk9=document.getElementById('9').checked;
            if(chk1){frm.append('1', '1');}
            if(chk2){frm.append('2', '2');}
            if(chk3){frm.append('3', '3');}
            if(chk4){frm.append('4', '4'); console.log('check');}
            if(chk5){frm.append('5', '5');}
            if(chk6){frm.append('6', '6');}
            if(chk7){frm.append('7', '7');}
            if(chk8){frm.append('8', '8');}
            if(chk9){frm.append('9', '9');}
            axios.post('/benefit/getImage', frm)
            .then((response) => {
                var arr = response.data.split(',');
                arr.forEach((data, index)=>{
                    var frm2 = new FormData();
                    frm2.append('num', data);
                    axios.post('/benefit/Image', frm2, { responseType: 'arraybuffer' })
                    .then((response)=>{
                        axios.post('/benefit/data', frm2,)
                        .then((res)=>{
                            console.log(res.data);
                            let blob = new Blob([response.data],{ type: response.headers['content-type'] });
                            let image = URL.createObjectURL(blob);
                            this.shots.push({'srcs':image, 'cardName': res.data.cardName, 'cardCategory': res.data.cardCategory, 'bankName': res.data.bankName, 'cardDetail': res.data.cardDetail});
                        })
                    })
                });
            })
            
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
    display: block;
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