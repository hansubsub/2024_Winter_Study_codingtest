function solution(t, p) {
   let result = 0;
    
    for(let i=0; i<t.length - p.length + 1; i++){
        let K = t.slice(i, i + p.length);
        if(parseInt(K) <= parseInt(p)) //숫자 변환
            result ++;
    }
    return result;
}
