<template>
    <el-form ref="request" :model="request" label-width="150px">
        <el-form-item label="アカウント名">
            <el-input v-model="request.account"></el-input>
        </el-form-item>
        <el-form-item label="パスワード">
            <el-input v-model="request.password"></el-input>
        </el-form-item>
        <el-form-item label="確認用パスワード">
            <el-input v-model="request.confirmPassword"></el-input>
        </el-form-item>
        <el-form-item label="名前">
            <el-input v-model="request.name"></el-input>
        </el-form-item>
        <el-form-item label="支社">
            <el-select v-model="request.branch" placeholder="支社を選択してください">
                <el-option v-for="branch in branches" :key="branch.id" :label="branch.name" :value="branch.id"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="部署">
            <el-select v-model="request.department" placeholder="部署を選択してください">
                <el-option v-for="department in departments" :key="department.id" :label="department.name" :value="department.id"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addUser">Create</el-button>
          <el-button>Cancel</el-button>
        </el-form-item>
    </el-form>
</template>

<script>

  import axios from 'axios'

  export default {
    name: "User",
    data () {
      return {
        request: {
          account: undefined,
          password: undefined,
          confirmPassword: undefined,
          name: undefined,
          branch: undefined,
          department: undefined,
        },
        branches: [],
        departments: [],
      }
    },
      created: async function () {
      await this.getDepartments();
      await this.getBranches();
    },
    methods: {
      getBranches: async function () {
        const res = await axios.get('http://localhost:8888/branches')
        this.branches = res.data.branches
      },
      getDepartments: async function () {
        const res = await axios.get('http://localhost:8888/departments')
        this.departments = res.data.departments
      },
      addUser: async function () {
        await axios.post('http://localhost:8888/users', this.request)
        await this.refresh()
      },
      deleteUser: async function (id) {
        await axios.delete('http://localhost:8888/users/' + id)
        await this.refresh()
      },
    }
  }
</script>