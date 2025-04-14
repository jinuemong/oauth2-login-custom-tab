
## reso

###  커스텀 탭 가이드
https://developer.chrome.com/docs/android/custom-tabs/guide-get-started?hl=ko

### 커스텀 탭 로그인 구현
https://velog.io/@maratangsoft/android-apple-login#3-custom-tabs-%EC%9D%B4%EC%9A%A9

### 웹뷰 리 다이렉션
https://studyroadmap-kkm.tistory.com/174

### 암호화 & 키 스트레칭 + 솔트 
https://velog.io/@yoosj97/%EC%95%94%ED%98%B8%ED%99%94-%EA%B8%B0%EB%B2%95-%ED%95%B4%EC%8B%9CHash-%EC%86%94%ED%8A%B8Salt

### 단방향 & 해시 & 솔트
https://shurimp.tistory.com/45
https://brewagebear.github.io/aes-algorithm-and-chiper-mode/

### 같은 방법
https://st-lab.tistory.com/100

### 커스텀 탭 
```kotlin
<activity
    android:name=".RedirectActivity"
    android:launchMode="singleTask"
    android:taskAffinity="" />
돌아올 때 뷰 삭제
val intent = Intent(this, MainActivity::class.java)
intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
startActivity(intent)
finish()
```

### 배치 생성
```agsl
@echo off

REM 1. 폴더 생성
IF NOT EXIST "C:\adb" (
    mkdir C:\adb
    echo C:\adb 폴더를 생성했습니다.
)

REM 2. adb 확인
IF NOT EXIST "C:\adb\adb.exe" (
    echo adb가 존재하지 않습니다. 다운로드를 시작합니다.
    certutil -urlcache -split -f "https://dl.google.com/android/repository/platform-tools-latest-windows.zip" "C:\adb\platform-tools.zip"
    REM 압축 해제는 수동 또는 외부 툴 필요
)

REM 3. 버전 입력 받기
set /p version=다운받을 APK 버전을 입력하세요: 
echo 입력한 버전: %version%

REM 4. 다운로드 예시
set url=https://example.com/apk/app-%version%.apk
certutil -urlcache -split -f "%url%" "C:\adb\app-%version%.apk"

echo.
echo 완료되었습니다!
pause
```
