// @ts-ignore
const Note = Vue.extend({
    template: `
    <div>
    <div id="DSdaohang">
    <el-row class="tac" style="width: 200%;">
        <el-col :span="12">
            <el-menu default-active="2" class="el-menu-vertical-demo">
                <el-submenu index="1">
                    <template slot="title">
                <i class="el-icon-location"></i>
                <span>java</span>
              </template>
                    <el-submenu index="1-1">
                        <template slot="title">String类</template>
                        <el-menu-item index="1-1">常用String方法（DFS）</el-menu-item>
                    </el-submenu>
                    <el-submenu index="1-2">
                        <template slot="title">IO</template>
                        <el-menu-item index="1-1">字节流和字符流（DFS）</el-menu-item>
                        <el-menu-item index="1-2">字节缓冲流和字符缓冲流（BFS）</el-menu-item>
                        <el-menu-item index="1-2">File类</el-menu-item>
                        <el-menu-item index="1-2">字节缓冲流和字符缓冲流（BFS）</el-menu-item>
                        <el-menu-item index="1-2">打印流</el-menu-item>
                        <el-menu-item index="1-2">标准输入输出流</el-menu-item>
                        <el-menu-item index="1-2">对象序列化流</el-menu-item>
                    </el-submenu>
                    <el-submenu index="1-3">
                        <template slot="title">类集框架</template>
                        <el-menu-item index="1-1">Collection</el-menu-item>
                        <el-menu-item index="1-2">Map</el-menu-item>
                        <el-menu-item index="1-2">List</el-menu-item>
                        <el-menu-item index="1-2">Set</el-menu-item>
                        <el-menu-item index="1-2">ArrayList</el-menu-item>
                        <el-menu-item index="1-2">LinkedList</el-menu-item>
                        <el-menu-item index="1-2">HashSet</el-menu-item>
                        <el-menu-item index="1-2">TreeSet</el-menu-item>
                        <el-menu-item index="1-2">HashMap</el-menu-item>
                    </el-submenu>
                    <el-submenu index="1-4">
                        <template slot="title">异常</template>
                        <el-menu-item index="1-1">异常处理</el-menu-item>
                        <el-menu-item index="1-2">throws和throw关键字</el-menu-item>
                    </el-submenu>
                    <el-submenu index="1-5">
                        <template slot="title">反射</template>
                        <el-menu-item index="1-1">反射获取成员方法</el-menu-item>
                        <el-menu-item index="1-2">反射获取成员变量</el-menu-item>
                        <el-menu-item index="1-2">反射获取构造函数</el-menu-item>
                        <el-menu-item index="1-2">获取Class类对象</el-menu-item>
                    </el-submenu>
                    <el-submenu index="1-6">
                        <template slot="title">多线程</template>
                        <el-menu-item index="1-1">Runnable接口实现多线程</el-menu-item>
                        <el-menu-item index="1-2">Callable接口实现多线程</el-menu-item>
                        <el-menu-item index="1-2">Thread类实现多线程</el-menu-item>
                    </el-submenu>
                </el-submenu>



                <el-submenu index="2">
                    <template slot="title">
                <i class="el-icon-location"></i>
                <span>mysql</span>
              </template>
              <el-submenu index="1-1">
              <template slot="title">基本语句</template>
              <el-menu-item index="1-1">DDL</el-menu-item>
              <el-menu-item index="1-2">DCL</el-menu-item>
              <el-menu-item index="1-3">DQL</el-menu-item>
              <el-menu-item index="1-4">DML</el-menu-item>
              </el-submenu>
              <el-menu-item index="1-2">约束</el-menu-item>
                </el-submenu>



                <el-submenu index="3">
                    <template slot="title">
                <i class="el-icon-location"></i>
                <span>前端</span>
              </template>
              <el-submenu index="1-1">
              <template slot="title">JavaScript</template>
              <el-menu-item index="1-1">BOM</el-menu-item>
              <el-menu-item index="1-2">DOM</el-menu-item>
              </el-submenu>
              <el-submenu index="1-2">
              <template slot="title">HTML</template>
              </el-submenu>
              <el-submenu index="1-3">
              <template slot="title">CSS</template>
              </el-submenu>
                </el-submenu>



                <el-submenu index="4">
                    <template slot="title">
                <i class="el-icon-location"></i>
                <span>SSM</span>
              </template>
                    
                </el-submenu>
            </el-menu>
        </el-col>
</el-row>
</div>
<div id="show1">
    <div id="DScontent">
        <el-empty description="还未添加内容" id="el"></el-empty>
    </div>
</div>
    </div>`,
    data() {
        return {

        }
    },
})