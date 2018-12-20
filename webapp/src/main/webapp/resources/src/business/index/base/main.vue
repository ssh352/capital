<style lang="stylus">
.setMenu
  position fixed
  right 20px
  bottom 20px
  z-index 2
</style>
<template>
  <div id="app">
    <div class="setMenu">
      <tb-btn :icon="isLeftFixed ? 'menu' : 'widgets'" type="danger" @click="changeLeft(!isLeftFixed)"></tb-btn>
    </div>
    <left-bar :is-left-fixed="isLeftFixed"></left-bar>
    <div class="container" :class="{'fullContainer': !isLeftFixed}">
      <keep-alive>
        <router-view v-if="$route.meta.keepAlive"></router-view>
      </keep-alive>
      <router-view v-if="!$route.meta.keepAlive"></router-view>
    </div>
    <bottom-footer :is-left-fixed="isLeftFixed"></bottom-footer>
  </div>
</template>

<script>
  import leftBar from '../../../components/leftbar/leftbar.vue';
  import bottomFooter from '../../../components/bottomfooter/bottomfooter.vue';

  export default {
    computed: {
      isLeftFixed () {
        return this.$store.state.isLeftFixed;
      },
      isTopShow () {
        return this.$store.state.isTopShow;
      }
    },

    created () {
      if (document.body.clientWidth < 768) {
        this.$store.commit('SET_LEFTMENU', false);
      }
      
      window.onresize = () => {
        if (document.body.clientWidth < 768) {
          this.$store.commit('SET_LEFTMENU', false);
        }
      }
    },

    methods: {
      changeLeft (type) {
        this.$store.commit('SET_LEFTMENU', type);
      }
    },

    components: {
      leftBar,
      bottomFooter
    }
  }
</script>