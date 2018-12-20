// "webpack": "^1.13.2",
// "webpack-dev-server": "^1.16.2"
var path = require('path');
var webpack = require('webpack');
var fs = require('fs');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var vpsPath = path.resolve(__dirname, '../');

// package.json
var pg = fs.readFileSync(vpsPath + '/package.json');
var pjInfo = JSON.parse(pg);

var paths = {
  src: vpsPath + '/src/',
  dist: vpsPath + '/dist/' + pjInfo.version + '/'
};

var publicPath = '/resources/dist/' + pjInfo.version + '/';

module.exports = {
  entry: {
    'business/index/index': paths.src + 'business/index/app.js'
  },
  output: {
    path: paths.dist,
    publicPath: publicPath,
    chunkFilename: 'chunks/[name].chunk.js',
    filename: '[name].js'
  },
  resolve: {
    extensions: ['.js', '.vue', '.styl'],
    modules: [
      paths.src,
      'node_modules'
    ]
  },
  module: {
    rules: [{
      test: /\.vue$/,
      loader: 'vue-loader'
    }, {
      test: /\.js$/,
      loader: 'babel-loader',
      exclude: /node_modules|vue\/dist|vue-router\/|vue-loader\/|vue-hot-reload-api\//,
      options: {
        presets: [['es2015', {
          loose: true
        }]],
        plugins: ['transform-vue-jsx']
      }
    }, {
      test: /\.(png|jpg|gif)$/,
      loader: 'url-loader',
      options: {
        limit: 1500,
        name: 'images/[name].[ext]?[hash]'
      }
    }, {
      test: /\.(woff|ttf)$/,
      loader: 'url-loader',
      options: {
        limit: 1500,
        name: 'fonts/[name].[ext]?[hash]'
      }
    }, {
      test: /\.css$/,
      loader: 'css-loader',
      options: {
        minimize: true
      }
    }, {
      test: /\.styl$/,
      use: ExtractTextPlugin.extract([{
        loader: 'css-loader',
        options: {
          minimize: true
        }
      }, 'stylus-loader'])
    }]
  },
  devtool: process.env.NODE_ENV === 'production' ? '#source-map' : '#eval-source-map',
  devServer: {
    compress: true,
    historyApiFallback: true,
    hot: true,
    https: false,
    port: 8833,
    inline: true // 实时刷新
  },
  watchOptions: {
    aggregateTimeout: 300,
    poll: 1000
  },
  plugins: [
    new webpack.DefinePlugin({
      'process.env': {
        NODE_ENV: process.env.NODE_ENV === 'production' ? '"production"' : '"development"'
      }
    }),
    new webpack.optimize.UglifyJsPlugin({
      sourceMap: true,
      compress: {
        warnings: false
      }
    }),
    new ExtractTextPlugin('[name].css')
  ]
}