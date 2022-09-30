const writer = Vue.extend({
    template: `
    <div id="writeBG">
     <div id="writer">
        <div id="top">
        <div id="Border">
        <img :src="imageUrl" id="picture"/>
        <i class="el-icon-plus" id="icon"></i>
        </div>
        <a href="javascript:;" class="file" >可添加一张图片 <input type="file" @change="tirggerFile($event)"></a>
        </div>
        <div id="down">
        <table>
        <tr>
        <td><h3>标题:</h3></td>
        <td>
        <input type="text" id="titlePassage"/>
        </td>
        </tr>
        <tr>
        <td><h3>导读:</h3></td>
        <td><textarea id="area"></textarea></td>
        </tr>
        </table>
        <textarea id="passageContent"></textarea>
        <div>
        <el-row>
        <el-button type="primary" id="upLoad" @click="upLoad">上传</el-button>
        <el-button type="danger" id="Cancel" @click="Back">取消</el-button>
        </el-row>
        </div>
        </div>
     </div>
    </div>
    `,
    data() {
        return {
            imageUrl: '',
            Picture: '',
            PictureData: 'null',
        }
    },
    methods: {
        tirggerFile($event) {
            _this = this;
            let files = $event.target.files[0];
            var pettern = /^image/;
            if (!pettern.test(files.type)) {
                alert("图片格式不正确");
                return;
            }
            var reader = new FileReader();
            reader.readAsDataURL(files); //异步读取文件内容，结果用data:url的字符串形式表示
            /*当读取操作成功完成时调用*/
            reader.onload = function(e) {
                //console.log(e); //查看对象
                console.log(reader.result); //要的数据 这里的this指向FileReader（）对象的实例reader
                _this.$data.PictureData = reader.result;
            }
            var picture = document.getElementById("picture");
            var icon = document.getElementById("icon");
            icon.style.display = "none";
            picture.style.width = "100%";
            picture.style.height = "100%";
            this.imageUrl = this.getObjectURL(files);
        },
        getObjectURL(file) {
            let url = null;
            if (window.createObjectURL != undefined) {
                url = window.createObjectURL(file);
            } else if (window.webkitURL != undefined) {
                url = window.webkitURL.createObjectURL(file);
            } else if (window.URL != undefined) {
                url = window.URL.createObjectURL(file);
            }
            return url;
        },

        Back() {
            var p = document.getElementsByClassName("writerShow");
            p[0].style.display = "none";
        },

        upLoad() {
            const date = new Date();
            var title = document.getElementById("titlePassage");
            var daodu = document.getElementById("area");
            var content = document.getElementById("passageContent");
            var json = {
                "picture": this.$data.PictureData,
                "title": title.value,
                "introduction": daodu.value,
                "content": content.value,
                "writer": this.$root.UserName,
                "writerDate": date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate(),
                "mark": "1"
            }

            var p = JSON.stringify(json);
            var xhr = new XMLHttpRequest();
            xhr.open("post", "http://127.0.0.1:8080/load");
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.withCredentials = true;
            xhr.send(p);
            xhr.onreadystatechange = function() {
                    if (xhr.readyState === 4) {
                        if (xhr.status >= 200 & xhr.status < 300) {
                            if (xhr.responseText == "1") {
                                alert("上传成功");
                                location.href = "../Main/main.html";
                            } else {
                                alert("上传失败");
                            }
                        }
                    }
                }
                /*axios({
                    method: "post",
                    url: "http://127.0.0.1:8080/load",
                    data: JSON.stringify(json),
                }).then(function(resp) {
                    if (resp.data == "1") {
                        alert("上传成功");
                    } else {
                        alert("上传失败");
                    }
                })*/
        }
    },
    mounted() {
        var writer = document.getElementById("writer");
        var Border = document.getElementById("Border");
        writer.style.width = this.$root.width * 0.6 + 'px';
        Border.style.height = this.$root.height * 0.2 + 'px';
    },


})