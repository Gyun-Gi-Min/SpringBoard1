//삭제버튼 누르면 "삭제하시겠스빈까" confirm
//ㅈ긍정 눌렀을ㄸ

const btnContainerElem = document.querySelector('#btnContainer');

const btnDelElem = btnContainerElem.querySelector('#btnDel');
btnDelElem.addEventListener('click',function (){
    if(confirm('삭제 하시겠슴까?')){
        location.href='/board/del?iboard=' + btnContainerElem.dataset.iboard;
    }
});

const errAlert = document.querySelector('#alert');
if(errAlert.dataset.err.length > 0){ //이게 true면 err실행이니까 delBoard 실행x
    alert(`${errAlert.dataset.err}`);
    //alert를 찾아왔어 지금. 지금 없어. 문자는 문자열로 생각해봐(배열)

}

// const  에러가 떠.
// let var와 호이스팅같고 에러가 떠.
// var 에러가 안떠.