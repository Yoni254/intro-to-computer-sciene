package finalsPractice.src;
public class poly {
    public static void main (String [] args)
    {
        int m = 12;
        D d = new D(m); // _x needs to be 13
        B b = new D(2); // _x = 1
        ((A)d).f(b);
        System.out.println("_x of d");
    }
}

abstract class A {
    protected int _x;
    public A() {
        _x = 1;
    }
    public abstract int f(int x);
    public void f(A a) {
        _x = a._x;
    }
}

class B extends A{
    public B() {
        super();
    }
    public B (int val) {
        _x = f(val);
    }
    public int f(int x) {
        return _x + x;
    }
    public void f(B b) {
        _x = _x * b._x;
    }
}

class C extends B {
    public int f(int x) {
        return _x - x;
    }

    public void f(A a) {
        if (a instanceof C)
            _x = _x - a._x;
        else
            super.f(a);
    }

    public void f(B b) {
        _x = _x + b._x;
    }

    public void f(C c) {
        _x = c._x + 1;
    }
}

class D extends B {
    public D(int val) {
        _x = val - _x;
    }
    public void f(A a) {
        _x = _x + a._x + 1;
    }

    public void f(B b) { // x = 13
        _x = _x * b._x;
    }
    public void f(D d) {
        _x = d._x - 1;
    }
}
