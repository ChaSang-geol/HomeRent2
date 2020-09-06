<template>
    <div class="input-group date" style="width:150px;">
        <input type="text" class="form-control" v-model="date" />
        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
    </div>
</template>
<script>
import '/dist/js/vue-bootstrap-datetimepicker@5.js';
export default {
     name: 'date-picker',
     props: {
      date: String
     },
     mounted: function() {
      var that = this;
      $(this.$el).datepicker({
          'autoclose':true,
          'minViewMode':0, //day까지 선택할수 있게 선언
          'maxViewMode':2,
          'format':'yyyy-mm-dd' //날짜 포맷
      }).on('changeDate', function(e){
       var year = e.date.getFullYear();
       var month = e.date.getMonth() + 1;
       if(month < 10) month = '0' + month;
       var day = e.date.getDate();
       that.$emit('change',String(year)+'-'+String(month)+'-'+day);
      });
     },
     updated: function(){
      $(this.$el).datepicker('update', this.date);
     }
}
</script>