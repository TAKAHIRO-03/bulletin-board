<template>
    <el-form ref="form" :model="form" label-width="150px">
        <el-form-item label="件名">
            <el-input v-model="form.title"></el-input>
        </el-form-item>
        <el-form-item label="カテゴリ">
            <el-input v-model="form.category"></el-input>
        </el-form-item>
        <el-form-item label="投稿内容">
            <el-input type="textarea" v-model="form.content"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addMessage">投稿</el-button>
        </el-form-item>
    </el-form>
</template>

<script>

  import axios from 'axios'

  export default {
    name: "Signup",
    data () {
      return {
        form: {
          title: undefined,
          category: undefined,
          content: undefined,
        },
      }
    },
    created: async function () {
    },
    methods: {
      addMessage: async function () {
        await axios.post('http://localhost:8888/users', this.form)
        this.$router.push('currency') 
      },
    }
  }
</script>