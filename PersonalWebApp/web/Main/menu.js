// @ts-ignore
const menuBar = Vue.extend({
    template: `
    <div>
    <div :class="Class1" :style="kuan" @mouseover="MouseOver1($event)" @mouseleave="MouseLeave1($event)"  @click="Homeclick">{{Menu1}}</div>
    <div :class="Class2" :style="kuan" @mouseover="MouseOver2($event)" @mouseleave="MouseLeave2($event)" @click="Dsclick">{{Menu2}}</div>
    <div :class="Class3" :style="kuan" @mouseover="MouseOver3($event)" @mouseleave="MouseLeave3($event)" @click="Noteclick">{{Menu3}}</div>
    <div style="float:left">
    <input type="text" id="Search"/>
    <i class="el-icon-search" id="search" @click="Search"></i>
    </div>
    <div id="title">{{title}}</div>
    <div :class="Class4" :style="kuan" @mouseover="MouseOver4($event)" @mouseleave="MouseLeave4($event)" @click="Store">{{store}}</div>
    <div id="user" :style="kuan" @click='login'><i class="el-icon-user"></i>{{user}}</div>
    <div id="setting" :style="userHome">
    <ul >
    <li @click="Store"><i class="el-icon-s-home"></i>{{homepage}}</li>
    <li @click="WriterPassage"><i class="el-icon-edit"></i>{{writer}}</li>
    <li @click="Exit">{{exit}}</li>
    </ul>
    </div>
    <div style="clear:both"></div>
    </div>`,
    data() {
        return {
            Menu1: '首页',
            Menu2: '数据结构',
            Menu3: '学习笔记',
            title: '欢迎来到井底之蛙的个人博客',
            store: '资源仓库',
            user: '登录 或 注册',
            homepage: '个人主页',
            writer: '写文章',
            exit: '退出登录',

            Class1: { menu: true, mouseOver1: false },
            Class2: { menu: true, mouseOver2: false },
            Class3: { menu: true, mouseOver3: false },
            Class4: { menu: true, mouseOver4: false },
            kuan: {
                width: '',
            },
            userHome: {
                display: 'none'
            }
        }
    },
    methods: {

        MouseOver1(event) {
            this.$data.Class1.mouseOver1 = true;
        },
        MouseLeave1(event) {
            this.$data.Class1.mouseOver1 = false;
        },
        MouseOver2(event) {
            this.$data.Class2.mouseOver2 = true;
        },
        MouseLeave2(event) {
            this.$data.Class2.mouseOver2 = false;
        },
        MouseOver3(event) {
            this.$data.Class3.mouseOver3 = true;
        },
        MouseLeave3(event) {
            this.$data.Class3.mouseOver3 = false;
        },
        MouseOver4(event) {
            this.$data.Class4.mouseOver4 = true;
        },
        MouseLeave4(event) {
            this.$data.Class4.mouseOver4 = false;
        },

        Homeclick() {
            this.$root.homePage = true;
            this.$root.ds = false;
            this.$root.note = false;
            var p = document.getElementById("UL");
            p.style.display = "block";
        },
        Dsclick() {
            this.$root.homePage = false;
            this.$root.ds = true;
            this.$root.note = false;
            var p = document.getElementById("UL");
            p.style.display = "none";
        },
        Noteclick() {
            this.$root.homePage = false;
            this.$root.ds = false;
            this.$root.note = true;
            var p = document.getElementById("UL");
            p.style.display = "none";
        },
        login() {

            if (this.$data.user == "登录 或 注册") {
                location.href = "../Login/login.html";
            } else {
                if (this.$data.userHome.display == "none") {
                    this.$data.userHome.display = 'block';
                } else {
                    this.$data.userHome.display = 'none';
                }
            }


        },

        WriterPassage() {
            var p = document.getElementsByClassName("writerShow");
            p[0].style.display = "block";
            this.$data.userHome.display = 'none';
        },

        Search() {
            var p = document.getElementById("Search");
            window.open("../Search/search.html?" + p.value);
        },
        Exit() {
            alert("自行删除浏览器下的cookie");
        },
        Store() {
            alert("功能还未实现");
        }

    },
    mounted() {
        var p = this.$root.width * 0.1 + "px";
        this.$data.kuan.width = p;
    },
})