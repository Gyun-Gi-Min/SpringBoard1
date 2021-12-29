//삭제버튼 누르면 "삭제하시겠스빈까" confirm
//ㅈ긍정 눌렀을ㄸ

const btnContainerElem = document.querySelector('#btnContainer');

const btnDelElem = btnContainerElem.querySelector('#btnDel');
btnDelElem.addEventListener('click',function (){
    if(confirm('삭제 하시겠슴까?')){
        location.href='/board/del?iboard=' + btnContainerElem.dataset.iboard;
    }
});