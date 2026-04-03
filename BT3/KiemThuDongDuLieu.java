import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KiemThuDongDuLieu {
    @Test
    public void testTC1_InvalidInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            TicketCalculator.calculateTicketPrice(0, 100);
        });
        assertEquals("Invalid input", exception.getMessage());
    }

    
    @Test
    public void testTC2_ChildTicket() {
        int expectedPrice = 100000;
        int actualPrice = TicketCalculator.calculateTicketPrice(8, 110);
        assertEquals(expectedPrice, actualPrice);
    }

    
    @Test
    public void testTC3_AdultTicket_DueToHeight() {
        int expectedPrice = 200000;
        int actualPrice = TicketCalculator.calculateTicketPrice(9, 140);
        assertEquals(expectedPrice, actualPrice);
    }

    
    @Test
    public void testTC4_AdultTicket_DueToAge() {
        int expectedPrice = 200000;
        int actualPrice = TicketCalculator.calculateTicketPrice(15, 110);
        assertEquals(expectedPrice, actualPrice);
    }

    
    @Test
    public void testTC5_ElderlyTicket() {
        int expectedPrice = 200000;
        int actualPrice = TicketCalculator.calculateTicketPrice(40, 170);
        assertEquals(expectedPrice, actualPrice);
    }
}