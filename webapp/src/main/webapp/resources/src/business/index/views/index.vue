<style lang="stylus">
.clickCard
  position absolute
  top 45px
  right 30px
#oneTip
  display inline-block
  margin-bottom 0
</style>
<template>
  <div>
    <tb-breadcrumb>
      <tb-breadcrumb-one label="首页" :active="true"></tb-breadcrumb-one>
    </tb-breadcrumb>
    <tb-card class="tb-m-t-10 tb-m-b-10" style="border-bottom: 1px solid #f2f2f2">
<!--       <tb-card-header>
        <h2>欢迎来到铜板街Skydragon天空之龙组件库</h2>
      </tb-card-header> -->
      <tb-card-body class="tb-card-padding">
        <h2 id="oneTip">Angelababy</h2>
        <p class="tb-m-b-20 tb-m-t-20">欢迎你</p>
        <tb-alert type="danger" :has-close="true" @close="closeAlert" :show="alertShow">今日存在20个进件需要处理</tb-alert>
        <tb-btn type="danger" size="sm" class="clickCard" :disabled="disabled" @click="clickCard">{{cardMsg}}</tb-btn>
      </tb-card-body>
    </tb-card>
    <tb-card>
      <tb-card-header>
        <h2>事项概况</h2>
      </tb-card-header>
      <tb-card-body class="tb-card-padding">
        <tb-tabs v-model="activeName" style="height: 300px;overflow: auto">
          <tb-tab-pane label="待完成" name="jugg">
            <table class="tb-table tb-table-border">
              <thead>
                <tr>
                  <th>序号</th>
                  <th>事件</th>
                  <th>反馈时间</th>
                  <th>状态</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>反馈客户</td>
                  <td>2017-12-16</td>
                  <td><tb-btn type="danger" size="xs">紧急</tb-btn></td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>提示客户</td>
                  <td>2017-12-16</td>
                  <td><tb-btn type="info" size="xs">暂缓</tb-btn></td>
                </tr>
                <tr>
                  <td>3</td>
                  <td>回款</td>
                  <td>2017-12-16</td>
                  <td><tb-btn type="danger" size="xs">紧急</tb-btn></td>
                </tr>
                <tr>
                  <td>4</td>
                  <td>放款客户</td>
                  <td>2017-12-16</td>
                  <td><tb-btn type="danger" size="xs">紧急</tb-btn></td>
                </tr>
              </tbody>
            </table>
          </tb-tab-pane>
          <tb-tab-pane label="已完成" name="nec">
            <table class="tb-table tb-table-border">
              <thead>
                <tr>
                  <th>序号</th>
                  <th>事件</th>
                  <th>反馈时间</th>
                  <th>状态</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>反馈客户</td>
                  <td>2017-12-16</td>
                  <td><tb-btn type="danger" size="xs">紧急</tb-btn></td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>回款</td>
                  <td>2017-01-12</td>
                  <td><tb-btn type="danger" size="xs">紧急</tb-btn></td>
                </tr>
                <tr>
                  <td>3</td>
                  <td>提示客户</td>
                  <td>2017-11-11</td>
                  <td><tb-btn type="info" size="xs">暂缓</tb-btn></td>
                </tr>
                <tr>
                  <td>4</td>
                  <td>放款客户</td>
                  <td>2017-12-16</td>
                  <td><tb-btn type="danger" size="xs">紧急</tb-btn></td>
                </tr>
              </tbody>
            </table>
          </tb-tab-pane>
          <tb-tab-pane label="注意事项" name="ta">
            <h3>今天会下大雨，可以尽快解决问题。尽快回家陪狗吧。</h3>
            <h3>明天需要进行Dota2比赛，请带好电脑和脑子。今晚好好休息。</h3>
          </tb-tab-pane>
        </tb-tabs>
      </tb-card-body>
    </tb-card>
    <buffer-line :show="isBufferShow"></buffer-line>
  </div>
</template>

<script>
  import BufferLine from '../../../components/bufferLine/bufferLine';

  export default {
    data () {
      return {
        isBufferShow: false,
        alertShow: true,
        disabled: false,
        cardMsg: '打卡',
        activeName: 'jugg'
      }
    },
    mounted () {
      this.$Tooltip({
        ele: '#oneTip',
        type: 'warning',
        message: '最漂亮的女星~~~~啦啦啦',
        position: 'top'
      });
      this.isBufferShow = true;
      setTimeout(() => {
        this.isBufferShow = false;
      }, 2000);
    },

    methods: {
      requestDemo () {
        // 请求demo
        this.$store.dispatch('commonActionPost', ['account.getUser', {
          id: 23
        }]).then((result) => {
          if (result.code) {
            // 处理成功
          } else {
            // 处理失败
          }
        }, () => {
          // 请求失败
        });
      },
      closeAlert () {
        this.alertShow = false;
      },
      clickCard () {
        this.disabled = true;
        this.cardMsg = '已打卡';
        this.$Message({
          type: 'success',
          message: '打卡成功',
          position: 'righttop'
        });
      }
    },

    components: {
      BufferLine
    }
  }
</script>