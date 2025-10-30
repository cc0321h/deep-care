document.getElementById('regForm').addEventListener('submit', function (e) {
    e.preventDefault();

    // 获取表单数据
    const account = document.querySelector('input[name="account"]').value.trim();
    const pwd = document.querySelector('input[name="pwd"]').value.trim();
    const realName = document.querySelector('input[name="realName"]').value.trim();
    const sex = document.querySelector('input[name="sex"]:checked').value;
    const phone = document.querySelector('input[name="phone"]').value.trim();
    const role = document.querySelector('input[name="role"]:checked').value;

    // 验证手机号
    if (!/^1[3-9]\d{9}$/.test(phone)) {
        alert('请输入正确的手机号');
        return;
    }

    // 构造符合后端User实体类的用户对象
    const user = {
        username: account,
        password: pwd,
        name: realName,
        sex: sex,
        phone: phone,
        userType: role,
        registrationTime: new Date().toISOString(), // 注册时间
        lastLoginTime: new Date().toISOString() // 最后登录时间
    };

    fetch('http://localhost:8080/user/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        body: JSON.stringify(user)
    })
        .then(response => response.json())
        .then(data => {
            if (data.code === 1) {
                alert('注册成功');
                window.location.href = './';
            } else {
                alert('注册失败');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('注册请求失败');
        });
});

