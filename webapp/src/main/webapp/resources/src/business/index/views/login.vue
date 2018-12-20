<style lang="stylus">
.loginBg
  position fixed
  top 0
  left 0
  width 100%
  height 245px
  background-color #1FBCD2
</style>
<template>
  <div>
    <div class="loginBg">
    </div>
    <tb-row class="tb-m-t-50">
      <tb-col :sm="{span: 10, offset: 7}">
        <tb-card>
          <tb-card-header>
            <h2 style="text-align: center;font-size:24px">登录</h2>
          </tb-card-header>
          <tb-card-body class="tb-card-padding">
            <tb-form class="tb-m-t-20 tb-p-l-10 tb-p-r-10">
              <tb-form-item label="用户名" position="left" align="left">
                <tb-input v-model="searchForm.username"></tb-input>
              </tb-form-item>

              <tb-form-item label="密码" position="left" align="left">
                <tb-input v-model="searchForm.password"></tb-input>
              </tb-form-item>
              <tb-form-item label="是否记住" position="left" align="left">
                <tb-checkbox v-model="searchForm.isRemember" label=""></tb-checkbox>
              </tb-form-item>

              <tb-form-item>
                <tb-btn type="primary" @click="checkLogin">登录</tb-btn>
                <router-link :to="{path: '/index'}"><tb-btn type="danger">返回</tb-btn></router-link>
              </tb-form-item>
            </tb-form>
          </tb-card-body>
        </tb-card>
      </tb-col>
    </tb-row>
  </div>
</template>

<script>
  export default {
    data () {
      return {
        searchForm: {
          username: '',
          password: '',
          isRemember: false
        }
      }
    },

    created () {
      this.$store.commit('SET_LEFTMENU', false);
      this.$store.commit('SET_TOPNAV', false);
    },

    methods: {
      checkLogin () {
        if (this.searchForm.username === '' || this.searchForm.password === '') {
          this.$Message({
            type: 'warning',
            message: '请查看填写是否完整',
            position: 'centertop'
          });
        } else {
          this.$Message({
            type: 'success',
            message: '登录成功',
            position: 'centertop'
          });
          setTimeout(() => {
            this.$router.push('/index');
          }, 1000);
        }
      }
    }
  }
</script>