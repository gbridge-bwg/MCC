<template>
    <transition name="modal">
    <div class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">

          <div class="modal-header">
            <slot id="modal-header" name="header">
              default header
            </slot>
          </div>

          <div class="modal-body">
            <slot id="modal-body" name="body">
              default body
            </slot>
          </div>

          <div class="modal-footer">
            <slot name="footer">
              
              <button class="modal-default-button" @click="$emit('close')">
                OK
              </button>
            </slot>
          </div>
        </div>
      </div>
    </div>
  </transition>
</template>

<script>
export default {

}
</script>

<style>
    .modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, .5);
  display: table;
  transition: opacity .3s ease;
}

.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
      background: rgba(199,229,238,0.8);
}

.modal-container {
  width: 400px;
  margin: 0px auto; 
  padding: 20px 30px;
  background-color: #fff;
    border-radius: 10px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, .33);
  transition: all .3s ease;
  font-family: Helvetica, Arial, sans-serif;

    /* width: 400px;
    margin-left: -200px;
    top: 288.5px;
    border-radius: 10px; */

}


.modal-footer{
   
}

.modal-default-button {
  /* float: right; */
    color: white;
width: 100% !important;
border: 1px solid #39aacb;
    background: linear-gradient(160deg, #1b9dc3 0%, #23acb9 42%, #34c5ab 100%);
    padding: 0 20px;
    cursor: pointer;
    font-size: 14px;
    height: 30px;
    display: inline-block;
    border-radius: 3px;
    margin: 0 5px;
        text-align: center;
            font-weight: normal;
box-sizing: border-box;
text-rendering: auto;
letter-spacing: normal;
    word-spacing: normal;
    text-transform: none;
    text-indent: 0px;
    text-shadow: none;
align-items: flex-start;


}

/*
 * The following styles are auto-applied to elements with
 * transition="modal" when their visibility is toggled
 * by Vue.js.
 *
 * You can easily play with the modal transition by editing
 * these styles.
 */

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

.modal-enter {
  opacity: 0;
}

.modal-leave-active {
  opacity: 0;
}

.modal-enter .modal-container,
.modal-leave-active .modal-container {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}
</style>