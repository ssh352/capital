<style lang="stylus">
.sexBg
  position fixed
  top 0
  left 0
  width 100%
  height 245px
  background-color #ADBBCD
</style>

<template>
  <div>
    <div class="sexBg">
    </div>
    <tb-row class="tb-m-t-50">
      <tb-col :sm="{span: 10, offset: 7}">
        <tb-card style="background-color: #6495ed">
          <tb-card-body class="tb-card-padding">
            <h1 style="font-size: 100px;text-align: center;color: #fff">404</h1>
            <h2 style="font-size: 24px;text-align: center;color: #fff" class="tb-m-b-30">Aha, you get it</h2>
            <p style="text-align: center"><router-link :to="{path: '/index'}"><tb-btn type="danger" icon="long-arrow-left"></tb-btn></router-link></p>
          </tb-card-body>
        </tb-card>
      </tb-col>
    </tb-row>
  </div>
</template>

<script>
  export default {
    created () {
      this.$store.commit('SET_LEFTMENU', false);
      this.$store.commit('SET_TOPNAV', false);
    }
  }
</script>