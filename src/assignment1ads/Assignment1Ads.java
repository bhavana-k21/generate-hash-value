package assignment1ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Assignment1Ads 
{
    public static void main(String[] args) throws NoSuchAlgorithmException 
    {
        Scanner sc=new Scanner(System.in);
        // TODO code application logic here
        int[] link=new int[10];
        String[] key=new String[10];
        HashMap<String,String> hm=new HashMap<>();
        Hashtable<String,LinkedList<String>> ht=new Hashtable<>();
       LinkedList<String> ll=new LinkedList<>();
        LinkedList<String> ll1=new LinkedList<>();
       ArrayList<Integer> al1=new ArrayList<>();
         ArrayList<Integer> al2=new ArrayList<>();
          ArrayList<Integer> al3=new ArrayList<>();
          LinkedList<String> ll2=new LinkedList<>();
        LinkedList<String> ll3=new LinkedList<>();
        LinkedList<String> ll4=new LinkedList<>();
        LinkedList<String> ll5=new LinkedList<>();
        LinkedList<String> ll6=new LinkedList<>();
        LinkedList<String> ll7=new LinkedList<>();
        LinkedList<String> ll8=new LinkedList<>();
        LinkedList<String> ll9=new LinkedList<>();
        LinkedList<String> ll10=new LinkedList<>();
        LinkedList<String> ll11=new LinkedList<>();
        MessageDigest md=MessageDigest.getInstance("MD5");
        
      String accno,amount,accnoamt,accountnum,hexa1=null,hexa2=null;
      String[] account=new String[10];
      String[] amount1=new String[10];
      int accnum,amtnum;
      int j=0,ch,pos ,option,ch1;
        ArrayList<String> al=new ArrayList<>();
      
        do{   
         System.out.println("Enter the operation:\n0.exit()\n1.Create Account\n2.Transaction\n3.Print Transaction");
         option=sc.nextInt();
         switch(option){
            case 0:
                break;
            case 1:
                 do{ 
       System.out.println("Enter the account no.");
       accno=sc.next();
       if(al.contains(accno)){//Checks if Account Already exsists or not..
           System.out.println("Account already exists...");
       }
       else{
       System.out.println("Enter the amount");
       amount=sc.next();
       accountnum=accno+amount;
        hm.put(accno, amount);
        
       ll.add(accountnum);
       al.add(accno);
       System.out.println(""+ll);
       accnoamt=accno+" "+amount;
       String[] accountno=accnoamt.split(" ",40);
        account[j]=accountno[0];
       amount1[j]=accountno[1];
         byte[] messdig=md.digest(account[j].getBytes());
         byte[] messdig1=md.digest(amount1[j].getBytes());
         BigInteger no=new BigInteger(1,messdig);
         BigInteger no1=new BigInteger(1,messdig1);
         String ht1=no.toString(16);
         String ht2=no.toString(16);
         while(ht1.length()<10)
         {
             ht1="0"+ht1;
         }
         while(ht1.length()<10)
         {
             ht2="0"+ht2;
         }
            hexa2=ht1+ht2;
            ll1.add(hexa2);
             pos=Integer.parseInt(account[j])%10;
             
             if(al1.contains(pos)){pos++;}
             
             if(pos==0){al1.add(pos);al2.add(pos);al3.add(pos);
             ll2.add(hexa2);
                ht.put(ht1, ll2);}
                if(pos==1){al1.add(pos);al2.add(pos);al3.add(pos);ll3.add(hexa2);
                ht.put(ht1,ll3);}
             if(pos==2){al1.add(pos);al2.add(pos);al3.add(pos);ll4.add(hexa2);
             ht.put(ht1, ll4);}
             if(pos==3){al1.add(pos);al2.add(pos);al3.add(pos);ll5.add(hexa2);
             ht.put(ht1, ll5);}
             if(pos==4){al1.add(pos);al2.add(pos);al3.add(pos);ll6.add(hexa2);
             ht.put(ht1, ll6);}
             if(pos==5){al1.add(pos);al2.add(pos);al3.add(pos);ll7.add(hexa2);
             ht.put(ht1, ll7);}
             if(pos==6){al1.add(pos);al2.add(pos);al3.add(pos);ll8.add(hexa2);
             ht.put(ht1, ll8);}
             if(pos==7){al1.add(pos);al2.add(pos);al3.add(pos);ll9.add(hexa2);
             ht.put(ht1, ll9);}
             if(pos==8){al1.add(pos);al2.add(pos);al3.add(pos);ll10.add(hexa2);
             ht.put(ht1, ll10);}
             if(pos==9){al1.add(pos);al2.add(pos);al3.add(pos);ll11.add(hexa2);
             ht.put(ht1, ll11);}
            System.out.println("Acount Created Successfully!!!");
                 }
        System.out.println("Enter 1 to continue and 0 to exit.");
        ch=sc.nextInt();
        if(ch==1){   j++;}
       }while(ch!=0);
                break;
            case 2:
                System.out.println("Choose:\n1.Withdraw\n2.Credit");
                ch1=sc.nextInt();
                if(ch1==1){withdraw(al1,hm,ht,ll2,ll3,ll4,ll5,ll6,ll7,ll8,ll9,ll10,ll11);}
                if(ch1==2){credit(al1,hm,ht,ll2,ll3,ll4,ll5,ll6,ll7,ll8,ll9,ll10,ll11);}
                 break;
            case 3:
                
               hash(ht);
                       break;
        }
       }while(option!=0);
    }
  
    public static void withdraw(ArrayList<Integer> al1,HashMap<String,String> hm,Hashtable<String,LinkedList<String>> ht,LinkedList<String> ll2,LinkedList<String> ll3,LinkedList<String> ll4,LinkedList<String> ll5
    ,LinkedList<String> ll6,LinkedList<String> ll7,LinkedList<String> ll8,LinkedList<String> ll9,LinkedList<String> ll10,LinkedList<String> ll11) throws NoSuchAlgorithmException{
        Scanner sc=new Scanner(System.in);
        int accnum,amount,pos;
        MessageDigest md=MessageDigest.getInstance("MD5");
        String accno,accnoamt,with,amt,hexa1,hexa2;
        System.out.println("Enter the Account number:");
        accno=sc.next();
        if(hm.containsKey(accno)){
            System.out.println("Enter the amount to withdraw:");
            with=sc.next();
            amt=hm.get(accno);
            if(Integer.parseInt(with)<=Integer.parseInt(amt))
            {
            amount=Integer.parseInt(amt)-Integer.parseInt(with);
                byte[] messdig=md.digest(accno.getBytes());
         byte[] messdig1=md.digest(with.getBytes());
         BigInteger no=new BigInteger(1,messdig);
         BigInteger no1=new BigInteger(1,messdig1);
         String ht1=no.toString(16);
         String ht2=no.toString(16);
         while(ht1.length()<10)
         {
             ht1="0"+ht1;
         }
         while(ht1.length()<10)
         {
             ht2="0"+ht2;
         }
            hexa2=ht1+ht2;
                System.out.println("Amount withdrawn successfully..");
           // System.out.println("HexaDecimal Value is:"+hexa2);
            pos=Integer.parseInt(accno)%10;
             
             //if(al1.contains(pos)){pos++;}
              if(pos==0){ll2.add(hexa2);
                ht.put(ht1, ll2);}
                if(pos==1){ll3.add(hexa2);
                ht.put(ht1,ll3);}
             if(pos==2){ll4.add(hexa2);
             ht.put(ht1, ll4);}
             if(pos==3){ll5.add(hexa2);
             ht.put(ht1, ll5);}
             if(pos==4){ll6.add(hexa2);
             ht.put(ht1, ll6);}
             if(pos==5){ll7.add(hexa2);
             ht.put(ht1, ll7);}
             if(pos==6){ll8.add(hexa2);
             ht.put(ht1, ll8);}
             if(pos==7){ll9.add(hexa2);
             ht.put(ht1, ll9);}
             if(pos==8){ll10.add(hexa2);
             ht.put(ht1, ll10);}
             if(pos==9){ll11.add(hexa2);
             ht.put(ht1, ll11);} 
            }
            else{System.out.println("Error!!!");}
        }
        else{
            System.out.println("No Account Found...");
        }
        System.out.println(""+ll2);
    }
     public static void credit(ArrayList<Integer> al3,HashMap<String,String> hm,Hashtable<String,LinkedList<String>> ht,LinkedList<String> ll2,LinkedList<String> ll3,LinkedList<String> ll4,LinkedList<String> ll5
    ,LinkedList<String> ll6,LinkedList<String> ll7,LinkedList<String> ll8,LinkedList<String> ll9,LinkedList<String> ll10,LinkedList<String> ll11) throws NoSuchAlgorithmException{
         Scanner sc=new Scanner(System.in);
        int accnum,amount,pos;
        String accno,accnoamt,with,amt,hexa2;
        MessageDigest md=MessageDigest.getInstance("MD5");
        System.out.println("Enter the Account number:");
        accno=sc.next();
        if(hm.containsKey(accno)){
            System.out.println("Enter the amount to credited:");
            with=sc.next();
            amt=hm.get(accno);
            amount=Integer.parseInt(amt)+Integer.parseInt(with);
                byte[] messdig=md.digest(accno.getBytes());
         byte[] messdig1=md.digest(with.getBytes());
         BigInteger no=new BigInteger(1,messdig);
         BigInteger no1=new BigInteger(1,messdig1);
         String ht1=no.toString(16);
         String ht2=no.toString(16);
         while(ht1.length()<10)
         {
             ht1="0"+ht1;
         }
         while(ht1.length()<10)
         {
             ht2="0"+ht2;
         }
            hexa2=ht1+ht2;
          
            System.out.println("Amount credited successfully");
            //System.out.println("HexaDecimal Value is:"+hexa2);
            pos=Integer.parseInt(accno)%10;
             
             if(al3.contains(pos)){pos++;}
              if(pos==0){ll2.add(hexa2);
                ht.put(ht1, ll2);}
                if(pos==1){ll3.add(hexa2);
                ht.put(ht1,ll3);}
             if(pos==2){ll4.add(hexa2);
             ht.put(ht1, ll4);}
             if(pos==3){ll5.add(hexa2);
             ht.put(ht1, ll5);}
             if(pos==4){ll6.add(hexa2);
             ht.put(ht1, ll6);}
             if(pos==5){ll7.add(hexa2);
             ht.put(ht1, ll7);}
             if(pos==6){ll8.add(hexa2);
             ht.put(ht1, ll8);}
             if(pos==7){ll9.add(hexa2);
             ht.put(ht1, ll9);}
             if(pos==8){ll10.add(hexa2);
             ht.put(ht1, ll10);}
             if(pos==9){ll11.add(hexa2);
             ht.put(ht1, ll11);} 
             else{System.out.println("Error!!!");}
        }
        else{
            System.out.println("No Account Found...");
        }
        System.out.println(""+ll2);
    }
    public static void hash(Hashtable<String,LinkedList<String>> ht)
     {
         System.out.println(""+ht);
     }
    public static void hash1(Hashtable<String,LinkedList<String>> ht) throws NoSuchAlgorithmException
     {
         Scanner sc=new Scanner(System.in);
         String acc,hexa;
         int acc1;
          MessageDigest md=MessageDigest.getInstance("MD5");
        System.out.println("Enter the Account number:");
         acc=sc.next();
           byte[] messdig=md.digest(acc.getBytes());
         BigInteger no=new BigInteger(1,messdig);
         String ht1=no.toString(11);
         while(ht1.length()<20)
         {
             ht1="0"+ht1;
         }        
        //if(ht.containsKey(ht1))
        {
            
            System.out.println(""+ht);
        }
         
     }
}
