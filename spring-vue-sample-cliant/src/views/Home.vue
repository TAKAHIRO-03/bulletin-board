<template>
  <div>
    <el-form ref="form" :model="form" label-width="150px">
      <div class="block">
        <el-date-picker
          v-model="form.filteringSearchBeforeDate"
          type="date"
          placeholder="Pick a day">
        </el-date-picker>
      </div>
        |
      <div class="block">
        <el-date-picker
          v-model="form.filteringSearchAfterDate"
          type="date"
          placeholder="Pick a day">
        </el-date-picker>
      </div>
      <el-form-item label="カテゴリ">
        <el-input v-model="form.confirmPassword"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="searchMessage">絞り込み</el-button>
      </el-form-item>
    </el-form>

    <div v-for="message in messages" :key="message" class="text item">
      <el-card class="box-card">
        <div class="message">
          <div>
            {{ 'ユーザー名:' + message.userId }}
          </div>
          <div>
            {{ 'タイトル:' + message.title }}
          </div>
          <div>
            {{ 'カテゴリ:' + message.category }}
          </div>
          <div>
            {{ '投稿内容:' + message.text }}
          </div>
          <div>
            {{ '投稿日時:' + message.createdDate }}
          </div>
          <el-button type="primary" @click="searchMessage">削除</el-button>
        </div>
        <div class="comment">
          コメントだよ
        </div>
      </el-card>
      <el-form ref="form" :model="form" label-width="150px">
        <el-form-item label="コメント">
            <el-input type="textarea"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="searchMessage">コメント</el-button>
        </el-form-item>
      </el-form>
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
        messages:[],
      }
    },
    created: async function () {
      this.searchMessage();
    },
    methods: {
      searchMessage: async function () {
         const res = await axios.get('http://localhost:8888/messages');
         this.messages = res.data.messages;
      },
    }
  }
</script>