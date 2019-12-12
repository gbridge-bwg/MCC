<template>

  <div id="inpu1-wrap">
    <label>phone</label>
    <div id="input1-phone-wrap">
      <input id="input1-first" placeholder="010" maxlength="3"/>
      <input id="input1-second" placeholder="1234" maxlength="4"/>
      <input id="input1-third" placeholder="5678" maxlength="4"/>
    </div>
  </div>

</template>

<script>
export default {

}
</script>

// scoped 부여 하지 말것!
<style scoped>
#inpu1-wrap {
    vertical-align: bottom;
    position: relative;
    display: inline-block;
    padding: 0 0 0 0;
    line-height: 25px;
    height: 25px;
    background: white;
    box-shadow: 0 0 0 1px #e6e6e6 inset;
}


label {

    margin: 0;
    display: inline-block;
    float: left;
    background-color: transparent;
    height: 25px;
    font-size: 11px;
    text-overflow: ellipsis;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    overflow: hidden;
    width: 90px;
    line-height: 25px;
    text-indent: 20px;
    font-weight: 400;
    background-size: auto 100%;
    text-align: left;
    color: #1297bf;
    box-sizing: border-box;
    /* font-family: 'notokr'; */
}

#input1-phone-wrap {
    background-repeat: no-repeat;
    background-position-x: left;
    text-indent: 0;
    box-shadow: inset 1px 0 0 0 #e1e1e1;
    font-size: 12px;
    display: inline-block;
    vertical-align: middle;
    line-height: 25px;
    height: 25px;
    box-sizing: border-box;
    float: left;
    width: auto;
    padding-left: 20px;
    margin: 0;
    background-color: transparent;
    border: 0;
    min-width: 120px;
    background-image: url(../../assets/phoneIcon.svg);
    color: #666666;
    /* font-family: 'notokr'; */
    font-weight: normal;
    content: "";
}

#input1-first, #input1-second, #input1-third {

    width: 60px !important;
    min-width: 50px;
    margin: 0;

    box-sizing: border-box;
    background-repeat: no-repeat;
    background-position-x: right;
    box-shadow: none;
    text-align: center;
    text-indent: 0;
    display: inline-block;
    float: left;
    background-color: transparent;
    height: 25px;
    font-size: 11px;
    padding: 0 10px 0 5px;
    outline: none;
    line-height: 13px;
    border: 0;
    color: #666666;
    font: 400 13.3333px Arial;
    cursor: text;
    letter-spacing: normal;
    word-spacing: normal;
    text-transform: none;
    text-rendering: auto;
    /* background-image: url(./images/1.svg); */
}

#input1-first, #input1-second {
    border-right: 1px solid #e6e6e6;
}

#inpu1-shpae-wrap {
    vertical-align: bottom;
    position: relative;
    display: inline-block;
    padding: 0 0 0 0;
    border-radius: 30px;
    line-height: 25px;
    height: 25px;
    background: white;
    box-shadow: 0 0 0 1px #e6e6e6 inset;
}


</style>