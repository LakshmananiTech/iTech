import java.util.*;
class Account
{
protected int accnumber;
protected double balance;
Account()
{
accnumber = 0;
balance = 0;
}
Account(int accnumber,double balance)
{
this.accnumber = accnumber;
this.balance = balance;
}
}
class SBAccount extends Account
{
SBAccount(int accnumber,double init_bal)
{
super(accnumber,init_bal);
}

void deposit(double amt)
{
if(amt>=0)
{
balance +=amt;
System.out.println("New Balance : "+balance);
}
else
System.out.println("Invalid deposit amount");
}

void withdraw(double amt)
{
if(balance - amt > 1000)
{
balance -= amt;
System.out.println("New Balance : "+balance);
}
else
System.err.println("Low balance");
}

void calc_interest()
{
balance = balance + balance * 4/(12*100);
System.out.println("Your SB accont new Balance : "+balance);

}
}
class FDAccount extends Account
{
int period;
FDAccount(int accnumber,int period,double amt)
{
super(accnumber,amt);
this.period = period;
}
double calc_interest()
{
return(balance * 8.25/(12*100));
}

void close()
{
balance +=calc_interest();
System.out.println("Your FD is closed and the matured amount : "+balance);
}
}

class Customer
{
int cust_id;
String name;
String address;
SBAccount sb;
FDAccount fd;
static int sbac=100,fdac=1000;
Customer(int cust_id,String name,String address)
{
this.cust_id = cust_id;
this.name = name;
this.address = address;
}
void createAccount(int type)
{
Scanner sc = new Scanner(System.in);
System.out.println("Enter Amount to depoist : ");
double amt = sc.nextDouble();
if(type == 1)
{
sb = new SBAccount(++sbac,amt);
System.out.println("SB account created with Acc. No : "+sb.accnumber+" with balance : "+sb.balance+" for the customer with Customer Id : "+cust_id);
}
else
{
System.out.println("Enter Period: ");
int period = sc.nextInt();
fd = new FDAccount(++fdac,period,amt);
System.out.println("FD account created with Acc. No : "+fd.accnumber+" with Deposit : "+fd.balance+" for the customer with Customer Id : "+cust_id);
}
}
void transaction(int type)
{
Scanner sc = new Scanner(System.in);
if(type == 1)
{
System.out.println("Enter Amount to deposit : ");
double amt = sc.nextDouble();
sb.deposit(amt);
}
else if(type == 2)
{
System.out.println("Enter Amount to withdraw : ");
double amt = sc.nextDouble();
sb.withdraw(amt);
}
else if(type == 3)
sb.calc_interest();
else if(type == 4)
fd.close();
else
System.out.println("Invalid Operation");
}

}
class BankDemo
{
static int cuid;
static int i;
public static void main(String arg[])
{
Scanner sc = new Scanner(System.in);
Customer c[] = new Customer[5];
int type,type1,type2;
try{
do
{
System.out.println("Create New Account -- 1");
System.out.println("Transact Account -- 2");
System.out.println("Exit -- 3");
System.out.println("Enter your choice :");
type = sc.nextInt();
switch(type)
{
case 1 :
System.out.println("Enter Name & Address : ");
String name = sc.next();
String address = sc.next();
c[i] = new Customer(cuid++,name,address);
System.out.println("Create SB Account -- 1");
System.out.println("Create FD Account -- 2");
System.out.println("Enter your choice :");
type1 = sc.nextInt();
if(type1 == 1 || type1 == 2)
c[i++].createAccount(type1);
else
System.out.println("Invalid choice");
break;
case 2:
System.out.println("Enter Customer Id : ");
int cid = sc.nextInt();
System.out.println("Deposit -- 1");
System.out.println(" Withdraw -- 2");
System.out.println("Calculate Interest -- 3");
System.out.println("FD Close -- 4");
System.out.println("Enter your choice :");
type2 = sc.nextInt();
c[cid].transaction(type2);
break;
case 3:
break;
default :
System.out.println("Invalid Option");
}
}while(type != 3);
}catch(Exception e)
{
System.out.println(e);
}
}
}


