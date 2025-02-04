/* 1. 주문하는 기능 (수정 X) */
function receiveOrder() {
    return new Promise((resolve) =>
        setTimeout(() => {
            console.log('주문 접수가 완료되었습니다.');
            resolve('주문번호: 123');
        }, 2000)
    );
}

/* 2. 주문을 처리하는 기능 (수정 X) */
function processOrder(orderId) {
    return new Promise((resolve) =>
        setTimeout(() => {
            console.log(`[${orderId}] 주문이 처리 되었습니다.`);
            resolve(orderId);
        }, 2000)
    );
}

/* 3. 주문을 취소하는 기능 (수정 X) */
function cancelOrder(orderId) {
    return new Promise((resolve) =>
        setTimeout(() => {
            console.log(`[${orderId}] 주문이 취소되었습니다`);
            resolve();
        }, 1500)
    );
}

// 여기에 코드를 작성하세요

receiveOrder()
    .then((orderId) => processOrder(orderId))
    .then((orderId) => cancelOrder(orderId))
    .catch((err) => {
        console.error(err);
    });

// 출력 결과 :
// 주문 접수가 완료되었습니다.
// [주문번호: 123] 주문이 처리 되었습니다.
// [주문번호: 123] 주문이 취소되었습니다
