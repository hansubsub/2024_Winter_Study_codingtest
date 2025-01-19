def solution(survey, choices):
    RT = 0
    CF = 0
    JM = 0
    AN = 0
    for i in range(len(survey)):
        score = abs(choices[i] - 4)
        if choices[i]>4:
            if survey[i][1]=='R':
                RT+=score
            elif survey[i][1]=='T':
                RT-=score
            elif survey[i][1]=='C':
                CF+=score
            elif survey[i][1]=='F':
                CF-=score
            elif survey[i][1]=='J':
                JM+=score
            elif survey[i][1]=='M':
                JM-=score
            elif survey[i][1]=='A':
                AN+=score
            elif survey[i][1]=='N':
                AN-=score
        elif choices[i]<4:
            if survey[i][0]=='R':
                RT+=score
            elif survey[i][0]=='T':
                RT-=score
            elif survey[i][0]=='C':
                CF+=score
            elif survey[i][0]=='F':
                CF-=score
            elif survey[i][0]=='J':
                JM+=score
            elif survey[i][0]=='M':
                JM-=score
            elif survey[i][0]=='A':
                AN+=score
            elif survey[i][0]=='N':
                AN-=score
    
    result = ""
    result += "R" if RT >= 0 else "T"
    result += "C" if CF >= 0 else "F"
    result += "J" if JM >= 0 else "M"
    result += "A" if AN >= 0 else "N"
    
    return result
