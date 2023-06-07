import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  // 配置多个代理
  server: {
    proxy: {
      '/api': {//反向代理的请求名
        target: "https://localhost:8080/loging",//此处写后端地址
        changeOrigin: true,//默认是false,当为true时可以将当前ip改为目标url，故启用该功能
        rewrite: path => path.replace(/^\/api/,'')//重写url，注意一定要和请求名一致
      }
    }
  }
})
