package mmn15.src;
import org.junit.Assert;
import org.junit.Test;

public class BigNumberTest extends Assert
{

    @Test
    public void constructorTester() {
        assertEquals("0", new BigNumber());

        BigNumber num = new BigNumber(1234567895432L);
        assertEquals(num + "", new BigNumber(num));
    }

    @Test
    public void toStringTester() {
        assertEquals("0", new BigNumber());
        assertEquals("0", new BigNumber(0));
        assertEquals("1", new BigNumber(1));
        assertEquals("10", new BigNumber(10));
        assertEquals("1248638924", new BigNumber(1248638924));
        assertEquals("1234567895432", new BigNumber(1234567895432L));
    }

    public static void assertEquals(String expected, BigNumber actual){
        assertEquals(expected, actual.toString());
    }

    public static void assertEquals(BigNumber expected, BigNumber actual){
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void compareToTester() {
        BigNumber zero = new BigNumber(),
                one = new BigNumber(1),
                num1 = new BigNumber(123456789),
                num2 = new BigNumber(987654321),
                num3 = new BigNumber(1234567895432L);
        // toString()
        assertEquals(0, zero.compareTo(zero));
        assertEquals(-1, zero.compareTo(one));
        assertEquals(1, one.compareTo(zero));
        assertEquals(-1, zero.compareTo(num1));
        assertEquals(0, num1.compareTo(num1));
        assertEquals(1, num2.compareTo(num1));
        assertEquals(-1, num1.compareTo(num2));
    }

    @Test
    public void addBigNumberTester() {
        BigNumber zero = new BigNumber(),
                one = new BigNumber(1),
                num1 = new BigNumber(123456789),
                num2 = new BigNumber(987654321),
                num3 = new BigNumber(1234567895432L);
        // toString()
        assertEquals("0", zero.addBigNumber(zero));
        assertEquals("1", zero.addBigNumber(one));
        assertEquals("1", one.addBigNumber(zero));
        assertEquals(num1, zero.addBigNumber(num1));
        assertEquals(num1, num1.addBigNumber(zero));
        assertEquals("1111111110", num1.addBigNumber(num2));
        assertEquals("2469135790864", num3.addBigNumber(num3));
    }

    @Test
    public void addLongTester() {
        long longNum = 1234567895432L;
        BigNumber zero = new BigNumber(),
                one = new BigNumber(1),
                num = new BigNumber(longNum);
        // toString()
        assertEquals("0", zero.addLong(0));
        assertEquals("1", zero.addLong(1));
        assertEquals("1", one.addLong(0));
        assertEquals(longNum + "", zero.addLong(longNum));
        assertEquals(num, num.addLong(0));
        assertEquals("2469135790864", num.addLong(longNum));
    }

    @Test
    public void subtractBigNumberTester() {
        BigNumber zero = new BigNumber(),
                one = new BigNumber(1),
                num1 = new BigNumber(123456789),
                num2 = new BigNumber(987654321);
        // toString()
        assertEquals("0", zero.subtractBigNumber(zero));
        assertEquals("0", one.subtractBigNumber(one));
        assertEquals("0", num1.subtractBigNumber(num1));
        assertEquals(num1, num1.subtractBigNumber(zero));
        assertEquals("864197532", num2.subtractBigNumber(num1));
    }

    @Test
    public void multBigNumberTester() {
        BigNumber zero = new BigNumber(),
                one = new BigNumber(1),
                num1 = new BigNumber(54321),
                num2 = new BigNumber(76);
        // toString()
        assertEquals("0", zero.multBigNumber(zero));
        assertEquals("0", zero.multBigNumber(one));
        assertEquals("0", one.multBigNumber(zero));
        assertEquals(num1, num1.multBigNumber(one));
        assertEquals(num1, one.multBigNumber(num1));
        BigNumber result = num1.multBigNumber(num2);
        assertEquals("4128396", result);
        assertEquals("17043653532816", result.multBigNumber(result));
    }
}