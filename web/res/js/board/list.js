function moveToDetail(iboard){
    location.href='/board/detail?iboard=' + iboard;
}
//class는 . 을 써야함.
var trList =document.querySelectorAll('.record');
console.log(trList);

for(var i=0; i<trList.length; i++){
    var tr = trList[i];
    setEvent(tr);
}

function setEvent(tr) {
    tr.addEventListener('click', function () {
        moveToDetail(tr.dataset.iboard);
    });
}