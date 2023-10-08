/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private int countLength;

    public Solution(){
        countLength = 0;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Solution n = new Solution();
        n.countLength(l1,l2);
        System.out.print("Current length of largest list : "+n.listElmCount());
        System.out.println();
        //n.printL(l1);

        n.caseOne(l1,l2);
       
        return l1;
        
    }

    //use case 1 : dealing with remainders
     private void caseOne(ListNode l1, ListNode l2){
         int t1 = 0, t2 = 0, reimaider = 0,index =0,i2=0,sum = 0;
         int[] arr  = new int[countLength];
         //System.out.println("Array size: "+arr.length);

        while(l1 != null && l2 != null ){
            t1 = l1.val;
            t2 = l2.val;
            sum =  t1 + t2;
            if(sum >= 10){
                //store difference
                //int diff = Math.abs(sum - 10);
                 int diff = sum - 10;
                if(diff == 0){
                    System.out.println("Diffrence1: "+diff);
                    arr[index] =  diff;
                    reimaider = 1;
                    arr[index+1] = reimaider;
                }else if(diff > 0){
                    System.out.println("Diffrence2: "+diff);
                    arr[index] =  diff;
                    reimaider = 1+diff;
                    arr[index+1] = reimaider;
                }

            }
            //arr[index] =  t1 + t2 + reimaider;
            arr[index] += sum; 
            
            l1 = l1.next;
            l2 = l2.next;
            index++;

        }

        while(i2 != arr.length){
         System.out.print(arr[i2]+" --> ");
         i2++;
        }

        
     }

    
    

    //use case 2: Input: l1 = [0], l2 = [0] and Output: [0]
    private ListNode caseTwo(ListNode l1, ListNode l2){
        ListNode ListNode = new ListNode();
        if(l1 == null && l2 == null){
            ListNode.val = l1.val + l2.val;
        }
        return ListNode;
    }

    // L is head
    private void printL(ListNode L){
        while(L != null){
            System.out.print(L.val+" --> ");
            L = L.next;

        }
    }
    
    //return list length with most elements
    private void countLength(ListNode L1,ListNode L2){
        int count1 = 0, count2 = 0;
        while(L1 != null){
            count1++;
            L1 = L1.next;
        }

        while(L2 != null){
            count2++;
            L2 = L2.next;
        }

        if(count1 > count2){
            this.countLength =  count1;
        }else{
            this.countLength =  count2;
        }
    }

    //return list length 
    private int countLength(ListNode L1){
        int count1 = 0;
        while(L1 != null){
            count1++;
            L1 = L1.next;
        }

        return count1;
    
    }

    private int listElmCount(){
        return countLength;
    }
}