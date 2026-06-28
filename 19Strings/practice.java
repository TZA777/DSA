public class practice {

    //input aaaabbbbcccdddd
    //output a4b4c3d4

    public static void StringCompress(String str){

        int n= str.length();

        StringBuilder sb = new StringBuilder();
        int count=1;

        for (int i=0; i<n-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                count++;
            }else{
                sb.append(str.charAt(i));
                sb.append(count);
                count =1;
            }
        }

        //hadling last charector
        sb.append(str.charAt(n-1));
        sb.append(count);
       
        System.out.println(sb);
    }

    public static void main(String[] args) {
        System.out.println("Check");

        StringCompress("aaaabbbccccdddd");
    }

    
}
