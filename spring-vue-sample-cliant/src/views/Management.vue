<template>
    <el-card class="box-card">
        <span>アカウント：</span>
        <span>名無し</span>
        <br>
        <span>名前：</span>
        <span>名無し</span>
        <br>
        <span>支社：</span>
        <span>名無し</span>
        <br>
        <span>部署</span>
        <span>名無し</span>
        <br>
        <span>アカウント復活停止状態</span>
        <el-form ref="form" :model="form" label-width="150px">
            <el-form-item>
                <el-button type="primary" @click="searchMessage">編集</el-button>
                <el-button type="primary" @click="searchMessage">復活</el-button>
                <el-button type="primary" @click="searchMessage">停止</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>

  import axios from 'axios'

  export default {
    name: "Home",
    data () {
      return {
        form: {
          filteringSearchBeforeDate: undefined,
          filteringSearchAfterDate: undefined,
          category: undefined,
        },
      }
    },
    created: async function () {
    },
    methods: {
      searchMessage: async function () {
        await axios.post('http://localhost:8888/users', this.form)
        this.$router.push('currency') 
      },
    }
  }
</script>