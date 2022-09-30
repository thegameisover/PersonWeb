const picture = Vue.extend({
    template: `
    <div>
    <template>
      <el-row class="demo-avatar demo-basic" id="userPicture">
        <el-col :span="12">
            <div class="demo-basic--circle">
                <div class="block"><el-avatar :size="100" :src="circleUrl"></el-avatar></div>
            </div>
        </el-col>  
      </el-row>
    </template>
    </div>
    `,
    data() {
        return {
            circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
        }
    }
})