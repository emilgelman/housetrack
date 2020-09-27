module.exports = {
    devtool: 'source-map',
    module: {
        rules: [{
            test: /\.(js|jsx)$/,
            exclude: /node_modules/,
            loader: "babel-loader",
            options: {
                presets: [
                    [
                        '@babel/preset-env',
                        {
                            targets: {
                                esmodules: true
                            }
                        }
                    ],
                    '@babel/preset-react'
                ]
            }
        }]
    },
    resolve: {
        extensions: ['.js', '.jsx']
    }
};