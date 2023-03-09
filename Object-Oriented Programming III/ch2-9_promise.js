// 2장 25페이지

const condition = true; // true면 resolve, false면 reject
const promise = new Promise((resolve, reject) => {
    if (condition) {
        resolve('성공');
    } else {
        reject('실패');
    }
});
// 코드가 들어갈 수 있음

/*
promise
    .then((message) => {
        console.log(message);   // 성공(resolve)한 경우 실행
    })
    .catch((error) => {
        console.error(error);
    })
    .finally(() => {
        console.log('무조건');
    });
*/

promise
    .then((message) => {
        return new Promise((resolve, reject) => {
            resolve(message);
        });
    })
    .then((message2) => {
        console.log(message2);
        return new Promise((resolve, reject) => {
            resolve(message2);
        });
    })
    .then((message3) => {
        console.log(message3);
    })
    .catch((error) => {
        console.error(error);
    });

/* 실무 꿀팁: 만약 then 안에 코드 양이 많아질 경우, 해당 코드를 함수( 각각 msg1(), msg2(), msg3() )로 만들고 아래와 같이 promise를 사용하면 가독성을 높일 수 있음
promise
    .then(msg1())
    .then(msg2())
    .then(msg3());
*/