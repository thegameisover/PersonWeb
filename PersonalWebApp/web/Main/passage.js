// @ts-ignore
const Passage = Vue.extend({
    template: `
    <div id="passageBG">
    <div id="passage" @click="Read">
    <img v-bind:src="url" style="float:left" width='100px' />
    {{content}}
    </div>
    <div style="clear:both"></div>
    <div>
    <span class="span"><i class="el-icon-user-solid"></i>作者:{{writer}}</span>
    <span class="span"><i class="el-icon-date"></i>发布日期:{{date}}</span>
    <span class="span"><i class="el-icon-reading"></i>浏览次数:{{num}}</span>
    <span class="span"><i class="el-icon-s-comment"></i>评论数量:{{comment}}</span></div>
    </div>`,
    data() {
        return {
            content: '',
            writer: '',
            date: '',
            num: '',
            comment: '',
            url: '',
        }
    },
    methods: {
        fuzhi() {

            this.$data.content = this.$root.show[this.$root.passageNum].content;
            this.$data.writer = this.$root.show[this.$root.passageNum].writer;
            this.$data.date = this.$root.show[this.$root.passageNum].date;
            this.$data.num = this.$root.show[this.$root.passageNum].num;
            this.$data.comment = this.$root.show[this.$root.passageNum].comment;
            if (this.$root.show[this.$root.passageNum].url == "null") {

            } else {
                this.$data.url = "../../passage/passagePicture/" + this.$root.show[this.$root.passageNum].url;
            }

            this.$root.passageNum = this.$root.passageNum + 1;
        },

        Read() {
            console.log(this.$data.content);
            window.open("../Reading/reading.html?" + this.$data.content);
            axios({
                method: "get",
                url: "http://127.0.0.1:8080/num?name=" + this.$data.content,
            })
        }

    },

})