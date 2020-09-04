<template>
    <el-card class="box-card login">
        <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="Name">
                <el-input v-model="form.account"></el-input>
            </el-form-item>
            <el-form-item label="Password">
                <el-input type="password" v-model="form.password"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button style="float: right" type="primary" @click="loginUser">Login</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>

  import axios from 'axios'

  export default {
    name: "Login",
    data () {
      return {
        form: {
          account: undefined,
          password: undefined,
        },
      }
    },
    created: async function () {
    },
    methods: {
      loginUser: async function () {
        await axios.post('http://localhost:8888/users', this.request)
        this.$router.push('/') 
      },
    }
  }
</script>