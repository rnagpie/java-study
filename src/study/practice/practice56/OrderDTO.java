package study.practice.practice56;

import java.util.List;

public class OrderDTO {
    private String orderId;
    private String date;
    private List<ItemDTO> items; // ItemDto 리스트

    public OrderDTO() {}

    public OrderDTO(String orderId, String date, List<ItemDTO> items) {
        this.orderId = orderId;
        this.date = date;
        this.items = items;
    }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public List<ItemDTO> getItems() { return items; }
    public void setItems(List<ItemDTO> items) { this.items = items; }

    @Override
    public String toString() {
        return "OrderDto{" +
               "orderId='" + orderId + '\'' +
               ", date='" + date + '\'' +
               ", items=" + items +
               '}';
    }
}