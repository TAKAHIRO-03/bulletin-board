<template>
  <div>
    <div v-for="(user, index) in users" :key="index" class="text item">
      <el-card class="box-card">
          <span>アカウント：</span>
          <span>{{ user.account }}</span>
          <br>
          <span>名前：</span>
          <span>{{ user.name }}</span>
          <br>
          <span>支社：</span>
          <span>{{ user.branch.name }}</span>
          <br>
          <span>部署</span>
          <span>{{ user.department.name }}</span>
          <br>
          <span>アカウント復活停止状態</span>
          <el-form ref="form" :model="form" label-width="150px">
              <el-form-item>
                  <router-link :to="{name: 'setting', query: {id: user.id}}">編集</router-link>
                  <!-- <el-button type="primary" @click="searchMessage">復活</el-button>
                  <el-button type="primary" @click="searchMessage">停止</el-button> -->
              </el-form-item>
          </el-form>
      </el-card>
    </div>
  </div>
</template>

<style>
  .text {
    font-size: 14px;
  }

  .item {
    padding: 18px 0;
  }

  .box-card {
    width: 480px;
  }
</style>


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
        users:[],
      }
    },
    created: async function () {
      this.refresh();
    },
    methods: {
      refresh: async function () {
        this.getUsers();
      },
      getUsers: async function () {
       const res = await axios.get('http://localhost:8888/users');
       this.users = res.data.users;
      },
    }
  }
</script>