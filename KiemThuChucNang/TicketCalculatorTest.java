import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicketCalculatorTest {

    // ==========================================================
    // KỸ THUẬT 1: KIỂM THỬ BẢNG QUYẾT ĐỊNH (DECISION TABLE)
    // ==========================================================

    @Test
    public void testTC01_DT_InvalidInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TicketCalculator.calculateTicketPrice(-5, 150);
        });
        assertEquals("Invalid input", exception.getMessage());
    }

    @Test
    public void testTC02_DT_ChildValid() {
        // Trẻ em (age < 10 AND height < 120)
        assertEquals(100000, TicketCalculator.calculateTicketPrice(7, 110));
    }

    @Test
    public void testTC03_DT_ChildAgeButTall() {
        // Tuổi trẻ em nhưng cao vượt 120cm -> Vé người lớn
        assertEquals(200000, TicketCalculator.calculateTicketPrice(8, 130));
    }

    @Test
    public void testTC04_DT_AdultAgeButShort() {
        // Độ tuổi người lớn nhưng chiều cao thấp -> Vé người lớn
        assertEquals(200000, TicketCalculator.calculateTicketPrice(30, 110));
    }

    @Test
    public void testTC05_DT_AdultNormal() {
        // Người lớn bình thường
        assertEquals(200000, TicketCalculator.calculateTicketPrice(30, 170));
    }

    @Test
    public void testTC06_DT_SeniorShort() {
        // Người cao tuổi, chiều cao thấp
        assertEquals(150000, TicketCalculator.calculateTicketPrice(65, 110));
    }

    @Test
    public void testTC07_DT_SeniorNormal() {
        // Người cao tuổi bình thường
        assertEquals(150000, TicketCalculator.calculateTicketPrice(65, 160));
    }

    // ==========================================================
    // KỸ THUẬT 2: PHÂN TÍCH GIÁ TRỊ BIÊN (BVA - 7 ĐIỂM)
    // ==========================================================

    @Test
    public void testTC08_BVA_AgeMinMinus() {
        // age = 0 (min-)
        assertThrows(IllegalArgumentException.class, () -> TicketCalculator.calculateTicketPrice(0, 150));
    }

    @Test
    public void testTC09_BVA_AgeMin() {
        // age = 1 (min) -> Tính vé người lớn do chiều cao = 150 > 120
        assertEquals(200000, TicketCalculator.calculateTicketPrice(1, 150));
    }

    @Test
    public void testTC10_BVA_AgeMinPlus() {
        // age = 2 (min+) -> Tính vé người lớn
        assertEquals(200000, TicketCalculator.calculateTicketPrice(2, 150));
    }

    @Test
    public void testTC11_BVA_AgeMaxMinus() {
        // age = 99 (max-) -> Vé người cao tuổi
        assertEquals(150000, TicketCalculator.calculateTicketPrice(99, 150));
    }

    @Test
    public void testTC12_BVA_AgeMax() {
        // age = 100 (max) -> Vé người cao tuổi
        assertEquals(150000, TicketCalculator.calculateTicketPrice(100, 150));
    }

    @Test
    public void testTC13_BVA_AgeMaxPlus() {
        // age = 101 (max+)
        assertThrows(IllegalArgumentException.class, () -> TicketCalculator.calculateTicketPrice(101, 150));
    }

    @Test
    public void testTC14_BVA_HeightMinMinus() {
        // height = 49 (min-)
        assertThrows(IllegalArgumentException.class, () -> TicketCalculator.calculateTicketPrice(30, 49));
    }

    @Test
    public void testTC15_BVA_HeightMin() {
        // height = 50 (min) -> Tính vé người lớn do tuổi = 30
        assertEquals(200000, TicketCalculator.calculateTicketPrice(30, 50));
    }

    @Test
    public void testTC16_BVA_HeightMinPlus() {
        // height = 51 (min+)
        assertEquals(200000, TicketCalculator.calculateTicketPrice(30, 51));
    }

    @Test
    public void testTC17_BVA_HeightMaxMinus() {
        // height = 219 (max-)
        assertEquals(200000, TicketCalculator.calculateTicketPrice(30, 219));
    }

    @Test
    public void testTC18_BVA_HeightMax() {
        // height = 220 (max)
        assertEquals(200000, TicketCalculator.calculateTicketPrice(30, 220));
    }

    @Test
    public void testTC19_BVA_HeightMaxPlus() {
        // height = 221 (max+)
        assertThrows(IllegalArgumentException.class, () -> TicketCalculator.calculateTicketPrice(30, 221));
    }

    @Test
    public void testTC20_BVA_Nominal() {
        // Nominal: age = 30, height = 150
        assertEquals(200000, TicketCalculator.calculateTicketPrice(30, 150));
    }
}