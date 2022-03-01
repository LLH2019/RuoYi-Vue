<template>
<div>
  <div>
    <el-card class="card">
      <img src="../../../assets/images/images.jpg" class="image">
      <div style="padding: 14px;">
        <span>机械加工</span>
        <div class="bottom clearfix">
          <time class="time">{{ currentDate }}</time>
          <el-button type="text" class="button">更多</el-button>
        </div>
      </div>
    </el-card>


  </div>

  <div class="block">            
	<el-pagination            
	@size-change="handleSizeChange"            
	@current-change="handleCurrentChange"            
	:current-page="current_page"            
	:page-sizes="[4,8, 12, 16]"             
	:page-size="pagesize"                     
	layout="total, sizes, prev, pager, next"            
	:total="total">                
	</el-pagination>          
</div> 
</div>
</template>


<script>

export default {
  name:'index'
}
</script>


<style>
    .card {
        width: 500px;
        padding: 20px；
    }
  .time {
    font-size: 13px;
    color: #999;
  }
  
  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }
  
  .clearfix:after {
      clear: both
  }
</style>

<script>
export default {
  data() {
    return {
      currentDate: new Date()
    };
  }
}
</script>
