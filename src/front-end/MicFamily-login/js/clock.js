// index.js
const $clock = document.getElementById('clock');
const ctx = $clock.getContext('2d');
const x = 200, y = 200, r = 150;

window.requestAnimationFrame(function e() {
    ctx.clearRect(-10, 0, ctx.canvas.width, ctx.canvas.height);

    // 获取当前时间
    let date = new Date();
    let hours = date.getHours();
    let minutes = date.getMinutes();
    let seconds = date.getSeconds();
    hours = hours > 12 ? hours - 12 : hours;
    let hour = hours + minutes / 60;
    let minute = minutes + seconds / 60;
    ctx.save();

    //绘制表盘底色
    const lingrad = ctx.createLinearGradient(r, 0, -r, 0);
    lingrad.addColorStop(0, '#242f37');
    lingrad.addColorStop(1, '#48585c');
    ctx.fillStyle = lingrad;
    ctx.beginPath();
    ctx.arc(x, y, r, 0, Math.PI * 2, true);
    ctx.fill();

    ctx.translate(x, y); // 将坐标原点移到画布中心
    // 绘制时钟刻数
    for (let i = 0; i < 12; i++) {
        ctx.beginPath();
        ctx.strokeStyle = '#999';
        ctx.lineWidth = 3;
        ctx.rotate(Math.PI / 6);
        ctx.moveTo(r-10, 0);
        ctx.lineTo(r-30, 0);
        ctx.stroke();
    }

    // 绘制分钟刻数
    for (let i = 0; i < 60; i++) {
        if (i % 5 !== 0) { // 去掉与小时刻度重叠的部分
            ctx.beginPath();
            ctx.strokeStyle = '#536b7a';
            ctx.lineWidth = 2;
            ctx.moveTo(r-10, 0);
            ctx.lineTo(r-20, 0);
            ctx.stroke();
        }
        ctx.rotate(Math.PI / 30);
    }

    // 绘制时钟数字
    ctx.font = '20px Arial';
    ctx.fillStyle = '#aaa';
    ctx.textAlign = 'center';
    ctx.textBaseline = 'middle';
    for (let n = 1; n <= 12; n++) {
        const theta = (n - 3) * (Math.PI * 2) / 12;
        const x = r * 0.7 * Math.cos(theta);
        const y = r * 0.7 * Math.sin(theta);
        ctx.fillText(n, x, y);
    }

    // 绘制时针
    ctx.save();
    const thetaH = (hour - 3) * 2 * Math.PI / 12;
    ctx.rotate(thetaH);
    ctx.beginPath();
    ctx.moveTo(-15, -5);
    ctx.lineTo(-15, 5);
    ctx.lineTo(r * 0.5, 1);
    ctx.lineTo(r * 0.5, -1);
    ctx.fillStyle = '#555';
    ctx.fill();
    ctx.restore();

    // 绘制分针
    ctx.save();
    const thetaMin = (minute - 15) * 2 * Math.PI / 60;
    ctx.rotate(thetaMin);
    ctx.beginPath();
    ctx.moveTo(-15, -4);
    ctx.lineTo(-15, 4);
    ctx.lineTo(r * 0.8, 1);
    ctx.lineTo(r * 0.8, -1);
    ctx.fillStyle = '#666';
    ctx.fill();
    ctx.restore();

    // 绘制秒针
    ctx.save();
    const thetaS = (seconds - 15) * 2 * Math.PI / 60;
    ctx.rotate(thetaS);
    ctx.beginPath();
    ctx.moveTo(-15, -3);
    ctx.lineTo(-15, 3);
    ctx.lineTo(r * 0.9, 1);
    ctx.lineTo(r * 0.9, -1);
    ctx.fillStyle = '#F66';
    ctx.fill();
    ctx.restore();

    ctx.restore();

    ctx.beginPath();
    ctx.arc(x, y, 5, 0, Math.PI*2, true);
    ctx.fillStyle = '#F66';
    ctx.fill();

    // 阴影的x偏移
    ctx.shadowOffsetX = -14;
    // 阴影的y偏移
    ctx.shadowOffsetY = 6;
    // 阴影颜色
    ctx.shadowColor = 'rgba(0,0,0,0.5)';
    // 阴影的模糊半径
    ctx.shadowBlur = 30;

    window.requestAnimationFrame(e);
})
