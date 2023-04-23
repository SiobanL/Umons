public class Heritage
{
    public static void main(String[] args)
    {
        System.out.println(" A refA = new A(); ");
        A refA = new A();
        refA.mA1();
        refA.mA2();
        refA.mA4();
        refA.printVar1();
        refA.printVar2();
        refA.staticMethod();
        refA.callStaticMethod();
        System.out.println(" A refA = new B(); ");
        refA = new B();
        refA.mA1();
        refA.mA2();
        refA.mA4();
        refA.printVar1();
        refA.printVar2();
        refA.staticMethod();
        refA.callStaticMethod();
        System.out.println(" A refA = new C(); ");
        refA = new C();
        refA.mA1();
        refA.mA2();
        refA.mA4();
        refA.printVar1();
        refA.printVar2();
        refA.staticMethod();
        refA.callStaticMethod();
        System.out.println(" B refB = new B(); ");
        B refB = new B();
        refB.mA1();
        refB.mA2();
        refB.mA4();
        refB.mB3();
        refB.printVar1();
        refB.printVar2();
        refB.staticMethod();
        refB.callStaticMethod();
        System.out.println(" B refB = new C(); ");
        refB = new C();
        refB.mA1();
        refB.mA2();
        refB.mA4();
        refB.mB3();
        refB.printVar1();
        refB.printVar2();
        refB.staticMethod();
        refB.callStaticMethod();
        System.out.println(" C refC = new C(); ");
        C refC = new C();
        refC.mA1();
        refC.mA2();
        refC.mA4();
        refC.mB3();
        refC.printVar1();
        refC.printVar2();
        refC.staticMethod();
        refC.callStaticMethod();
    }
}