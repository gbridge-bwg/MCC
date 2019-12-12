<template>
    <div id="input2-wrap-default">
      <label id="input2-label">이름</label>
      <input id="input2-text" placeholder="write" maxlength="5"/>
    </div>
</template>

<script>
export default {

}
</script>


<style scoped>
#input2-wrap-default {
    vertical-align: bottom;
    position: relative;
    display: inline-block;
    padding: 0 0 0 0;
    line-height: 25px;
    height: 25px;
    background: white;
    box-shadow: 0 0 0 1px #e6e6e6 inset;
    font-family: 'notokr';
    font-weight: normal;
    margin: 0;
    padding: 0;
    font-size: 12px;
    box-sizing: border-box;
    color: #000;
    
}

#input2-label {
    margin: 0;
    display: inline-block;
    float: left;
    background-color: transparent;
    height: 25px;
    font-size: 11px;
    text-overflow: ellipsis;
    white-space: nowrap;
    overflow: hidden;
    width: 90px;
    border-right: 1px solid #e6e6e6;
    line-height: 25px;
    text-indent: 20px;
    font-weight: 400;
    background-size: auto 100%;
    text-align: left;
    color: #1297bf;
    box-sizing: border-box;
    cursor: default;
}

#input2-text {
    background-repeat: no-repeat;
    background-position-x: right;
    box-shadow: none;
    width: 200px !important;
    min-width: 50px;
    text-align: center;
    text-indent: 0;
    margin: 0;
    display: inline-block;
    float: left;
    background-color: transparent;
    height: 25px;
    font-size: 11px;
    outline: 0;
    line-height: 13px;
    border: 0;
    padding: 0 10px 0 5px;
    color: #666666;
    box-sizing: border-box;
    -webkit-writing-mode: horizontal-tb !important;
    text-rendering: auto;
    letter-spacing: normal;
    word-spacing: normal;
    text-transform: none;
    text-shadow: none;
    -webkit-rtl-ordering: logical;
    cursor: text;
    font: 400 13.3333px Arial;
}

</style>>
