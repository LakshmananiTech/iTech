import java.util.*;

class Cylinder extends Circle
{
double h,v;
void input()
{
Scanner sc = new Scanner(System.in);
super.input();
System.out.println("Enter h ");
h = sc.nextDouble();
}
void process()
{
super.process();
v = a * h;
}
void output()
{
System.out.println(v);
}
}

class CylinderTest
{
public static void main(String arg[])
{
Cylinder c = new Cylinder();
c.input();
c.process();
c.output();
}
}
