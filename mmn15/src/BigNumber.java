package mmn15.src;
/*================
    Code Section
 ================*/
/**
 * This class functions as a number but without the normal int / long limits.
 * the theoretical limit of this class is 9999999999999999999 digits long (the limit of a long)
 * as it uses a long value to store the length in some point
 * @Author Yonatan Tzukerman
 * @Date 20/1/2021
 */
public class BigNumber {
    // the head of the list - representing the first digit
    private IntNode _head;
    
    /**
     * your typical default constructor to create a number with the value of 0.
     * time and space complexity of O(1)
     */
    public BigNumber() {
        _head = new IntNode(0);
    }


    /**
     * a constructor to create a big number with the value of a given long.
     * time complexity of O(1) as in the worse case the loop will run 19 times (limit of a long)
     * @param num the number to turn into a big number
     */
    public BigNumber(long num) {
        // set the value of the first node
        _head = new IntNode((int)(num % 10));
        IntNode currentNode = _head;
        num /= 10;
        // loop through the number and each time add the digit to a new node
        while (num > 0) {
            currentNode.setNext(new IntNode((int)(num % 10)));
            currentNode = currentNode.getNext();
            num /= 10;
        }
    }


    /**
     * a normal copy constructor to create a big number
     * time complexity of O(n)
     * space of O(1) (not counting THIS)
     * @param other the number to copy
     */
    public BigNumber(BigNumber other) {
        // set the header value
        _head = new IntNode(other._head.getValue());
        // pointers for the rest of the numbers
        IntNode otherNode = other._head.getNext();
        IntNode currentNode = _head;
        // loop across all the nodes in other and update the nodes of this number
        while (otherNode != null) {
            // create the next node
            currentNode.setNext(new IntNode(0));
            currentNode = currentNode.getNext();
            // set it's value
            currentNode.setValue(otherNode.getValue());
            // and go to the next
            otherNode = otherNode.getNext();
        }
    }


    /**
     * a recursive method that overrides the normal toString method.
     * it has a time complexity of O(n) with n being the number of digits
     * it also has space complexity of O(1) -
     * (or O(n) because of the recursion but we haven't learned how to calculate it so both and non I guess)
     * @return the string representing the BigNumber, same format as any other number (i.e: 123)
     */
    public String toString() {
        // calling the recursive method
        return toString("", _head);
    }

    private String toString(String num, IntNode currentNode) {
        // add the current num to the string
        num = currentNode.getValue() + num;
        // check to see if there are more numbers
        if (currentNode.getNext() == null) {
            return num;
        }
        return toString(num, currentNode.getNext());
    }


    /**
     * compares this and the other number.
     * the algorithm runs once on both numbers (at the same time) and tries to figure out which one is larger.
     * time complexity - O(n) with n being the number of digits / nodes in the smallest number
     * space complexity - O(1)
     * @param other the second value to compare
     * @return -1 if this is smaller then other, 1 if this is bigger then other, 0 if equal
     */
    public int compareTo (BigNumber other) {
        // variables to keep information in
        int result = 0;
        IntNode thisCurrent = _head,
                otherCurrent = other._head;

        // goes over the digits and compares them
        while (thisCurrent != null && otherCurrent != null) {
            // update the result based on the current digit
            if (thisCurrent.getValue() > otherCurrent.getValue()) {
                result = 1;
            }
            if (thisCurrent.getValue() < otherCurrent.getValue()) {
                result = -1;
            }

            // loop to the next digit
            thisCurrent = thisCurrent.getNext();
            otherCurrent = otherCurrent.getNext();

        }
        // check if which of the numbers ended first, if non ended it would stay the same
        result = (thisCurrent == null && otherCurrent != null)? -1 : result;
        result = (thisCurrent != null) ? 1 : result;

        return result;
    }


    /**
     * this methods adds the values of 2 bigNumbers together.
     * it uses a method similar to vertical addition to calculate the sum value while only going over the numbers once.
     * the algorithm has time complexity of O(n) with n being the number of digits / nodes in the biggest number.
     * and space complexity of O(n) with n being the returned BigNumber
     * @param other the second value to add up
     * @return a new BigNumber with the sum of this and other
     */
    public BigNumber addBigNumber (BigNumber other) {
        BigNumber result = new BigNumber();
        int firstValue, secondValue, leftOver;
        IntNode firstNode, secondNode, resultNode;

        // set the header value
        result._head.setValue((other._head.getValue() + this._head.getValue()) % 10);
        leftOver = (other._head.getValue() + this._head.getValue()) / 10;

        // pointers for the rest of the numbers
        firstNode = this._head.getNext();
        secondNode = other._head.getNext();
        resultNode = result._head;

        // loop across all the nodes in other and update the nodes of this number
        while (firstNode != null || secondNode != null || leftOver != 0) {

            // set the values to add
            firstValue = (firstNode == null)? 0 : firstNode.getValue();
            secondValue = (secondNode == null)? 0 : secondNode.getValue();

            // create and set the value of the new node
            resultNode.setNext(new IntNode((firstValue + secondValue + leftOver) % 10));
            resultNode = resultNode.getNext();
            leftOver = (firstValue + secondValue + leftOver) / 10;

            // and go to the next
            firstNode = (firstNode == null)? null : firstNode.getNext();
            secondNode = (secondNode == null)? null : secondNode.getNext();
        }

        return result;
    }


    /**
     * add up a long and this number together.
     * this uses the constructor and addBigNumber method to do the calculation.
     * the time complexity of the algorithm is O(n) with n being the length of the biggest number.
     * space complexity is O(n) with n being the returned BigNumber
     * @param num a long value to add up
     * @return a new BigNumber with the sum value
     */
    public BigNumber addLong (long num) {
        // calls the add big number method which has a time complexity of O(n)
        // the constructor only runs a maximum of 19 times so it won't effect the overall complexity
        return addBigNumber(new BigNumber(num));
    }


    /**
     * subtract the small number from the big number then return the result.
     * the algorithm is similar to vertical subtraction and runs on both numbers at the same time while calculating
     * the value and building the new number.
     * this algorithm has a time complexity of O(n) with n being the largest number of digits between other and this.
     * space complexity of O(n) with n being the returned value
     * using the compareTo method to figure out the large and small numbers for a total of 2 linear scans overall
     * @param other the second value
     * @return a new BigNumber containing the subtraction result
     */
    public BigNumber subtractBigNumber (BigNumber other) {
        // variables used throughout the code - 10 overall
        BigNumber result = new BigNumber();
        int bigValue, smallValue, compareValue, debtToNext = 0, debtToLast;
        IntNode big, small, resultNode, lastKnownBeforeZero;

        // use compareTo to find the big and small numbers
        compareValue = this.compareTo(other);
        if (compareValue == 0)
            return result;

        // pointers for the rest of the numbers
        big = (compareValue == 1)? this._head : other._head;
        small = (compareValue == 1)? other._head : this._head;
        resultNode = result._head;
        lastKnownBeforeZero = result._head;


        // loop across all the nodes in other and update the nodes of this number
        while (small != null || big != null || debtToNext != 0) {

            // set the values to add
            bigValue = (big == null)? 0 : big.getValue();
            smallValue = (small == null)? 0 : small.getValue();

            // this advances the nodes while skipping any null pointers
            big = (big == null)? null : big.getNext();
            small = (small == null)? null : small.getNext();


            // work with the carry
            debtToLast = debtToNext;
            debtToNext = (smallValue > bigValue - debtToLast)? 1 : 0;

            // set the value
            resultNode.setValue(((debtToNext * 10) + bigValue - smallValue - debtToLast) % 10);
            // update the pointer to the index before a zero chain
            lastKnownBeforeZero = (resultNode.getValue() != 0)? resultNode : lastKnownBeforeZero;
            resultNode.setNext(new IntNode(0));
            resultNode = resultNode.getNext();

        }
        lastKnownBeforeZero.setNext(null);
        return result;
    }


    /**
     * Multiply 2 big numbers by each other.
     * the algorithm is similar to the vertical multiplication method. it's made of a nested loop one runs on this number
     * the other runs on other number and every time, it multiplies the values and combines them up to get the final result.
     * this algorithm as a time complexity of O(n*m) when m and n are the number of digits in the number (nodes in the list).
     * space complexity of O(n) with n being the returned BigNumber
     * @param other second number to multiply
     * @return a new BigNumber containing the result
     */
    public BigNumber multBigNumber (BigNumber other) {
        // time complexity - O(m*n) while m and n are the number of nodes (digits) in the numbers
        // different variables and pointers used throughout the code
        BigNumber result = new BigNumber();
        IntNode thisCurrent = _head,
                otherCurrent = other._head,
                resultCurrent = result._head;
        long thisCount = 0, i, carry = 0L, debt;
        int value;

        // in case of multiplication by zero
        if (thisCurrent.getValue() == 0 && thisCurrent.getNext() == null)
            return result;
        if (otherCurrent.getValue() == 0 && otherCurrent.getNext() == null)
            return result;

        // a nested loop, one runs on this number other on other number
        while (thisCurrent != null) {

            // advance the result based on the digit we're in
            for (i = thisCount; i > 0; i--) {
                if (resultCurrent.getNext() == null) // create a new node if non already there
                    resultCurrent.setNext(new IntNode(0));
                resultCurrent = resultCurrent.getNext();
            }


            while (otherCurrent != null || carry != 0) {
                // calculate the debt from the last digits and the the carry to the next ones
                debt = carry % 10;
                carry /= 10;
                value = (otherCurrent == null)? 0 : otherCurrent.getValue();
                carry += (value * thisCurrent.getValue() + resultCurrent.getValue() + debt) / 10;
                // process the values into the number
                resultCurrent.setValue((int)(value * thisCurrent.getValue() + debt + resultCurrent.getValue()) % 10 );

                // move to the next one
                otherCurrent = (otherCurrent == null)? null : otherCurrent.getNext();
                if (otherCurrent != null || carry != 0) {
                    if (resultCurrent.getNext() == null) // create a new node if non found
                        resultCurrent.setNext(new IntNode(0));
                    resultCurrent = resultCurrent.getNext();
                }

            }

            // advance / reset the different pointers
            resultCurrent = result._head;
            otherCurrent = other._head;
            thisCurrent = thisCurrent.getNext();
            thisCount++;
        }

        return result;
    }


    // in terms of space complexity it is not fully explained if the value I return count into it,
    // I've seen different sources claiming different things and from what I understand there isn't one concrete "yes or no" answer
    // if you could clarify please if we count these values or not so I could know what to state in the final test thanks.
}