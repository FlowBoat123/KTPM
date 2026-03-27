public class TicketCalculator2 {

    /**
     * Ham tinh gia ve vao cong khu vui choi
     * @param age Tuoi cua khach (1 - 100)
     * @param height Chieu cao cua khach tinh bang cm (50 - 220)
     * @return Gia ve (VND)
     */
    public static int calculateTicketPrice(int age, int height) {
        // 1. Kiem tra tinh hop le cua dau vao
        if (age < 1 || age > 100 || height < 50 || height > 220) {
            throw new IllegalArgumentException("Invalid input");
        }

        // 2. Phan loai gia ve
        if (age < 10 && height < 120) {
            return 100000; // Ve tre em
        } else if (age >= 60) {
            return 150000; // Ve nguoi cao tuoi
        } else {
            return 200000; // Ve nguoi lon
        }
    }
}