s= input()
result =0
#변화하는 묶음 수 만큼 뒤집어야 함
for i in range(len(s)-1):
    if s[i]!=s[i+1]:
        result +=1
print (result//2+ result%2)
