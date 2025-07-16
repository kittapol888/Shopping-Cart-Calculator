import java.util.ArrayList;

public class ShoppingCartManualTest {

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้า  null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ 
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1)); // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }

        // Test 4: คำนวณแบบมีส่วนลด "BOGO" ซื้อ 1 แถม 1 เมื่อซื้อสินค้าเป็นจำนวนคู่
        ArrayList<CartItem> BOGOevenCart = new ArrayList<>();
        BOGOevenCart.add(new CartItem("BOGO", "butter", 20.0, 6));
        double total4 = ShoppingCartCalculator.calculateTotalPrice(BOGOevenCart);
        if ( total4 == 60.0) {
            System.out.println("PASSED: BOGOevenCart total is correct (60.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: BOGOevenCart total expected 60.0 but got " + total4);
            failedCount++;
        }

        // Test 5: คำนวณแบบมีส่วนลด "BOGO" ซื้อ 1 แถม 1 เมื่อซื้อสินค้าเป็นจำนวนคี่
        ArrayList<CartItem> BOGOoddCart = new ArrayList<>();
        BOGOoddCart.add(new CartItem("BOGO", "butter", 20.0, 7));
        double total5 = ShoppingCartCalculator.calculateTotalPrice(BOGOoddCart);
        if ( total5 == 80.0) {
            System.out.println("PASSED: BOGOoddCart total is correct (80.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: BOGOoddCart total expected 80.0 but got " + total5);
            failedCount++;
        }

        // Test 6: คำนวณแบบมีส่วนลดเมื่อซื้อเยอะขึ้น "BULK" เมื่อซื้อ 6 ชิ้นขึ้นไป (ลด 10%)
        ArrayList<CartItem> BULKCart6 = new ArrayList<>();
        BULKCart6.add(new CartItem("BULK", "sausage", 10.0, 6));
        double total6 = ShoppingCartCalculator.calculateTotalPrice(BULKCart6);
        if ( total6 == 54.0) {
            System.out.println("PASSED: BULKCart6 total is correct (54.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: BULKCart6 total expected 54.0 but got " + total6);
            failedCount++;
        }

        //Test 7: คำนวณแบบ "BULK" เมื่อซื้อไม่ถึง 6 ชิ้น (ไม่ลด)
        ArrayList<CartItem> BULKCart5 = new ArrayList<>();
        BULKCart5.add(new CartItem("BULK", "sausage", 10.0, 5));
        double total7 = ShoppingCartCalculator.calculateTotalPrice(BULKCart5);
        if ( total7 == 50.0) {
            System.out.println("PASSED: BULKCart5 total is correct (50.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: BULKCart5 total expected 54.0 but got " + total7);
            failedCount++;
        }
        System.out.println("Passed: " + passedCount + " , Failed: " + failedCount);
    }
}
