## 프리코스 1주차 미션
### 숫자 야구 게임
#### 구현 할 기능 목록
  |클래스 명|메소드 명|메소드 설명|수행 여부|
  |:-------|:-------|:-------|:-------:|
  |*Menu*|**printMenu()**|메뉴 화면 출력 (1.게임 시작, 2.게임 종료)|O|
  |*Menu*|**selectMenu()**|메뉴 입력 (1.게임 시작, 2.게임 종료)|O|
  |*Game*|**startGame()**|게임 시작|O|
  |*Game*|**exitGame()**|게임 종료|O|
  |*Game*|**printGame()**|게임 화면 출력|O|
  |*Game*|**makeRandomNumber()**|랜덤 3자리 숫자 생성|O|
  |*Game*|**inputNumber()**|세자리 숫자 입력|O|
  |*Game*|**checkNumber()**|숫자 검사|O|
  |*Game*|**printCorrect()**|정답 출력 화면|O|
  |*Game*|**countStrike()**|스타이크 수 셈|O|
  |*Game*|**countBall()**|볼 수 셈|O|
  |*Game*|**printResult()**|결과 출력|O|
  |*Number*|**getFirst()**|첫번째 숫자 읽어옴|O|
  |*Number*|**getSecond()**|두번째 숫자 읽어옴|O|
  |*Number*|**getThird()**|세번째 숫자 읽어옴|O|
  |*Number*|**setFirst()**|첫번째 숫자 지정|O|
  |*Number*|**setSecond()**|두번째 숫자 지정|O|
  |*Number*|**setThird()**|세번째 숫자 지정|O|
  
#### 예외처리 목록
+ 메뉴 선택, 1,2번 이 외의 값 입력 시 ex) -1, 'a', 3. "asd"
+ 세자리 숫자 입력, 1~9 이 외의 값 입력 시 ex) 0, 'a', "asdf", -1
+ 세자리 숫자 입력, 입력 수 불일치 시 ex) 15, 1534, 15234
+ 세자리 숫자 입력, 중복된 수 입력 시 ex) 155, 223, 111