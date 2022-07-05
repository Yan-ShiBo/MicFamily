new Vue({
    el: "#app",
    data: {
        message: "<h1>张三</h1>",
        use: false,
        ok: false,
        url: 'http://www.runoob.com',
        text: "mengsss"
    },
    methods: {
        reverseMessage: function () {
            this.text = this.text.split('').reverse().join('')
        }
    }
})