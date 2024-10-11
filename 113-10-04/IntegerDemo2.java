public class IntegerDemo2 {
    public static void main(String[] args) {
        int data1 = 200;
        Integer wrapper1 = data1;
        Integer wrapper2 = 200;
        int data2 = wrapper2;
        
       if(wrapper1 == wrapper2){
          System.out.println("wrapper1 == wrapper2");
       }else{
          System.out.println("wrapper1 != wrapper2");
       }
       
        
        
    }
}
