import form from './views/form';
import index from './views/index';
import data from './views/data';
import profile from './views/profile';
import login from './views/login';
import sex from './views/404';

export default function(VueRouter) {
  return new VueRouter({
    base: __dirname,
    routes: [{
      path: '/index',
      component: index
    }, {
      path: '/form',
      component: form,
      meta: {
        keepAlive: true
      }
    }, {
      path: '/data',
      component: data
    }, {
      path: '/profile/:type',
      component: profile
    }, {
      path: '/profile',
      component: profile
    }, {
      path: '/login',
      component: login
    }, {
      path: '/404',
      component: sex
    }, {
      path: '*',
      redirect: '/index'
    }]
  });
};