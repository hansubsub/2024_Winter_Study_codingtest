#include <string>
#include <vector>

using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    vector<int> v;
    for(int i = 0; i< discount.size(); i++){
        int startDate = i;
        v = number;  
        bool isntBuy = false;
        
        while(startDate <discount.size() && startDate < i+10){
            for(int j = 0; j<want.size(); j++){
                if(want[j] == discount[startDate]){
                    v[j]--;
                }
            }
            startDate++;
        }
        
        for(int k = 0; k< v.size(); k++){
            if(v[k] > 0){
                isntBuy = true;
            }
        }
        if(isntBuy == false){
            answer++;
        }
    }
    return answer;
}