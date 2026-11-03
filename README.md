# Java Swing TCP Chat

Dự án học tập Java desktop với hai cửa sổ chat dùng Swing và TCP socket.
Tên repository là **Yang**; tên project NetBeans bên trong là `MyChatApplication`.
Đây không phải website hoặc ứng dụng chat nhiều người dùng.

## Source hiện có

- `src/Chat/Chat_Server.java`: tạo cửa sổ server, lắng nghe cổng TCP 1201 và nhận một client.
- `src/Chat/Chat_Client.java`: kết nối `127.0.0.1:1201`, gửi/nhận chuỗi qua `writeUTF/readUTF`.
- `src/mychatapplication/MyChatApplication.java`: main mặc định hiện còn trống.
- `src/Chat/*.form`: cấu hình GUI Builder, cần giữ khi sửa layout trong NetBeans.
- `nbproject/`, `build.xml`: cấu hình NetBeans/Ant. Source/target hiện đặt Java 23.

## Chạy bằng NetBeans

1. Mở thư mục project bằng NetBeans và chọn JDK 23 để khớp cấu hình hiện có.
2. Chạy riêng `Chat.Chat_Server` trước.
3. Chạy riêng `Chat.Chat_Client` trên cùng máy.
4. Gõ và gửi tin ở hai cửa sổ. Chưa có chế độ tự khởi chạy cả hai từ main mặc định.

Không chỉ bấm Run Project rồi coi cửa sổ trống là lỗi mạng: entry point cấu hình
hiện tại là `mychatapplication.MyChatApplication`, chưa mở cửa sổ chat.

## Biên dịch trực tiếp

Source không cần thư viện ngoài JDK. Ví dụ PowerShell khi JDK đã có trên PATH:

```powershell
javac -encoding UTF-8 -d out src/mychatapplication/MyChatApplication.java src/Chat/ServerSocket.java src/Chat/Chat_Server.java src/Chat/Chat_Client.java
java -cp out Chat.Chat_Server
# Mở terminal thứ hai:
java -cp out Chat.Chat_Client
```

Ngày 03/11/2026, lệnh biên dịch bốn source trên đã chạy với JDK 17.0.21 và trả
exit code 0. Điều này xác nhận cú pháp/source có thể biên dịch trên JDK 17;
không có nghĩa cấu hình NetBeans target 23 đã được đổi hoặc Ant build đã được thử.
Không sử dụng các `.class` cũ trong `build/` làm bằng chứng build mới.

## Giới hạn

Chưa có xác thực, TLS, lưu lịch sử, reconnect hoặc server nhiều client.
Các catch block đang bỏ qua lỗi, cập nhật Swing từ vòng đọc mạng cần được rà soát
trước khi phát triển tiếp. Chưa kiểm thử tương tác GUI hoặc trao đổi tin end-to-end
trong đợt audit; chưa có bộ test tự động. Cổng 1201 phải trống để chạy thử.

`build/` và `nbproject/private/` đã được theo dõi từ lịch sử cũ; đợt này giữ nguyên
để tránh xóa source/artifact không có căn cứ. `.gitignore` chỉ hạn chế file mới phát sinh.

## Nguồn và giấy phép

Source hiện có comment GUI Builder và `@author Admin`; chúng được giữ nguyên.
Chưa có LICENSE/NOTICE xác định quyền tái sử dụng toàn bộ dự án.
Không tự gán giấy phép hoặc khẳng định toàn bộ code là tác phẩm gốc của một tác giả mới.
