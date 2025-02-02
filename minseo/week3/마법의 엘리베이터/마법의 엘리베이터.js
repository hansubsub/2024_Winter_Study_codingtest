function solution(storey) {
    let result = 0;
    
    while (1) {
        let num = storey % 10;
        storey = Math.floor(storey / 10);
        
        if(num > 5){
            result += (10-num)
            storey ++;
        }
        else {
            result += num;
            if (num == 5 && storey % 10 >= 5)
                storey++;
        }
        if (storey == 0)
            break ;
    }
    
    return result
}
