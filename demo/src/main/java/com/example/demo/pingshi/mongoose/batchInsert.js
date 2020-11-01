var db=connect('log');
var startTime=(new Date()).getTime();
/* for(let i=0;i<1000;i++){
  db.log.insert({"num":i});
} */
var numArrays=[];
for(let i=0;i<1000;i++){
    numArrays.push({num:i});
}
var runTime=(new Date()).getTime()-startTime;

print('消耗时间为:'+runTime+"ms");
