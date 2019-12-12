<template>
  <div>
    <button id="dialog1" v-on:click="test">예문보기</button>

    <modal v-if="showModal" v-on:close="showModal=false">
      <h3 id="modal-header" slot="header">알림</h3>
      <h4 id="modal-body" slot="body">alert창입니다.</h4>
      <div id="wrap">
      <h4 slot="footer" v-on:click="showModal=false"></h4>
      </div>
    </modal>
    
  </div>
</template>

<script>
import Modal from './common/Modal.vue'
export default {
  data() {
    return {

      showModal : false
    }
  },
  methods : {
    test : function() {
      this.showModal = !this.showModal;
    }
  },
  components : {
    Modal : Modal
  }
}
</script>


<style scoped>
 #wrap {
       display: block;

    font-weight: normal;
    margin: 0;
    padding: 0;
    font-size: 12px;
box-sizing: border-box;
    text-align: center;
  clear: both;
    display: block;
    content: "";
 }

   #dialog1 {
        width: 130px;
    height: 35px;
    line-height: 35px;
    background: #030709;
    color: #fff;
    border: 1px solid #190508;
 }

  #modal-header {
    color: #1299c1;
  font-size: 16px;
    font-weight: 500;
    line-height: 30px;
    word-break: break-all;
    word-wrap: break-word;
    margin-block-start: 0.83em;
    margin-block-end: 0.83em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
  display: block;
      box-sizing: border-box;
 }

#modal-body {
      padding: 0;
    line-height: 18px;
    font-size: 14px;
    overflow: auto;
    word-break: break-all;
    word-wrap: break-word;
    color: rgba(10, 9, 9, 0.308);
}
</style>>
