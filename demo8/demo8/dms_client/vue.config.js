// vue.config.js
module.exports = {
    devServer: {
        port: 8087,
        proxy: { // 配置代理信息
            '/api': {
                target: 'http://localhost:8080',
                changeOrigin: true,
                ws: true,
                pathRewrite: {
                    '^/api': '/'
                }
            }
        }
    }
}