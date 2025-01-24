#include <string>
#include <vector>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    int changeCount = 0;
    int deleteCount = 0;
    int count = 0;
    while(s.size() != 1){
        for(int i = 0; i<s.size(); i++){
            if(s[i]=='1'){
                count++;
            }
            else{
                deleteCount++;
            }
        }
        s = "";       
        while (count > 0) {
            s += to_string(count % 2);
            count /= 2;
        }
        changeCount++;
    }
    
    answer.push_back(changeCount);
    answer.push_back(deleteCount);
    
    return answer;
}