class Pair{
    int element;
    int minimum;
    public Pair(int element, int minimum){
        this.element=element;
        this.minimum=minimum;
    }
}
class MinStack {
    Stack<Pair> st;
    int min;
    public MinStack() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val<min){
            min = val;
        }
        st.push(new Pair(val, min));
    }
    
    public void pop() {
        if(!st.isEmpty()){
            st.pop();
        }
        if(st.isEmpty()){
            min = Integer.MAX_VALUE;
        }
        else{
            min =st.peek().minimum;
        }
    }
    
    public int top() {
        if(!st.isEmpty()){
            return st.peek().element;
        }
        return -1;
    }
    
    public int getMin() {
        return min;
        
    }
}
