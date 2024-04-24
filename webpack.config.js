const path = require('path');

module.exports = {
	entry: './client/src/main.js',
	output: {
		path: path.resolve(__dirname, './client/public/build'),
		filename: 'main.bundle.js',
		publicPath: '/build/',
	},
	target: ['web', 'es5'],
	module: {
		rules: [
			{
				test: /\.js$/,
				exclude: /node_modules/, 
				use: {
					loader: 'babel-loader',
				},
			},
		],
	},
	devtool: 'source-map',
	devServer: {
		hot: false,
		static: {
			directory: './',
			watch: {
				ignored: 'node_modules',
			},
		},
		port: 8000,
		historyApiFallback: true,
	},
};