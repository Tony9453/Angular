# Win10 IIS部署的安裝筆記


在 Windows Server 上安裝 .NET Core 裝載套件組合
安裝.NET 5.0 SDK

![image](https://user-images.githubusercontent.com/114964065/196099277-83c00533-93c9-4fdb-b651-f0fce75e19f8.png)
![image](https://user-images.githubusercontent.com/114964065/196099323-240465a0-4c77-45a8-adb7-22400a0d4b30.png)


安裝dotnet-hosting-5.0.8-win.exe

![image](https://user-images.githubusercontent.com/114964065/196099334-32c22a68-d77d-45ac-a720-f470ea8d8883.png)



在 IIS 管理員中建立 IIS 網站

![image](https://user-images.githubusercontent.com/114964065/196099358-925e4b8a-1ec3-4299-913b-45d3afc23fdd.png)



接著由 【程式集 > 開啟或關閉Windows功能 > Internet Information Services > World Wide Web服務 > 應用程式開發功能 > ASP】，記得要核選 Web管理工具 喔，按下 [確定] 後就會自動安裝。

![image](https://user-images.githubusercontent.com/114964065/196099377-f091f41a-5cd7-48db-9c13-a0c0f9e2323f.png)
![image](https://user-images.githubusercontent.com/114964065/196099390-6af4a580-77f1-41d4-826d-45c71ee6da4c.png)
![image](https://user-images.githubusercontent.com/114964065/196099399-17e30532-0d18-4f0f-823c-f86f2d21adc7.png)


IIS 的設定

![image](https://user-images.githubusercontent.com/114964065/196099405-af6b299e-8518-431f-bc15-975cf5aa47dc.png)


新增應用程式集區

![image](https://user-images.githubusercontent.com/114964065/196099414-5abc9d77-1b66-4324-9cae-2295470c0848.png)


新增網站

![image](https://user-images.githubusercontent.com/114964065/196099427-1234b497-449b-4db7-a59c-0e11a39fbc00.png)


