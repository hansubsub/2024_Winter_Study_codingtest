function solution(want, number, discount) {
    let result = 0;

    for (let i = 0; i <= discount.length - 10; i++) {
        let K = discount.slice(i, i + 10); // discount 배열을 10칸으로 나눔

        // 조건 확인
        if (want.every((item, idx) => K.filter(x => x === item).length >= number[idx])) {
            result++;
        } // want 배열의 모든 아이템을 순회하며 K에서 해당 아이템 개수 확인, 각 아이템 개수가 number 에서 요구된 개수 이상일 때 조건 만족
    }

    return result;
}
