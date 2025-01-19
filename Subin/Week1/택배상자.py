#실패 답지 참고함
def solution(order):
	answer = 0
	stack = []
	i=0
	num=0
	while(i<len(order)):
		if num<order[i]:
			num+=1
			stack.append(num)
		elif order[i] == stack[-1]:
			stack.pop()
			i+=1
		else:
			return i
		return i
