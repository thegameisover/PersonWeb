const read = Vue.extend({
    template: `
<div id="paperWize">
<div id="title"><h1>{{Title}}</h1></div>
<div id="content">{{content}}</div>
<div id="text">{{textarea1}}</div>
<div style="clear:both"></div>
</div>

</div>
    `,
    data() {
        return {
            Title: '',
            content: '',
            textarea1: '',

        }
    },
    mounted() {
        var wize = document.getElementById("paperWize");
        wize.style.width = this.$root.width * 0.8 + "px";
    },
})