package Study_codingtest.dongwook.week2.할인행사;

class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {

        int answer = 0;

        for(int i=0; i<=discount.length-10; i++) { // i-> 할인 기간 시작 인덱스
            int cntday = 0; // 원하는 제품이 모두 만족하는지
            for(int j=0; j<want.length; j++) {
                int cnt = 0; // 해당 제품의 할인된 개수
                for(int k=i; k<i+10; k++) { // 10일동안 할인된 제품 확인
                    if(discount[k].equals(want[j])) 
                        cnt++; // 제품 찾으면 증가시켜줌
                }
                if(cnt<number[j]) 
                    break; // 수량이 안맞으면 탈출
                else 
                    cntday++; // 수량이 맞으면 증가
            }
            if(cntday == want.length) 
                answer++; // 모든 제품을 원하는 만큼 맞춘 경우 answer 증가
        }
        return answer; // 유호한 할인 기간 개수 리턴
    }
}
