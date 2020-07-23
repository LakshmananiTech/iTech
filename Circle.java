import java.util.*;
class Circle
{
double r,a;
void input()
{
Scanner sc = new Scanner(System.in);
System.out.println("Enter r ");
r = sc.nextDouble();
}
void process()
{
a = Math.PI *  r * r;
}
void output()
{
System.out.println(a);
}
}

class CircleTest
{
public static void main(String arg[])
{
Circle c = new Circle();
c.input();
c.process();
c.output();
}
}

