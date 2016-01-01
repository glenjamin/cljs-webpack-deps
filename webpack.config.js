var path = require('path');

module.exports = {
  entry: "./src/webpack-deps.js",
  externals: {
    "react": "React",
    "react-dom": "ReactDOM",
  },
  output: {
    path: path.join(__dirname, "resources/public/js/compiled/"),
    library: 'webpack-deps',
    libraryTarget: 'this'
  }
};
