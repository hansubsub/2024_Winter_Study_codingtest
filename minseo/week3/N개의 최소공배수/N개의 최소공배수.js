function solution(arr) {
    let result = 1;
    for(let i = 0; i<arr.length; i++){
        result = lcm(result, arr[i])
    }
    return result;
}

function gcd(a, b) {
  return b === 0 ? a : gcd(b, a % b);
}

function lcm(a, b) {
  return (a * b) / gcd(a, b);
}

/* 처음에 최대공약수와 최소공배수를 구하는 함수를 soluton 위에 썼더니, 시간초과가 걸렸지만, 밑에 쓰니 해결되었다. */
