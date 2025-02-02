package week4;

//노드클래스
class ListNode{
    int data;
    ListNode link;

    public ListNode(int data){
        this.data = data;
        this.link = null;
    }
}

//노드 삽입
public class Insert {
    ListNode first;

    public void insert(ListNode x){
        ListNode temp = new ListNode(50);

        if(first!=null){
            temp.link = x.link;
            x.link = temp;
        }
        else{
            temp.link =null;
            first = temp;
        }
    }
}


