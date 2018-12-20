<style lang="stylus">
.profileImg
  img
    width 100%
.profileConnect
  position absolute
  bottom 20px
  left 50%
  margin-left -12px
  box-shadow 0 1px 3px rgba(0, 0, 0, 0.3)
  background-color #333
  padding 5px 10px 3px 10px
  cursor pointer
  .tb-icon
    color #fff
.profileImgList
  .tb-col-sm-6
    height 140px
    padding 10px
    img
      max-width 100%
      max-height 100%
</style>
<template>
  <div>
    <tb-breadcrumb>
      <tb-breadcrumb-one label="个人信息" :active="true"></tb-breadcrumb-one>
    </tb-breadcrumb>
    <tb-card class="tb-m-t-10">
      <tb-card-body class="tb-card-padding">
        <tb-row>
          <tb-col :sm="8">
            <div class="profileImg">
              <img src="https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/s%3D500/sign=464fc405871001e94a3c140f880f7b06/9358d109b3de9c8234db74636681800a18d843a4.jpg">
            </div>
            <div class="profileConnect" @click="showMessagePanel">
              <tb-icon icon="comment-text-alt" size="30px"></tb-icon>
            </div>
          </tb-col>
          <tb-col :sm="16" class="tb-p-l-20 tb-p-r-20">
            <tb-tabs v-model="activeName">
              <tb-tab-pane label="关于我" name="about">
                <p>&nbsp;&nbsp;&nbsp;&nbsp;Angelababy（杨颖），1989年2月28日出生于上海市，华语影视女演员、时尚模特。</p>
                <p>&nbsp;&nbsp;&nbsp;&nbsp;2003年，Angelababy以模特身份出道，此后，她因担任时尚模特而在香港崭露头角。2007年，她开始将工作重心转向大银幕。2011年，她在爱情片《夏日乐悠悠》中首次担任女主角 。2012年，凭借言情片《第一次》获得第13届华语电影传媒大奖最受瞩目女演员奖[2]  。2013年，Angelababy与其她三位女艺人被《南都娱乐周刊》选为新“四小花旦”；同年，她还完成了个人的荧屏处女作《大汉情缘之云中歌》</p>
                <p>&nbsp;&nbsp;&nbsp;&nbsp;2014年，Angelababy开始凭借真人秀《奔跑吧兄弟》赢得广泛关注[4]  ；同年，她还因出演古装片《狄仁杰之神都龙王》获得第21届北京大学生电影节最受欢迎女演员奖[5]  。2015年，其主演的冒险片《鬼吹灯之寻龙诀》票房突破16亿人民币[6]  ，而她也凭借该片获得第33届大众电影百花奖最佳女配角奖[7]  。2017年，其主演的古装剧《孤芳不自赏》取得全国同时段电视剧收视冠军[8]  。</p>
              </tb-tab-pane>
              <tb-tab-pane label="联系我" name="connect">
                <tb-row class="profileImgList">
                  <tb-col :sm="6">
                    <img src="https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=1c37718b3cc79f3d9becec62dbc8a674/38dbb6fd5266d016dc2eaa5c902bd40735fa358a.jpg">
                  </tb-col>
                  <tb-col :sm="6">
                    <img src="https://gss3.bdstatic.com/7Po3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=edd05c9c502c11dfcadcb771024e09b5/d6ca7bcb0a46f21f3100c52cf1246b600c33ae9d.jpg">
                  </tb-col>
                  <tb-col :sm="6">
                    <img src="https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=602f7a656759252db71a155655f2685e/902397dda144ad34e0541ff8d7a20cf430ad85e2.jpg">
                  </tb-col>
                  <tb-col :sm="6">
                    <img src="https://gss0.bdstatic.com/-4o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=b79258fac1ea15ce55e3e85bd7695196/7e3e6709c93d70cf8f6e9c72f0dcd100baa12b3c.jpg">
                  </tb-col>
                  <tb-col :sm="6">
                    <img src="https://gss0.bdstatic.com/-4o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=c9da91274010b912abccfeaca2949766/d043ad4bd11373f086c9b903a30f4bfbfaed04b3.jpg">
                  </tb-col>
                </tb-row>
              </tb-tab-pane>
              <tb-tab-pane label="作品" name="product">
              </tb-tab-pane>
            </tb-tabs>
          </tb-col>
        </tb-row>
      </tb-card-body>
    </tb-card>

    <tb-modal v-model="mshow" title="联系我" :bg-close="false" :has-close="true">
      <div class="tb-p-t-10 tb-p-b-10 tb-p-l-20 tb-p-r-10" style="line-height: 24px">
        <tb-input v-model="tvalue" 
          :textarea="true"
          :rows="5"
          placeholder="你好，我是angelababy，有什么想对我说的么？"></tb-input>
      </div>
      <div class="tb-p-20 clearfix">
        <tb-btn type="default" class="tb-float-right tb-m-l-10" @click="mshow = !mshow">关闭</tb-btn>
        <tb-btn type="primary" class="tb-float-right" @click="sendMessage">确定</tb-btn>
      </div>
    </tb-modal>
  </div>
</template>

<script>
  export default {
    data () {
      return {
        activeName: this.$route.params.type ? this.$route.params.type : 'about',
        mshow: false,
        tvalue: ''
      }
    },

    mounted () {
      this.$watch('activeName', (val) => {
        this.$router.push('/profile/' + val);
      });
    },

    methods: {
      showMessagePanel () {
        this.tvalue = '';
        this.mshow = true;
      },
      sendMessage () {
        this.$Message({
          type: 'success',
          message: '消息已经发送',
          position: 'centertop'
        });
        this.mshow = false;
      }
    }
  }
</script>