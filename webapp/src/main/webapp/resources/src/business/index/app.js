import Vue from 'vue';
import VueRouter from 'vue-router';
import VueResource from 'vue-resource';
import Sd from '@tbj/skydragon';
import Cookie from '@tbj/cookie';
import Util from '@tbj/chen';
import App from './base/main';
import routerConfig from './router';
import store from './store';

// 主题样式
import '../../components/common/common.styl';

Vue.config.devtools = true;

// Router
Vue.use(VueRouter);

// Resource
Vue.use(VueResource);

// sky dragon framework
Vue.use(Sd);

// Cookie
Vue.use(Cookie);

// Util
Vue.use(Util);

// 配置 resource
Vue.http.options.root = '';
Vue.http.options.emulateJSON = true;

const router = routerConfig(VueRouter);

new Vue(Vue.util.extend({
  router,
  store
}, App)).$mount('#app');