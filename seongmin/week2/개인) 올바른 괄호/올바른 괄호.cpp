#include <string>
#include <iostream>
#include <vector>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    vector<char> v;
    for(int i = 0; i< s.size(); i++){
        if(s[i] == '('){
            v.push_back('(');
        }
        else{
            if(!v.empty()){
                v.pop_back();
            }
            else{
                return false;
            }
        }

    }
    
    if(!v.empty()){
        return false;
    }
    

    return answer;
}