package deque;

import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {
        LinkedListDeque<String> lld = new LinkedListDeque<>();
        assertTrue("A newly initialized LLDeque should be empty", lld.isEmpty());
        lld.addFirst("front");
        assertEquals(1, lld.size());
        assertFalse("lld should now contain 1 item.", lld.isEmpty());

        lld.addLast("middle");
        assertEquals(2, lld.size());

        lld.addLast("back");
        assertEquals(3, lld.size());

        System.out.println("\nPrinting out deque: ");
        lld.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        assertTrue("lld should be empty before initialization.",lld.isEmpty());

        lld.addFirst(null);
        assertFalse("lld should contain 1 item", lld.isEmpty());

        lld.removeLast();
        assertTrue("lld should be empty after removal", lld.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addFirst(3);
        lld.removeLast();
        lld.removeFirst();
        lld.removeLast();
        lld.removeFirst();

        int size = lld.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {
        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("String");
        lld2.addFirst(3.14);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();

        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld.removeLast());
    }
;
    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        for(int i =0 ;i < 100001; i++){
            lld.addFirst(i);
        }

        for (double i = 0; i < 50000; i++) {
            lld.removeFirst();
        }
        assertEquals("Size should be 50000", 50001, lld.size());
        assertEquals("Next removeFirst should be 50000", 50000, (int) lld.removeFirst());

        for(int i = 99999; i > 50000; i--){
            lld.removeLast();
        }
        assertEquals(1,lld.size());
    }
}
