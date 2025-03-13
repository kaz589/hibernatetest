    FlightTicketingSystem/
    ├── src/
    │   ├── main/
    │   │   ├── java/                              # Java 程式碼目錄
    │   │   │   └── com/
    │   │   │       ├── controller/       # 控制層
    │   │   │       │   ├── Frontend/     # 前台控制器
    │   │   │       │   │   ├── FlightSearchController.java
    │   │   │       │   │   ├── BookingController.java
    │   │   │       │   │   └── UserController.java
    │   │   │       │   └── Admin/      # 後台控制器
    │   │   │       │       ├── AdminFlightController.java
    │   │   │       │       ├── AdminBookingController.java
    │   │   │       │       └── AdminUserController.java
    │   │   │       ├── service/          # 業務邏輯層（Service）
    │   │   │       ├── repository/       # 資料訪問層（Repository/DAO）
    │   │   │       ├── model/            # 資料模型層（Model/Entity）
    │   │   │       └── config/           # 配置類
    │   │   ├── webapp/
    │   │   │   ├── static/                       # 靜態資源（CSS、JS、圖片等）
    │   │   │   │   ├── frontend/                 # 前台靜態資源
    │   │   │   │   │   ├── css/
    │   │   │   │   │   ├── js/
    │   │   │   │   │   └── images/
    │   │   │   │   └── Admin/                  # 後台靜態資源
    │   │   │   │       ├── css/
    │   │   │   │       ├── js/
    │   │   │   │       └── images/
    │   │   │   ├── templates/                    # HTML 模板
    │   │   │   │   ├── frontend/                 # 前台頁面模板
    │   │   │   │   │   ├── index.html            # 首頁
    │   │   │   │   │   ├── search.html           # 航班搜索頁面
    │   │   │   │   │   ├── booking.html          # 訂票頁面
    │   │   │   │   │   └── confirmation.html     # 訂票確認頁面
    │   │   │   │   └── Admin/                  # 後台頁面模板
    │   │   │   │       ├── dashboard.html        # 後台儀表板
    │   │   │   │       ├── manage-flights.html   # 航班管理頁面
    │   │   │   │       ├── manage-bookings.html  # 訂票管理頁面
    │   │   │   │       └── manage-users.html     # 用戶管理頁面
    │   ├── test/                                 # 測試檔案
    │   └── README.md                             # 專案簡介
    ├── pom.xml                                   # Maven 配置檔案
    └── .gitignore                                # Git 忽略規則
