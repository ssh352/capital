<template>
  <div>
    <tb-breadcrumb>
      <tb-breadcrumb-one label="表单例子"></tb-breadcrumb-one>
      <tb-breadcrumb-one label="基础表单" :active="true"></tb-breadcrumb-one>
    </tb-breadcrumb>
    <tb-card class="tb-m-t-10 tb-m-b-10">
      <tb-card-header>
        <h2>表单demo1</h2>
      </tb-card-header>
      <tb-card-body class="tb-card-padding tb-p-b-0">
        <tb-form>
          <tb-form-item :md="8" label="数据源" position="left" align="left">
            <tb-select-input v-model="searchForm.dataResource" :options="dataResources" :filter="true">
            </tb-select-input>
          </tb-form-item>

          <tb-form-item :md="8" label="选择日期" position="left" align="left">
            <tb-date-time v-model="dateTime" type="datetime"></tb-date-time>
          </tb-form-item>

          <tb-form-item :md="8" label="搜索" position="left" align="left">
            <tb-input v-model="searchForm.searchValue">
              </tb-input>
          </tb-form-item>

          <tb-form-item :md="8" label="个数" position="left" align="left">
            <tb-input-number v-model="inputNumber" :max="11" :min="5" :step="2"></tb-input-number>
          </tb-form-item>

          <tb-form-item :md="8">
            <tb-btn-group>
              <tb-btn type="primary">查询</tb-btn>
            </tb-btn-group>
          </tb-form-item>
        </tb-form>
      </tb-card-body>
    </tb-card>

    <tb-row>
      <tb-col :sm="12" class="tb-p-r-5">
        <tb-card class="tb-m-b-10">
          <tb-card-header>
            <h2>表单demo2</h2>
          </tb-card-header>
          <tb-card-body class="tb-card-padding tb-p-b-0">
            <tb-form>
              <tb-form-item label="姓名" position="left" align="left" class="tb-m-b-20">
                <tb-input v-model="tvalue" 
                  placeholder="helloworld">
                  </tb-input>
              </tb-form-item>

              <tb-form-item label="班级" position="left" align="left" class="tb-m-b-20">
                <tb-select-input v-model="selectValue" :options="options" :filter="true">
                </tb-select-input>
              </tb-form-item>

              <tb-form-item label="性别" position="left" align="left" class="tb-m-b-20">
                <tb-checkbox-group v-model="checked3">
                  <tb-checkbox label="say" :inline="true">男</tb-checkbox>
                  <tb-checkbox label="what" :inline="true">女</tb-checkbox>
                </tb-checkbox-group>
              </tb-form-item>

              <tb-form-item label="日期" position="left" align="left" class="tb-m-b-20">
                <tb-date-time v-model="dateTime2" type="datetime"></tb-date-time>
              </tb-form-item>

              <tb-form-item label="类别" position="left" align="left" class="tb-m-b-20">
                <tb-radio-group v-model="raidoword">
                  <tb-radio
                  name="lt"
                  label="say"
                  :inline="true">hello world</tb-radio>
                  <tb-radio
                  name="lt"
                  label="say2"
                  :inline="true">hello world2</tb-radio>
                </tb-radio-group>
              </tb-form-item>

              <tb-form-item label="开关" position="left" align="left" class="tb-m-b-20">
                <tb-switch class="tb-m-t-10 tb-m-r-10" bgmcolor="red" v-model="switchValue"></tb-switch>
              </tb-form-item>

              <tb-form-item class="tb-m-b-20">
                <tb-btn-group>
                  <tb-btn type="primary">保存</tb-btn>
                  <tb-btn type="danger">取消</tb-btn>
                </tb-btn-group>
              </tb-form-item>
            </tb-form>
          </tb-card-body>
        </tb-card>
      </tb-col>
      <tb-col :sm="12" class="tb-p-l-5">
        <tb-card class="tb-m-b-10">
          <tb-card-header>
            <h2>表单demo3</h2>
          </tb-card-header>
          <tb-card-body class="tb-card-padding tb-p-b-0">
            <tb-form>
              <tb-form-item label="姓名" position="top" align="left" class="tb-m-b-20">
                <tb-input v-model="tvalue" 
                  placeholder="helloworld">
                  </tb-input>
              </tb-form-item>

              <tb-form-item label="班级" position="top" align="left" class="tb-m-b-20">
                <tb-select-input v-model="selectValue" :options="options" :filter="true">
                </tb-select-input>
              </tb-form-item>

              <tb-form-item label="性别" position="top" align="left" class="tb-m-b-20">
                <tb-checkbox-group v-model="checked3">
                  <tb-checkbox label="say" :inline="true">男</tb-checkbox>
                  <tb-checkbox label="what" :inline="true">女</tb-checkbox>
                </tb-checkbox-group>
              </tb-form-item>

              <tb-form-item label="日期" position="top" align="left" class="tb-m-b-20">
                <tb-date-time v-model="dateTime3" type="datetime"></tb-date-time>
              </tb-form-item>

              <tb-form-item label="类别" position="top" align="left" class="tb-m-b-20">
                <tb-radio-group v-model="raidoword">
                  <tb-radio
                  name="lt"
                  label="say"
                  :inline="true">hello world</tb-radio>
                  <tb-radio
                  name="lt"
                  label="say2"
                  :inline="true">hello world2</tb-radio>
                </tb-radio-group>
              </tb-form-item>

              <tb-form-item label="开关" position="top" align="left" class="tb-m-b-20">
                <tb-switch class="tb-m-t-10 tb-m-r-10" bgmcolor="red" v-model="switchValue"></tb-switch>
              </tb-form-item>

              <tb-form-item class="tb-m-b-20">
                <tb-btn-group>
                  <tb-btn type="primary">保存</tb-btn>
                  <tb-btn type="danger">取消</tb-btn>
                </tb-btn-group>
              </tb-form-item>
            </tb-form>
          </tb-card-body>
        </tb-card>
      </tb-col>
    </tb-row>

    <buffer-line 
      :show="bufferShow">
    </buffer-line>
  </div>
</template>

<script>
  import bufferLine from '../../../components/bufferLine/bufferLine';

  export default {
    data () {
      return {
        bufferShow: false,
        searchForm: {
          dataResource: 0,
          searchValue: ''
        },
        inputNumber: 6,
        dateTime: '1991/12/16 12:30',
        dateTime2: '1992/12/16 12:30',
        dateTime3: '1993/12/16 12:30',
        tvalue: '312',
        selectValue: '1',
        selectLabel: '第一个',
        selectValue2: '1',
        switchValue: true,
        options: [{
          value: 1,
          disabled: false,
          label: '第一个'
        }, {
          value: 2,
          disabled: false,
          label: '第二个'
        }],
        dataResources: [{
          value: 0,
          label: '全部'
        }, {
          value: 1,
          label: '基本信息'
        }, {
          value: 2,
          label: '历史匹配验证'
        }, {
          value: 3,
          label: '芝麻风险名单'
        }, {
          value: 4,
          label: '同盾'
        }, {
          value: 5,
          label: '通话详单'
        }, {
          value: 6,
          label: '组合规则'
        }, {
          value: 7,
          label: '至诚'
        }, {
          value: 8,
          label: '凭安'
        }, {
          value: 9,
          label: '芝麻&工信宝'
        }]
      }
    },

    components: {
      bufferLine
    }
  }
</script>