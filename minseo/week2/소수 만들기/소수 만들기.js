function solution(nums) {
    let result = 0;

    // 소수인지 확인하는 함수
    function isPrime(num) {
        if (num < 2) return false; // 1 이하는 소수가 아님
        for (let i = 2; i <= Math.sqrt(num); i++) {
            if (num % i === 0) return false; // 약수가 있으면 소수가 아님
        }
        return true;
    }

    // 3개의 숫자를 골라서 합산 후 소수 판별
    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            for (let k = j + 1; k < nums.length; k++) {
                let sum = nums[i] + nums[j] + nums[k];
                if (isPrime(sum)) {
                    result++;
                }
            }
        }
    }

    return result;
}
