<template>
    <div class="card-container absolute inset-0 top-[200px]">
        <div class="card">
            <div class="tabs">
                <div class="tab" @click="activeTab = 'flight'">
                    <span :class="{ active: activeTab === 'flight' }">航班搜索</span>
                </div>
                <div class="tab" @click="activeTab = 'train'">
                    <span :class="{ active: activeTab === 'train' }">火车搜索</span>
                </div>
                <div class="tab" @click="activeTab = 'hotel'">
                    <span :class="{ active: activeTab === 'hotel' }">住宿搜索</span>
                </div>
            </div>
            <div class="card-body">
                <div v-show="activeTab === 'flight'">
                    <el-date-picker
                            v-model="dateRange"
                            type="daterange"
                            range-separator="To"
                            start-placeholder="Start date"
                            end-placeholder="End date"
                            :size="size"
                            class="my-5"
                    />
                    <button class="search_btn mx-5 motion-safe:hover:scale-110">搜索</button>
                </div>
                <div v-show="activeTab === 'train'">
                    <el-date-picker
                            v-model="dateRange"
                            type="daterange"
                            range-separator="To"
                            start-placeholder="Start date"
                            end-placeholder="End date"
                            :size="size"
                            class="my-5"
                    />
                    <button class="search_btn mx-5 motion-safe:hover:scale-110">搜索</button>
                </div>
                <div v-show="activeTab === 'hotel'">
                    <el-date-picker
                            v-model="dateRange"
                            type="daterange"
                            range-separator="To"
                            start-placeholder="Start date"
                            end-placeholder="End date"
                            :size="size"
                            class="my-5"
                    />
                    <button class="search_btn mx-5 motion-safe:hover:scale-110">搜索</button>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        name: "homepage_search",
        data() {
            // const dateRange = ref('')
            return {
                activeTab: 'flight',
                dateRange: []
            };
        }
    };
</script>
<style>
    .card-container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .card {
        background-color: #ffffff;
        border-radius: 8px;
        box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
        width: 600px;
    }
    .tabs {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 16px;
        border-bottom: 1px solid #e5e5e5;
    }
    .tab {
        cursor: pointer;
        padding: 8px;
        border-radius: 4px;
        transition: all 0.2s ease-in-out;
    }
    .tab:hover {
        background-color: #f5f5f5;
    }
    .tab span {
        font-size: 16px;
        color: #999999;
    }
    .tab span.active {
        color: #3f88c5;
        font-weight: bold;
    }
    .card-body {
        padding: 16px;
    }
    .search_btn {
        background-color: #CCE5FF;
        color: black;
        border-radius: 20px;
        padding: 8px 16px;
        font-size: 14px;
        transition: transform 0.2s ease-in-out;
    }
</style>

