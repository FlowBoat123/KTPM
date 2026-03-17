public class TicketCalculator {
    
    /**
     * Hàm tính giá vé vào cổng khu vui chơi
     * @param age Tuổi của khách (1 - 100)
     * @param height Chiều cao của khách tính bằng cm (50 - 220)
     * @return Giá vé (VND)
     */
    public static int calculateTicketPrice(int age, int height) {
        // 1. Kiểm tra tính hợp lệ của đầu vào
        if (age < 1 || age > 100 || height < 50 || height > 220) {
            throw new IllegalArgumentException("Invalid input");
        }

        // 2. Phân loại giá vé
        if (age < 10 && height < 120) {
            return 100000; // Vé trẻ em
        } else if (age >= 60) {
            return 150000; // Vé người cao tuổi
        } else {
            return 200000; // Vé người lớn
        }
    }
}