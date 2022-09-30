// @ts-ignore
const head = Vue.extend({
    template: `
    <div>
    <div class="head" id="headOne">
    <ul>
    <li :style="li1"><img src="pat.png" width="90%" /></li>
    </ul>
    </div>
    <div class="head" id="headCenter">
    本网站已经运营{{days}}天
    </div>
    <div class="head" id="headLast">
    <img src="1.jpg" width="40%" @click="click1"/>
    <img src="../logup/2.jpg" width="40%" @click="click2"/>
    <img src="../Login/1.jpg" width="40%" @click="click3"/>
    <img src="4.jpg" width="40%" @click="click4"/>
    </div>
    <div style="clear:both"></div>
    </div>`,
    data() {
        return {
            days: '1',
            li1: {
                display: 'block',
            },
            li2: {
                display: 'none',
            },
            li3: {
                display: 'none',
            },
            li4: {
                display: 'none',
            },
        }
    },
    methods: {

        click1() {
            var x = document.getElementById("body");
            x.style.backgroundImage = "url('1.jpg')";
            var xhr = new XMLHttpRequest();
            xhr.open("get", "http://127.0.0.1:8080/BG?name=" + this.$root.UserName + "&bg=1.jpg", true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.withCredentials = true;
            xhr.send();

        },
        click2() {
            var x = document.getElementById("body");
            x.style.backgroundImage = "url('../logup/2.jpg')";
            var xhr = new XMLHttpRequest();
            xhr.open("get", "http://127.0.0.1:8080/BG?name=" + this.$root.UserName + "&bg=2.jpg", true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.withCredentials = true;
            xhr.send();

        },
        click3() {
            var x = document.getElementById("body");
            x.style.backgroundImage = "url('../Login/1.jpg')";
            var xhr = new XMLHttpRequest();
            xhr.open("get", "http://127.0.0.1:8080/BG?name=" + this.$root.UserName + "&bg=3.jpg", true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.withCredentials = true;
            xhr.send();
        },
        click4() {
            var x = document.getElementById("body");
            x.style.backgroundImage = "url('4.jpg')";
            var xhr = new XMLHttpRequest();
            xhr.open("get", "http://127.0.0.1:8080/BG?name=" + this.$root.UserName + "&bg=4.jpg", true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.withCredentials = true;
            xhr.send();
        }
    },
    mounted() {
        const date = new Date();
        var p = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate()
        console.log(p);
        const date1_timeStamp = new Date("2022-9-17") - 0;
        const date2_timeStamp = new Date(p) - 0;
        let max = '',
            min = ''
        if (date1_timeStamp > date2_timeStamp) {
            max = date1_timeStamp
            min = date2_timeStamp
        } else {
            max = date2_timeStamp
            min = date1_timeStamp
        }
        this.$data.days = (max - min) / (24 * 60 * 60 * 1000);

    }


})