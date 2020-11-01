var timeStamp=Date.parse(new Date());
var jsonDatabase={"name":"zhangsan","loginTime":timeStamp,"age":18,"sex":0};
var db=connect('users');
db.login.insert(jsonDatabase);

print('log print success');