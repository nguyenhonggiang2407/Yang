# Java Swing TCP Chat

Dự án học tập Java desktop với hai cửa sổ chat dùng Swing và TCP socket.
Tên repository là **Yang**; tên project NetBeans bên trong là `MyChatApplication`.
Đây không phải website hoặc ứng dụng chat nhiều người dùng.

## Source hiện có

- `src/Chat/Chat_Server.java`: tạo cửa sổ server, lắng nghe `127.0.0.1:1201` và nhận một client.
- `src/Chat/Chat_Client.java`: kết nối `127.0.0.1:1201`, gửi/nhận chuỗi qua `writeUTF/readUTF`.
- `src/mychatapplication/MyChatApplication.java`: cửa sổ chọn vai trò Server hoặc Client.
- `src/Chat/*.form`: cấu hình GUI Builder, cần giữ khi sửa layout trong NetBeans.
- `nbproject/`, `build.xml`: cấu hình NetBeans/Ant. Source/target hiện đặt Java 23.

## Chạy bằng NetBeans

1. Mở thư mục project bằng NetBeans và chọn JDK 23 để khớp cấu hình hiện có.
2. Bấm Run Project và chọn **Server**. Chờ trạng thái đang lắng nghe.
3. Chạy ứng dụng lần nữa và chọn **Client** trên cùng máy.
4. Gõ và gửi tin ở hai cửa sổ. Dùng `exit` để kết thúc phiên, rồi mở lại hai cửa sổ để bắt đầu phiên mới.

## Biên dịch trực tiếp

Source không cần thư viện ngoài JDK. Ví dụ PowerShell khi JDK đã có trên PATH:

```powershell
javac -encoding UTF-8 -d out src/mychatapplication/MyChatApplication.java src/Chat/ServerSocket.java src/Chat/Chat_Server.java src/Chat/Chat_Client.java
java -cp out mychatapplication.MyChatApplication server
# Mở terminal thứ hai:
java -cp out mychatapplication.MyChatApplication client
```

Ngày 03/11/2026, lệnh biên dịch bốn source trên đã chạy với JDK 17.0.21 và trả
exit code 0. Điều này xác nhận cú pháp/source có thể biên dịch trên JDK 17;
không có nghĩa cấu hình NetBeans target 23 đã được đổi hoặc Ant build đã được thử.
Không sử dụng các `.class` cũ trong `build/` làm bằng chứng build mới.

## Giới hạn

Đây là bài thực hành một client trên cùng máy. Server chỉ lắng nghe địa chỉ loopback.
Ứng dụng hiển thị trạng thái kết nối và lỗi gửi trong cửa sổ chat. Phần mạng chuyển
các cập nhật giao diện sang Swing Event Dispatch Thread. Cổng 1201 phải trống để chạy thử.
Để dùng qua mạng, cần thiết kế xác thực, TLS và giới hạn kết nối riêng.

`build/` và `nbproject/private/` đã được theo dõi từ lịch sử cũ; đợt này giữ nguyên
để tránh xóa source/artifact không có căn cứ. `.gitignore` chỉ hạn chế file mới phát sinh.

## Nguồn và giấy phép

Source hiện có comment GUI Builder và `@author Admin`; chúng được giữ nguyên.
Chưa có LICENSE/NOTICE xác định quyền tái sử dụng toàn bộ dự án.
Không tự gán giấy phép hoặc khẳng định toàn bộ code là tác phẩm gốc của một tác giả mới.
