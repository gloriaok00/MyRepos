var db=connect('users');
var model={
    findAndModify:"login",
    query:{"name":"xiaowang"},
    update:{"age":38},
    new:true
};
var result=db.runCommand(model);
printjson(result);