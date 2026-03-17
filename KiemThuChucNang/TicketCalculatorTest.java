import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicketCalculatorTest {

    // ==========================================================
    // KỸ THUẬT 1: KIỂM THỬ BẢNG QUYẾT ĐỊNH (DECISION TABLE)
    // ==========================================================

    @Test
    public void testTC01_InvalidInput() {
        // R1: Đầu vào không hợp lệ
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TicketCalculator.calculateTicketPrice(-5, 150);
        });
        assertEquals("Invalid input", exception.getMessage());
    }

    @Test
    public void testTC02_ChildTicket() {
        // R2: Trẻ em (age < 10 AND height < 120)
        assertEquals(100000, TicketCalculator.calculateTicketPrice(7, 110));
    }

    @Test
    public void testTC03_SeniorTicket() {
        // R3: Người cao tuổi (age >= 60)
        assertEquals(150000, TicketCalculator.calculateTicketPrice(65, 160));
    }

    @Test
    public void testTC04_AdultTicket() {
        // R4: Người lớn (Các trường hợp còn lại)
        assertEquals(200000, TicketCalculator.calculateTicketPrice(30, 170));
    }

    // ==========================================================
    // KỸ THUẬT 2: PHÂN TÍCH GIÁ TRỊ BIÊN (BOUNDARY VALUE ANALYSIS)
    // ==========================================================

    @Test
    public void testTC05_AgeBelowMin() {
        // age < min (0 < 1)
        assertThrows(IllegalArgumentException.class, () -> TicketCalculator.calculateTicketPrice(0, 150));
    }

    @Test
    public void testTC06_AgeAtMin() {
        // age = min (1). Cao 150cm nên tính vé người lớn.
        assertEquals(200000, TicketCalculator.calculateTicketPrice(1, 150));
    }

    @Test
    public void testTC07_AgeAtMax() {
        // age = max (100) -> Vé người cao tuổi
        assertEquals(150000, TicketCalculator.calculateTicketPrice(100, 150));
    }

    @Test
    public void testTC08_AgeAboveMax() {
        // age > max (101 > 100)
        assertThrows(IllegalArgumentException.class, () -> TicketCalculator.calculateTicketPrice(101, 150));
    }

    @Test
    public void testTC09_HeightBelowMin() {
        // height < min (49 < 50)
        assertThrows(IllegalArgumentException.class, () -> TicketCalculator.calculateTicketPrice(30, 49));
    }

    @Test
    public void testTC10_HeightAtMin() {
        // height = min (50). 30 tuổi nên tính vé người lớn.
        assertEquals(200000, TicketCalculator.calculateTicketPrice(30, 50));
    }

    @Test
    public void testTC11_HeightAtMax() {
        // height = max (220)
        assertEquals(200000, TicketCalculator.calculateTicketPrice(30, 220));
    }

    @Test
    public void testTC12_HeightAboveMax() {
        // height > max (221 > 220)
        assertThrows(IllegalArgumentException.class, () -> TicketCalculator.calculateTicketPrice(30, 221));
    }

    @Test
    public void testTC13_NominalValues() {
        // Giá trị thông thường ở giữa (age = 30, height = 150)
        assertEquals(200000, TicketCalculator.calculateTicketPrice(30, 150));
    }
}