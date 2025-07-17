
import java.util.ArrayList;

public class ShoppingCartCalculator {

    /**
     * เขียน Javadoc ที่นี่เพื่ออธิบายกฎการทำงานและกรณีพิเศษ:
     * - จะรีเทิร์นค่าเป็น 0 หากสินค้าในตะกร้าเป็น null หรือ empty
     * - จะไม่ใส่ค่า หาก CartItem มี price หรือ quantity ติดลบ
     * - กฎส่วนลด BOGO (ซื้อ 1 แถม 1)
     * - กฎส่วนลด BULK (ซื้อ >= 6 ชิ้น ลด 10%)
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        double sum = 0 ;
        if(items == null)
            return 0.0 ;
        for (CartItem cartItem : items) {
            if (cartItem.sku() == "BOGO" && cartItem.quantity() >= 2) {
             sum += cartItem.price() * Math.round(cartItem.quantity() / 2.0) ;
            } else if(cartItem.sku() == "BULK" && cartItem.quantity() >= 6){
             sum += (cartItem.price() * cartItem.quantity()) - (cartItem.price()) * cartItem.quantity() /(100/10) ;
            }
            else{
                sum += cartItem.price() * cartItem.quantity() ;
            }
        }
        
        return sum ;
    }

}