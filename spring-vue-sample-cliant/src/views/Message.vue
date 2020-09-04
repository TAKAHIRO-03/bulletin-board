<template>
  <div>
    <div class="flash" v-if="show === true">
      {{ message }}
    </div>
    <el-form ref="form" :model="form" label-width="150px">
        <el-form-item label="件名">
            <el-input v-model="form.title"></el-input>
        </el-form-item>
        <el-form-item label="カテゴリ">
            <el-input v-model="form.category"></el-input>
        </el-form-item>
        <el-form-item label="投稿内容">
            <el-input type="textarea" v-model="form.text"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addMessage">投稿</el-button>
        </el-form-item>
    </el-form>
  </div>
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
          text: undefined,
        },
        show: false,
        message: undefined
      }
    },
    created: async function () {
    },
    methods: {
      addMessage: async function () {
       const res = await axios.post('http://localhost:8888/messages', this.form).catch(error => {
          console.log(error);
          this.message = "メッセージ作成に失敗しました";
        });

        if(res){
          this.message = "メッセージ作成に成功しました";
        } 

        this.show = true;
        setTimeout(() => {
          this.show = false}
          ,3000
        );
      },
    }
  }
</script>