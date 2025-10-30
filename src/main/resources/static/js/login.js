// 获取登录表单ID，然后设置登录点击按钮事件监听
document.getElementById('loginForm').addEventListener('submit', function (event) {
    event.preventDefault(); // 阻止表单默认提交行为

    // 获取到页面上输入的账号和密码
    var username = document.querySelector('input[type="text"]').value;
    var password = document.querySelector('input[type="password"]').value;

    // 使用Fetch API发送AJAX请求
    fetch('http://localhost:8080/user/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        body: JSON.stringify({username: username, password: password})
    })
        .then(response => response.json())
        .then(data => {
            console.log(data); // 打印后端返回的JSON数据
            if (data.code === 1) {
                //保存用户名
                localStorage.setItem('loginUser', username);
                alert('登录成功');

                window.location.href = /*[[${'/targetPage'}]]*/ './main.html';
            } else {
                alert('登录失败，请检查用户名和密码');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
});
// 添加注册按钮点击事件监听
document.querySelector('button[type="button"]').addEventListener('click', function () {
    window.location.href = /*[[${'/targetPage'}]]*/ './register.html';
});