<template>
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