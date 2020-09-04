<template>
    <el-form ref="form" :model="form" label-width="150px">
        <el-form-item label="アカウント名">
            <el-input v-model="form.account"></el-input>
        </el-form-item>
        <el-form-item label="パスワード">
            <el-input v-model="form.password"></el-input>
        </el-form-item>
        <el-form-item label="確認用パスワード">
            <el-input v-model="form.confirmPassword"></el-input>
        </el-form-item>
        <el-form-item label="名前">
            <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="支社">
            <el-select v-model="form.branch" placeholder="支社を選択してください">
                <el-option v-for="branch in branches" :key="branch.id" :label="branch.name" :value="branch"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="部署">
            <el-select v-model="form.department" placeholder="部署を選択してください">
                <el-option v-for="department in departments" :key="department.id" :label="department.name" :value="department"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="updateUser(form.id)">更新</el-button>
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
          id: undefined,
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
      this.refresh();
    },
    methods: {
      refresh: async function () {
        this.getUser();
        this.getDepartments();
        this.getBranches();
      },
      getBranches: async function () {
        const res = await axios.get('http://localhost:8888/branches')
        this.branches = res.data.branches;
      },
      getDepartments: async function () {
        const res = await axios.get('http://localhost:8888/departments')
        this.departments = res.data.departments;
      },
      updateUser: async function () {
        await axios.patch('http://localhost:8888/users/' + this.$route.query.id , this.form);
        this.$router.push('management');
      },
      getUser: async function () {
        const res = await axios.get('http://localhost:8888/users/' + this.$route.query.id);
        const user = res.data.user;
        this.$set(this.form, 'id', user.id);
        this.$set(this.form, 'account', user.account);
        this.$set(this.form, 'name', user.name);
        this.$set(this.form, 'branch', user.branch);
        this.$set(this.form, 'department', user.department);
      },
    }
  }
</script>