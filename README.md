# KTPM - Kiểm Thử Ticket Calculator

## Giới thiệu
Đây là chương trình Java tính giá vé vào cổng khu vui chơi thông qua hàm `calculateTicketPrice(age, height)` trong file `TicketCalculator.java`.

Quy tắc tính giá vé:
- Đầu vào hợp lệ: `age` từ 1 đến 100, `height` từ 50 đến 220.
- Trẻ em (`age < 10` và `height < 120`): `100000` VND.
- Người cao tuổi (`age >= 60`): `150000` VND.
- Còn lại: `200000` VND.

Nếu đầu vào không hợp lệ, hàm ném `IllegalArgumentException("Invalid input")`.

## Cấu trúc file hiện tại
- `TicketCalculator.java`: Hàm xử lý chính (đặt ở root).
- `BT3/KiemThuDongDuLieu.java`: Bộ test 1.
- `KiemThuChucNang/TicketCalculatorTest.java`: Bộ test 2.
- `KiemThuDongDieuKhien/TicketCalculatorTest2.java`: Bộ test 3.
- `junit-platform-console-standalone-1.10.2.jar`: Thư viện JUnit 5 standalone.

## Yêu cầu môi trường
- Java JDK (khuyến nghị JDK 17 trở lên).
- PowerShell trên Windows.

## Cách chạy tất cả 3 file test
Chạy trong thư mục gốc project `KTPM`:

```powershell
Set-Location "C:\Users\ADMIN\Music\KTPM"
$out = "out-test"

if (Test-Path $out) {
    Remove-Item $out -Recurse -Force
}

New-Item -ItemType Directory -Path $out | Out-Null

javac -cp ".;junit-platform-console-standalone-1.10.2.jar" -d $out .\TicketCalculator.java .\BT3\KiemThuDongDuLieu.java .\KiemThuChucNang\TicketCalculatorTest.java .\KiemThuDongDieuKhien\TicketCalculatorTest2.java

java -jar .\junit-platform-console-standalone-1.10.2.jar -cp $out --select-class KiemThuDongDuLieu --select-class TicketCalculatorTest --select-class TicketCalculatorTest2
```

## Chạy từng file test
### 1) BT3/KiemThuDongDuLieu.java
```powershell
Set-Location "C:\Users\ADMIN\Music\KTPM"
$out = "out-test"
if (Test-Path $out) { Remove-Item $out -Recurse -Force }
New-Item -ItemType Directory -Path $out | Out-Null
javac -cp ".;junit-platform-console-standalone-1.10.2.jar" -d $out .\TicketCalculator.java .\BT3\KiemThuDongDuLieu.java
java -jar .\junit-platform-console-standalone-1.10.2.jar -cp $out --select-class KiemThuDongDuLieu
```

### 2) KiemThuChucNang/TicketCalculatorTest.java
```powershell
Set-Location "C:\Users\ADMIN\Music\KTPM"
$out = "out-test"
if (Test-Path $out) { Remove-Item $out -Recurse -Force }
New-Item -ItemType Directory -Path $out | Out-Null
javac -cp ".;junit-platform-console-standalone-1.10.2.jar" -d $out .\TicketCalculator.java .\KiemThuChucNang\TicketCalculatorTest.java
java -jar .\junit-platform-console-standalone-1.10.2.jar -cp $out --select-class TicketCalculatorTest
```

### 3) KiemThuDongDieuKhien/TicketCalculatorTest2.java
```powershell
Set-Location "C:\Users\ADMIN\Music\KTPM"
$out = "out-test"
if (Test-Path $out) { Remove-Item $out -Recurse -Force }
New-Item -ItemType Directory -Path $out | Out-Null
javac -cp ".;junit-platform-console-standalone-1.10.2.jar" -d $out .\TicketCalculator.java .\KiemThuDongDieuKhien\TicketCalculatorTest2.java
java -jar .\junit-platform-console-standalone-1.10.2.jar -cp $out --select-class TicketCalculatorTest2
```

## Ghi chú
- Nếu chưa có file JUnit jar, tải từ Maven Central với đúng tên: `junit-platform-console-standalone-1.10.2.jar` và đặt ở root project.
- Các cảnh báo về `Delegated to the 'execute' command` là cảnh báo từ launcher, không làm fail test.
