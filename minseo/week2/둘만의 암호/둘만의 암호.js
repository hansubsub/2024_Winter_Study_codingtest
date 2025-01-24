function solution(s, skip, index) {
    const skipSet = new Set(skip); //skip 알파벳 Set으로 저장
    const alphabet = 'abcdefghijklmnopqrstuvwxyz'; // 기존 알파벳
    let setAlphabet ='' //skip제외한 알파벳 저장 문자열
    
    //skip 제외 알파벳 문자열
    for(let i = 0; i<alphabet.length; i++){
        if(!skipSet.has(alphabet[i])){
            setAlphabet += alphabet[i];
        }
    }
    let result = '';

    for(let i=0; i<s.length;i++){
        let char = s[i];
        let currentIndex = setAlphabet.indexOf(char);
        let newIndex = (currentIndex + index) % setAlphabet.length;
        
        result += setAlphabet[newIndex];
    }
    return result;
}
