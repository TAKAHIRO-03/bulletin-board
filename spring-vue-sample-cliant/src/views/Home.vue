<template>
  <div>
    <el-form ref="searchForm" :model="searchForm" label-width="150px">
      <div class="block">
        <el-date-picker
          v-model="searchForm.filteringSearchBeforeDate"
          type="date"
          placeholder="Pick a day">
        </el-date-picker>
      </div>
        |
      <div class="block">
        <el-date-picker
          v-model="searchForm.filteringSearchAfterDate"
          type="date"
          placeholder="Pick a day">
        </el-date-picker>
      </div>
      <el-form-item label="カテゴリ">
        <el-input v-model="searchForm.confirmPassword"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="searchMessage">絞り込み</el-button>
      </el-form-item>
    </el-form>

    <div v-for="(message, index) in messages" :key="index" class="text item">
      <el-card class="box-card">
        <div class="message">
          <div>
            {{ 'ユーザー名:' + message.user.name }}
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
          <div>
            <el-button type="primary" @click="deleteMessage">削除</el-button>
          </div>
        </div>
        <br>
        <div v-for="(comment, index) in comments" :key="index">
          <div v-if="comment.messageId == message.id">
            <div>
              {{ 'ユーザー名:' + comment.user.name }}
            </div>
            <div>
              {{ 'コメント内容:' + comment.text }}
            </div>
            <div>
              {{ 'コメント日時:' + comment.createdDate }}
            </div>
            <div>
              <el-button type="primary" @click="deleteComment(comment.id)">コメント削除</el-button>
            </div>
            <br>
          </div>
        </div>
      </el-card>
      <el-form :model="commentForms[index]" label-width="150px">
        <el-form-item label="コメント">
            <el-input type="textarea" v-model="commentForms[index].text"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addComment(index)">コメント</el-button>
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
        searchForm: {
          filteringSearchBeforeDate: undefined,
          filteringSearchAfterDate: undefined,
          category: undefined,
        },
        commentForms:[],
        messages:[],
        comments:[],
      }
    },
    created: async function () {
      this.refresh();
    },
    methods: {
      refresh: async function () {
        this.searchMessage();
        this.getComments();
      },
      searchMessage: async function () {
         const res = await axios.get('http://localhost:8888/messages');
         const messages = res.data.messages;
         this.messages = messages;

         for(let i = 0, length = messages.length; i < length; i++){
           let commentForm = {
            text: '',
            messageId: messages[i].id,
           }
          this.$set(this.commentForms, i, commentForm);
         }
      },
      deleteMessage: async function (id) {
         await axios.delete('http://localhost:8888/message/' + id);
         await this.refresh();
      },
      getComments: async function () {
         const res = await axios.get('http://localhost:8888/comments');
         this.comments = res.data.comments;
      },
      addComment: async function (index) {
         await axios.post('http://localhost:8888/comments', this.commentForms[index]);
         await this.refresh();
      },
      deleteComment: async function (id) {
         await axios.delete('http://localhost:8888/comments/' + id);
         await this.refresh();
      },
    }
  }
</script>