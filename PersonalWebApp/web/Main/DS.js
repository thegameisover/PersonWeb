// @ts-ignore
const dsContent = Vue.extend({
    template: `
    <div>
    <div id="DSdaohang">
    <el-row class="tac" style="width: 200%;">
        <el-col :span="12">
            <el-menu default-active="2" class="el-menu-vertical-demo">
                <el-submenu index="1">
                    <template slot="title">
                <i class="el-icon-location"></i>
                <span>排序</span>
              </template>
                    <el-menu-item-group>
                        <el-menu-item index="1-1" @click="maopao">冒泡排序</el-menu-item>
                        <el-menu-item index="1-2" @click="xuanze">选择排序</el-menu-item>
                        <el-menu-item index="1-3" @click="charu">插入排序</el-menu-item>
                        <el-menu-item index="1-4" @click="xier">希尔排序</el-menu-item>
                        <el-menu-item index="1-5" @click="guibing">归并排序</el-menu-item>
                        <el-menu-item index="1-6" @click="kuaisu">快速排序</el-menu-item>
                        <el-menu-item index="1-7" @click="dui">堆排序</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>
                <el-submenu index="2">
                    <template slot="title">
                <i class="el-icon-location"></i>
                <span>查找</span>
              </template>
                    <el-menu-item-group>
                        <el-menu-item index="1-1">顺序查找</el-menu-item>
                        <el-menu-item index="1-2">二分查找</el-menu-item>
                        <el-menu-item index="1-3">散列表</el-menu-item>
                        <el-menu-item index="1-3">KMP算法</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>
                <el-submenu index="3">
                    <template slot="title">
                <i class="el-icon-location"></i>
                <span>树</span>
              </template>
                    <el-menu-item-group>
                    <el-submenu index="1-1">
                        <template slot="title">二叉树</template>
                        <el-menu-item index="1-1">二叉树的遍历</el-menu-item>
                        <el-menu-item index="1-2">二叉搜索树</el-menu-item>
                        <el-menu-item index="1-3">平衡二叉树</el-menu-item>
                    </el-submenu>
                    </el-menu-item-group>
                    <el-menu-item index="1-2">堆</el-menu-item>
                    <el-submenu index="1-3">
                        <template slot="title">哈夫曼树</template>
                        <el-menu-item index="1-1">哈夫曼树</el-menu-item>
                        <el-menu-item index="1-2">哈夫曼编码</el-menu-item>
                    </el-submenu>
                </el-submenu>
                <el-submenu index="4">
                    <template slot="title">
                <i class="el-icon-location"></i>
                <span>图</span>
              </template>
                    <el-submenu index="1-1">
                        <template slot="title">图的遍历</template>
                        <el-menu-item index="1-1">深度优先遍历（DFS）</el-menu-item>
                        <el-menu-item index="1-2">广度优先遍历（BFS）</el-menu-item>
                    </el-submenu>
                    <el-submenu index="1-2">
                        <template slot="title">最小生成树</template>
                        <el-menu-item index="1-1">普里姆（prime）</el-menu-item>
                        <el-menu-item index="1-2">克鲁斯卡尔（kluskal）</el-menu-item>
                    </el-submenu>
                    <el-submenu index="1-3">
                        <template slot="title">最短路径</template>
                        <el-menu-item index="1-1">迪杰斯特拉算法（Dijkstra）</el-menu-item>
                        <el-menu-item index="1-2">弗洛伊德算法（Floyd）</el-menu-item>
                    </el-submenu>
                    </el-submenu>
                    
            </el-menu>
        </el-col>
        </el-row>
</div>
<div id="show1">

<div id="DScontent">
<el-empty description="还未添加内容" id="el"></el-empty>
</div>
<div >
</div>
</div>
    </div>`,
    data() {
        return {

        }
    },
    methods: {
        maopao() {


        },
        xuanze() {

        },
        charu() {

        },
        xier() {

        },
        guibing() {

        },
        kuaisu() {

        },
        dui() {

        }


    },
})