package mmn12.src;
public class Segment2Tester {

    public static void main(String[] args) {
        System.out.println("********** Test Q3 Segment2 - Start **********");

        System.out.println("Test new constructor");
        Point p = new Point(3.0, 2.0);
        Segment2 seg22 = new Segment2(p, 4.0);
        if(! seg22.getPoLeft().equals(new Point(1.0, 2.0))) {
            System.out.println("\t ERROR - expected seg22.getPoLeft()=(1.0,2.0) ; actual=" + seg22.getPoLeft());
        } else
            System.out.println("\t OK - expected seg22.getPoLeft()=(1.0,2.0) ; actual=" + seg22.getPoLeft());
        if(! seg22.getPoRight().equals(new Point(5.0, 2.0))) {
            System.out.println("\t ERROR - expected seg22.getPoRight()=(5.0,2.0) ; actual=" + seg22.getPoRight());
        } else
            System.out.println("\t OK - expected seg22.getPoRight()=(5.0,2.0) ; actual=" + seg22.getPoRight());

        System.out.println("Test first constructor and toString:");
        Segment2 seg0 = new Segment2(0.0, 0.0, 2.0, 0.0);
        if(! seg0.getPoLeft().equals(new Point(0.0, 0.0))) {
            System.out.println("\t ERROR - expected seg0.getPoLeft()=(0.0,0.0) ; actual=" + seg0.getPoLeft());
        } else
            System.out.println("\t OK - expected seg0.getPoLeft()=(0.0,0.0) ; actual=" + seg0.getPoLeft());

        if(! seg0.getPoRight().equals(new Point(2.0, 0.0))) {
            System.out.println("\t ERROR - expected seg0.getPoRight()=(2.0,0.0) ; actual=" + seg0.getPoRight());
        } else
            System.out.println("\t OK - expected seg0.getPoRight()=(2.0,0.0) ; actual=" + seg0.getPoRight());

        if (! seg0.toString().equals("(0.0,0.0)---(2.0,0.0)")) {
            System.out.println("\t ERROR - expected seg0.toString()=(0.0,0.0)---(2.0,0.0) ; actual=" + seg0);
        } else
            System.out.println("\t OK - expected seg0.toString()=(0.0,0.0)---(2.0,0.0) ; actual=" + seg0);

        System.out.println("Test second constructor:");
        Point pLeft = new Point(1.0, 4.0);
        Point pRight = new Point(4.0, 8.0);
        Segment2 seg2 = new Segment2(pLeft, pRight);
        if (! seg2.getPoLeft().equals(pLeft) || ! seg2.getPoRight().equals(new Point(4.0,4.0))) {
            System.out.println("\t ERROR - second Constructor - expected (1.0,4.0)---(4.0,4.0) ; actual=" + seg2);
        } else
            System.out.println("\t OK - second Constructor - expected (1.0,4.0)---(4.0,4.0) ; actual=" + seg2);

        System.out.println("Test copy constructor:");
        Segment2 seg3 = new Segment2(seg2);
        if (! seg3.getPoLeft().equals(new Point(1.0, 4.0)) || ! seg3.getPoRight().equals(new Point(4.0,4.0))) {
            System.out.println("\t ERROR - copy Constructor - expected (1.0,4.0)---(4.0,4.0) ; actual=" + seg3);
        } else
            System.out.println("\t OK - copy Constructor - expected (1.0,4.0)---(4.0,4.0) ; actual=" + seg3);

        System.out.println("Test getLength:");
        if (seg0.getLength() != 2.0) {
            System.out.println("\t ERROR - seg0.getLength() - expected 2.0 ; actual=" + seg0.getLength());
        } else
            System.out.println("\t OK - seg0.getLength() - expected 2.0 ; actual=" + seg0.getLength());

        System.out.println("Test equals:");
        if (! seg2.equals(seg3)){
            System.out.println("\t ERROR - equals - seg2.equals(seg3)? - expected true ; actual=" + seg2.equals(seg3));
        } else
            System.out.println("\t OK - equals - seg2.equals(seg3)? - expected true ; actual=" + seg2.equals(seg3));

        Segment2 s1 = new Segment2(5.0, 1.0, 10.0, 1.0);
        Segment2 s3= new Segment2(5.0, 3.0, 10.0, 3.0);
        Segment2 s4= new Segment2(5.0, 0.0, 10.0, 0.0);
        System.out.println("Test isUnder:");
        if (! s1.isUnder(s3)) {
            System.out.println("\t ERROR - s1.isUnder(s3) - expected true ; actual=" + s1.isUnder(s3) + " s1=" + s1 + " s3=" + s3);
        } else
            System.out.println("\t OK - s1.isUnder(s3) - expected true ; actual=" + s1.isUnder(s3) + " s1=" + s1 + " s3=" + s3);
        System.out.println("Test isAbove:");
        if ( !s1.isAbove(s4)) {
            System.out.println("\t ERROR - s1.isAbove(s4) - expected true ; actual=" + s1.isAbove(s4) + " s1=" + s1 + " s4=" + s4);
        } else
            System.out.println("\t OK - s1.isAbove(s4) - expected true ; actual=" + s1.isAbove(s4) + " s1=" + s1 + " s4=" + s4);

        Segment2 sMid = new Segment2(5.0, 0.0, 10.0, 0.0);
        Segment2 sMidLef = new Segment2(3.0, 0.0, 7.0, 0.0);
        Segment2 sLeft= new Segment2(0.0, 3.0, 4.0, 3.0);
        Segment2 sRight= new Segment2(11.0, 0.0, 15.0, 0.0);
        System.out.println("Test isLeft:");
        if (! sMid.isLeft(sRight)) {
            System.out.println("\t ERROR - sMid.isLeft(sRight) - expected true ; actual=" + sMid.isLeft(sRight) + " sMid=" + sMid + " sRight=" + sRight);
        } else
            System.out.println("\t OK - sMid.isLeft(sRight) - expected true ; actual=" + sMid.isLeft(sRight) + " sMid=" + sMid + " sRight=" + sRight);

        System.out.println("Test isRight:");
        if (! sMid.isRight(sLeft)) {
            System.out.println("\t ERROR - sMid.isRight(sLeft) - expected true ; actual=" + sMid.isRight(sLeft) + " sMid=" + sMid + " sLeft=" + sLeft);
        } else
            System.out.println("\t OK - sMid.isRight(sLeft) - expected true ; actual=" + sMid.isRight(sLeft) + " sMid=" + sMid + " sLeft=" + sLeft);

        System.out.println("Test moveHorizontal:");
        sMid.moveHorizontal(5.0);
        Point pL = new Point(10.0,0.0);
        Point pR = new Point(15.0,0.0);
        if (! sMid.getPoLeft().equals(pL) || ! sMid.getPoRight().equals(pR))  {
            System.out.println("\t ERROR - after moveHorizontal - expected (10.0,0.0)---(15.0,0.0) ; actual=" + sMid);
        } else
            System.out.println("\t OK - after moveHorizontal - expected (10.0,0.0)---(15.0,0.0) ; actual=" + sMid);

//*******
        Segment2 sMid_1 = new Segment2(5.0, 0.0, 10.0, 0.0);
        Point pL_1 = new Point(5.0,0.0);
        Point pR_1 = new Point(10.0,0.0);
        sMid_1.moveHorizontal(-6);
       if (! sMid_1.getPoLeft().equals(pL_1) || ! sMid_1.getPoRight().equals(pR_1))  {
            System.out.println("\t ERROR - after moveHorizontal(-6) - expected (5.0,0.0)---(10.0,0.0) ; actual=" + sMid_1);
        } else
            System.out.println("\t OK - after moveHorizontal (-6) - expected (5.0,0.0)---(10.0,0.0) ; actual=" + sMid_1);
//********
        System.out.println("Test moveVertical:");
        sMidLef.moveVertical(5.0);
        Point pUL = new Point (3.0, 5.0);
        Point pUR = new Point (7.0, 5.0);
        if (! sMidLef.getPoLeft().equals(pUL) || ! sMidLef.getPoRight().equals(pUR))  {
            System.out.println("\t ERROR - after moveVertical - expected (3.0,5.0)---(7.0,5.0) ; actual=" + sMidLef);
        } else
            System.out.println("\t OK - after moveVertical - expected (3.0,5.0)---(7.0,5.0) ; actual=" + sMidLef);
//*********
        Segment2 sMid_2 = new Segment2(5.0, 5.0, 10.0, 5.0);
        Point pL_2 = new Point(5.0,5.0);
        Point pR_2 = new Point(10.0,5.0);
        sMid_2.moveVertical(-8);
       if (! sMid_2.getPoLeft().equals(pL_2) || ! sMid_2.getPoRight().equals(pR_2))  {
            System.out.println("\t ERROR - after moveVertical(-8) - expected (5.0,5.0)---(10.0,5.0) ; actual=" + sMid_2);
        } else
            System.out.println("\t OK - after moveVertical (-8) - expected (5.0,5.0)---(10.0,5.0) ; actual=" + sMid_2);
//*********

        System.out.println("Test changeSize:");
        s1 = new Segment2(0.0, 0.0, 2.0, 0.0);
        s1.changeSize(3.0);
        if (s1.getLength() != 5.0 ) {
            System.out.println("\t ERROR - s1.changeSize() - expected length 5.0 ; actual=" + s1.getLength());
        } else
            System.out.println("\t OK - s1.getLength() - expected length 5.0 ; actual=" + s1.getLength());
        System.out.println("Test pointOnSegment:");
        p = new Point (1.0, 0.0); 

        if (!s1.pointOnSegment(p)) {
            System.out.println("\t ERROR - s1.pointOnSegment(p) - expected true ; actual=" + s1.pointOnSegment(p));
        } else
            System.out.println("\t OK - s1.pointOnSegment(p) - expected true ; actual=" + s1.pointOnSegment(p));
        System.out.println("Test isBigger:");
        s1 = new Segment2(0.0, 0.0, 2.0, 0.0);
        Segment2 s2 = new Segment2(0.0, 2.0, 4.0, 2.0);		

        if (! s2.isBigger(s1)) {
            System.out.println("\t ERROR - s2.isBigger(s1) - expected true ; actual=" + s2.isBigger(s1));
        } else
            System.out.println("\t OK - s2.isBigger(s1) - expected true ; actual=" + s2.isBigger(s1));

        System.out.println("Test overlap:");
        if (sMid.overlap(sMid) != 5.0) {
            System.out.println("\t ERROR - sMid.overlap(sMid) - expected 5.0 ; actual=" + sMid.overlap(sMid) + " sMid=" + sMid + " sMid=" + sMid);
        } else
            System.out.println("\t OK - sMid.overlap(sMid) - expected 5.0 ; actual=" + sMid.overlap(sMid) + " sMid=" + sMid + " sMid=" + sMid);

        System.out.println("Test trapezePerimeter:");

        Segment2 sTr1 = new Segment2(2.0, 4.0, 13.0, 4.0);
        Segment2 sTr2 = new Segment2(5.0, 0.0, 10.0, 0.0);

        if (sTr1.trapezePerimeter(sTr2) != 26.0) {
            System.out.println("\t ERROR - sTr1.trapezePerimeter(sTr2) - expected 26.0 ; actual=" + sTr1.trapezePerimeter(sTr2) + " sTr1=" + sTr1 + " sTr2=" + sTr2);
        } else
            System.out.println("\t OK - sTr1.trapezePerimeter(sTr2) - expected 26.0 ; actual=" + sTr1.trapezePerimeter(sTr2) + " sTr1=" + sTr1 + " sTr2=" + sTr2);

        System.out.println("********** Test Q3 Segment2 - Finish **********\n");
    }
}