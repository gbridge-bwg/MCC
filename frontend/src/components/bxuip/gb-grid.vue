<template>
<div id="table-wrap">
      <table>
        <thead>
        <tr>
            <th>순서</th>
            <th>이름</th>  
            <th>전화번호</th>
            <th>주소</th>
            <th>삭제</th>
        </tr>
    </thead>
    <tbody>
        <tr v-for="(tableSample, index) in tableSamples" :key="index">
            <td>{{index+1}}</td>
            <td>{{tableSample.name}}</td>
            <td>{{tableSample.tel}}</td>
            <td>{{tableSample.address}}</td>
            <td><button id="gb-button" v-on:click="removeUser(tableSample, index)">삭제</button></td>
    <modal v-if="showModal" v-on:close="showModal=false">
      <h3 id="modal-header" slot="header">삭제알림</h3>
      <h4 id="modal-body" slot="body">삭제가 완료 됐습니다.</h4>
      <div id="wrap">
      <h4 slot="footer" v-on:click="showModal=false"></h4>
      </div>
    </modal>
        </tr>
    </tbody>
    </table>
    
  </div>  
</template>

<script>
import Modal from '../common/Modal.vue'

export default {

  data() {
    return {
      showModal : false,
      tableSamples : [
        {name : '일길동', tel : '1111-1111', address : '서울 동대문구'},
        {name : '이길동', tel : '2222-2222', address : '경기도 성남시'},
        {name : '삼길동', tel : '3333-3333', address : '서울 성북구'},
        {name : '사길동', tel : '4444-4444', address : '서울 성동구'},
        {name : '오길동', tel : '5555-5555', address : '제주도'},
        {name : '육길동', tel : '6666-6666', address : '울릉도'},
      ]
    }
  },
  components : {
    Modal : Modal
  },
  methods : {
      removeUser(tableSample, index) {
          console.log("Modal을 적용한다음");
          console.log("삭제 할 때 누르세요");
          this.showModal = !this.showModal;
          this.tableSamples.splice(index,1)
          
      }
  }
}
</script>

<style scoped>
table {
    
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: auto;

    /* from bxuip */
    /* 상위 컨테이너에서 align을 center후, margin에 auto 부여시 중앙정렬 */
    /* margin에 auto만 부여해도 중앙정렬이 되긴 함 */
    margin: auto;  

    table-layout: fixed !important;
    border-spacing: 0 !important;
    border-collapse: collapse !important;
    text-align: center !important;
    border-width: 0;
    border-left: 1px solid #e6e6e6 !important;
    border-style: none;
    padding: 1000px;
    font-size: 12px;
    font-family: 'notokr';
    font-weight: normal;
    display: table;
    border-color: grey;
    line-height: normal;
    color: #454545;
    
/* =======================끝 */
  }

  thead{
      /* bwg 에서 가져옴 */
      display: table-header-group;
      vertical-align: middle;
      border-color: inherit;
      table-layout: fixed !important;
    border-spacing: 0 !important;
    border-collapse: collapse !important;
    text-align: center !important;
    border-width: 0;
    border-style: none;
    font-family: 'notokr';
    font-weight: normal;
    margin: 0;
    padding: 0;
    font-size: 12px;
      /* end */
  }

  th {
      /* from bwg */
      padding: 0px;
      height: 40px !important;
      letter-spacing: -.5px !important;
      font-weight: 500 !important;
      font-size: 12px !important;
      width: 103px;
      overflow: hidden;
      white-space: nowrap;
      text-align: center;
      border-bottom: none !important;
      border-left: 1px solid #e6e6e6 !important;
      border-top: 1px solid #e6e6e6 !important;
      background: #fbfbfb !important;
      color: #1299c1 !important;
      border: 1px solid #c5c5c5;
      border-right: 1px solid #e6e6e6 !important;
      margin: 0;
      display: table-cell;
    vertical-align: inherit;
    table-layout: fixed !important;
    border-spacing: 0 !important;
    border-collapse: collapse !important;
    line-height: normal;
      /* end */
  }

  tr {
      /* from bwg */
      outline-style: none;
      background: #fff;
      color: #333;
      display: table-row;
    vertical-align: inherit;
    table-layout: fixed !important;
    border-spacing: 0 !important;
    border-collapse: collapse !important;
    text-align: center !important;
    font-family: 'notokr';
    font-weight: normal;
    margin: 0;
    padding: 0;
    font-size: 12px;
    line-height: normal;

      /* end */
  }

td {
    /* from bwg */
    border-color: initial;
    height: 40px !important;
    font-size: 12px !important;
    text-align: center;
    text-overflow: ellipsis;
    border-left-width: 0;
    border-bottom: 1px solid #eeeeee !important;
    border-right: 1px solid #e6e6e6 !important;

    color: #666666 !important;
    border-left-style: none !important;
    font-weight: normal;
    padding: 0 2px 0 2px;
    border-top: 0 none;
    overflow: hidden;
    white-space: pre;
    vertical-align: middle;
    margin: 0;
    display: table-cell;
    border-spacing: 0 !important;
    border-collapse: collapse !important;

    /* end */
}
/* end grid css */

    #gb-button {
        box-sizing: border-box;
        width: auto;
        height: 25px;
        line-height: 25px;
        cursor: pointer;
        display: inline-block;
        border: 0;
        padding: 0 10px;
        border-radius: 3px;
        font-size: 11px;
        text-transform: capitalize;
        color: white;
        background: #1297bf;
    }
</style>