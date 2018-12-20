<template>
  <div>
    <tb-breadcrumb>
      <tb-breadcrumb-one label="表单例子"></tb-breadcrumb-one>
      <tb-breadcrumb-one label="数据列表" :active="true"></tb-breadcrumb-one>
    </tb-breadcrumb>
    <tb-card class="tb-m-t-10 tb-m-b-10">
      <tb-card-header>
        <h2>数据列表demo</h2>
      </tb-card-header>
      <tb-card-body class="tb-card-padding tb-p-b-0">
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
      </tb-card-body>
      <tb-card-footer>
        <tb-page :cur-page="cur" :per-num="10" :total-num="200" @select="selectPage" class="tb-m-t-10"></tb-page>
      </tb-card-footer>
    </tb-card>
  </div>
</template>

<script>
  export default {
    data () {
      return {
        cur: 1
      }
    },

    methods: {
      selectPage (num) {
        this.cur = num;
      }
    }
  }
</script>