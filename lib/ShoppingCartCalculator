import java.util.ArrayList;

public class ShoppingCartCalculator {

    /**
     * คำนวณราคารวมของรายการสินค้าในตะกร้า โดยพิจารณาจากราคาต่อชิ้น ปริมาณ และโปรโมชั่น
     * การซื้อสินค้าแบบมีส่วนลด(BOGO) จะเป็นการซื้อ 1 แถม 1
     * เช่น เมื่อซื้อสินค้า 4 ชิ้น จะจ่ายในราคา 2 ชิ้น
     * การซื้อสินค้าแบบมีส่วนลด(BULK) เป็นการซื้อสินค้าตั้งแต่ 6 ชิ้นขึ้นไป จะลด 10%
     * แต่ถ้าซื้อไม่ถึงจำนวนก็จะคิดราคาแบบปกติ
     * @param items รายการสินค้าในตะกร้า
     * @return ราคารวมสุทธิหลังจากคิดโปรโมชั่นทั้งหมดแล้ว หากรายการว่างหรือเป็น null จะคืนค่า 0.0
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        if (items==null || items.isEmpty()){
        return 0.0;
        }
        double total = 0.0;
        for (int i=0;i < items.size();i++){
            CartItem item = items.get(i);
            String sku = item.sku();
            double itemtotal = 0.0;
            if(item.quantity() > 0 && item.price() > 0){
                switch (sku) {
                case "BOGO":
                    int product=(item.quantity()/2)+(item.quantity()%2);
                    itemtotal=product*item.price();
                        break;
                case "BULK":
                    if (item.quantity()>=6){
                        itemtotal=item.quantity()*item.price()*0.9;
                    }else{
                        itemtotal=item.quantity()*item.price();
                    }
                    break;

                    default:
                    itemtotal=item.quantity()*item.price();
                }
            }else{
                    continue;
            }
            total+=itemtotal;
        }
        
        return total;
    }
}
