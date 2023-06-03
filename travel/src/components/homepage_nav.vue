<template>
    <nav class="sm:px-16 px-6 w-full flex items-center py-5 fixed top-0 z-20 bg-white">
        <img src="../assets/logo.svg" class="w-9 h-9 object-contain mr-5"/>
        <div class="w-full flex items-center max-w-7xl mx-auto" @click="returnhome">
            <p class='text-black text-[18px] font-bold cursor-pointer flex '>
                TripGuide &nbsp;
                <span class='sm:block hidden'> | Your trip assistant</span>
            </p>
        </div>
        <el-divider direction="vertical" />
<!--        <img src="../assets/vue.svg" class="w-9 h-9 object-contain mr-5 float-right" v-show="isLogin"/>-->
        <div class="mx-2" v-show="isLogin">
            <el-popover
                    :width="300"
                    popper-style="box-shadow: rgb(14 18 22 / 35%) 0px 10px 38px -10px, rgb(14 18 22 / 20%) 0px 10px 20px -15px; padding: 20px;"
            >
                <template #reference>
                    <el-avatar src="https://avatars.githubusercontent.com/u/72015883?v=4" />
                </template>
                <template #default>
                    <div
                            class="demo-rich-conent"
                            style="display: flex; gap: 16px; flex-direction: column"
                    >
                        <el-avatar
                                :size="60"
                                src="https://avatars.githubusercontent.com/u/72015883?v=4"
                                style="margin-bottom: 8px"
                        />
                        <div>
                            <p
                                    class="demo-rich-content__name"
                                    style="margin: 0; font-weight: 500"
                            >
                                欢迎回来， Administrator
                            </p>
                            <p
                                    class="demo-rich-content__mention"
                                    style="margin: 0; font-size: 14px; color: var(--el-color-info)"
                            >
                                @普通用户
                            </p>
                        </div>

                        <p class="demo-rich-content__desc" style="margin: 0">
                            我们一直都在现实的泥淖中踯躅，不知何时能够步上新的旅途。
                        </p>
                    </div>
                </template>
            </el-popover>
        </div>
        <p class="font-bold" v-show="isLogin">{{logUser}}</p>
        <el-button type="primary" v-show="!isLogin" @click="handleLogin">
            登录 / 注册
        </el-button>
    </nav>
</template>

<script>
    export default {
        name: "homepage_nav",
        props:['isLogin'],
        data() {
            return {
                logUser: "Administrator",
                isLogin: false
            }
        },
        methods: {
            returnhome() {
                this.$router.replace('/homepage')
            },
            handleLogin() {
                console.log("Clicked.")
                // this.$router.replace('/login')
                this.isLogin = true
            }
        }
    }
</script>

<style scoped>

</style>