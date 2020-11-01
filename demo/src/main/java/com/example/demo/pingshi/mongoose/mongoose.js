/**
 * 引入及连接
 * @type {Mongoose}
 */
var mongoose=require("mongoose");
mongoose.connect('mongodb://localhost/my_test', {useNewUrlParser: true});
var db = mongoose.connection;
db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function() {
    console.log('数据库已连接!');
});
db.once('close', function() {
    console.log('数据库已断开');
});
//mongoose.disconnect();


/**
 * schema
 */
var Schema = mongoose.Schema;
var stuSchema = new Schema({
    name:  String,
    age: Number,
    gender:   {
        type:String,
        default:"Male"
    },
    address: String
});


/**
 * model
 */
var StuModel=mongoose.model("student",stuSchema);

/**
 * 文档
 */
/*StuModel.create({
    name:"孙悟空",
    age:18,
    gender:"Male",
    address:"花果山"
},function (err) {
    if (!err){
       console.log("插入记录成功");
    }
});*/

/**
 * model增删改查
 */
/*
StuModel.create([
    {
        name:"猪八戒",
        age:27,
        gender:"Male",
        address:"高老庄"
    },
    {
        name:"唐僧",
        age:29,
        gender:"Male",
        address:"女儿国"
    }
],function (err) {
    if (!err){
       console.log('插入数组成功');
    }
});
 */

StuModel.find({gender:"Male"},function (err,docs) {
    if (!err){
        console.log(docs);
    }
});


StuModel.findOne({name:"孙悟空"},function (err,doc) {
    if (!err){
        console.log("验证下返回的doc是不是StuModel的一个实例");
        if (doc instanceof StuModel){
            console.log("true");
        }
    }
});

StuModel.updateOne({name:"猪八戒"},{$set:{age:1023}},function (err) {
    if (!err){
        console.log("修改成功");
    }
});

/*
StuModel.remove({"name":"唐僧"},function (err) {
    if (!err){
        console.log("删除成功");
    }
});*/

StuModel.count({},function (err,count) {
    if (!err) {
        console.log("数量为:"+count);
    }
});

/**
 * 文档增删改查
 */
/*var stu=new StuModel({
    name:"小黑",
    age:18,
    gender:"female",
    address:"十里河"
});

console.log(stu);
stu.save(function (err) {
    if (!err){
        console.log("新增成功");
    }
});*/

StuModel.findOne({name:"孙悟空"},function (err,doc) {
    if (!err){
       console.log("拿到文档对象后修改，由于已经是在这个对象基础上了，所以不用在加条件了");
      /* console.log("第一种方式");
       doc.update({$set:{age:111}},function(err){
           console.log("修改age成功");
       });*/
       console.log("第二种方式");
       doc.age=123;
       doc.save();
    }
});