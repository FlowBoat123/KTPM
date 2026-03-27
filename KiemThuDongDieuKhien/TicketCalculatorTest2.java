import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicketCalculatorTest2 {

    // TC 1: age = 0, height = 100 -> Ket qua mong doi: Ngoai le
    @Test
    public void testTC1_InvalidInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            TicketCalculator2.calculateTicketPrice(0, 100);
        });
        assertEquals("Invalid input", exception.getMessage());
    }

    // TC 2: age = 5, height = 110 -> Ket qua mong doi: 100000
    @Test
    public void testTC2_ChildTicket() {
        int expectedPrice = 100000;
        int actualPrice = TicketCalculator2.calculateTicketPrice(5, 110);
        assertEquals(expectedPrice, actualPrice);
    }

    // TC 3: age = 5, height = 130 -> Ket qua mong doi: 200000
    @Test
    public void testTC3_AdultTicket_DueToHeight() {
        int expectedPrice = 200000;
        int actualPrice = TicketCalculator2.calculateTicketPrice(5, 130);
        assertEquals(expectedPrice, actualPrice);
    }

    // TC 4: age = 15, height = 110 -> Ket qua mong doi: 200000
    @Test
    public void testTC4_AdultTicket_DueToAge() {
        int expectedPrice = 200000;
        int actualPrice = TicketCalculator2.calculateTicketPrice(15, 110);
        assertEquals(expectedPrice, actualPrice);
    }

    // TC 5: age = 65, height = 160 -> Ket qua mong doi: 150000
    @Test
    public void testTC5_ElderlyTicket() {
        int expectedPrice = 150000;
        int actualPrice = TicketCalculator2.calculateTicketPrice(65, 160);
        assertEquals(expectedPrice, actualPrice);
    }
}