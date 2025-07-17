import java.util.ArrayList;

public class ShoppingCartManualTest {

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
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

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Icecream", 15.0, 2)); // 30
        simpleCart.add(new CartItem("NORMAL", "Milk", 12.0, 1));      // 12
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 42.0) {
            System.out.println("PASSED: Simple cart total is correct.");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 42.0 but got " + total3 + ".");
            failedCount++;
        }

        // test 4: คำนวนBoGo 1 แถม 1 
        ArrayList<CartItem> BOGOCart = new ArrayList<>();
        BOGOCart.add(new CartItem("BOGO", "Milk", 10.0, 3));
        double total4 = ShoppingCartCalculator.calculateTotalPrice(BOGOCart);
        if (total4 == 20.0) {
            System.out.println("PASSED: BOGO total is correct.");
            passedCount++;
        } else {
            System.out.println("FAILED: BOGO total expected 20.0 but got " + total4 + ".");
            failedCount++;
        }

        // test 5: คำนวณBULK ซื้อ 6 ชิ้นจะได้ลดราคา 10%
         ArrayList<CartItem> BULK = new ArrayList<>();
        BULK.add(new CartItem("BULK", "Icecream", 13.0, 7));
        double total5 = ShoppingCartCalculator.calculateTotalPrice(BULK);
        if (total5 == 81.9) {
            System.out.println("PASSED: BULK total is correct.");
            passedCount++;
        } else {
            System.out.println("FAILED: BULK total expected 81.9 but got " + total5 + ".");
            failedCount++;
        }
        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}