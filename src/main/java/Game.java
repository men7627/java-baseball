/*
 *@(#)Game.java           1.2 2019/03/27
 *Copyright (c) 2019 Hyogeon Kim.
 *Number Baseball Game, Java, Mungyeong, KOREA
 */

import java.util.Random;
import java.util.Scanner;

/**
 * 야구게임에 관련 된 클래스
 * @version               1.2 2019년 03월 27일
 * @author                김효건
 */
public class Game {
        /* 게임시작 / 게임종료
         * 게임화면 출력 / 세자리 숫자 생성
         * 세자리 숫자 입력 / 세자리 숫자 검사
         * 정답 화면 출력
         * 메소드 구현
         *  */

        /**게임시작 시 랜덤으로 지정 될 세자리 숫자*/
        private Number gameNumber;

        /**사용자가 입력한 세자리 숫자*/
        private Number playerNumber;

        /**Game 클래스 생성자
         * 메뉴 출력 및 에러 출력
         * 종료 선택 시까지 반복
         * */
        Game() {
                while (true) {
                        Menu.printMenu();

                        /*선택 번호를 저장할 변수*/
                        int select = Menu.selectMenu();

                        if (select == 1) {
                                startGame();
                        }
                        else if (select == 2) {
                                exitGame();
                        }
                        else
                                continue;
                }
        }

        /**게임 시작 함수 (전체적인 게임 진행)*/
        private void startGame() {
                makeRandomNumber();
                do {
                        printGame();
                        if(!inputNumber()) {
                                continue;
                        }
                        if (checkNumber()) {
                                printCorrect();
                                break;
                        }
                        printResult(countStrike(), countBall());
                } while (true);
        }

        /**게임 종료(프로그램 종료 함수)*/
        private void exitGame() {
                System.exit(0);
        }

        /**게임 화면 출력*/
        private void printGame() {
                System.out.print("숫자를 입력해주세요 : ");
        }

        /**컴퓨터의 숫자를 랜덤으로 지정*/
        private void makeRandomNumber() {
                int first = 0;
                int second = 0;
                int third = 0;

                Random rand = new Random();

                first = rand.nextInt(9) + 1;

                do {
                        second = rand.nextInt(9) + 1;
                } while (first == second);

                do {
                        third = rand.nextInt(9) + 1;
                } while (first == third || second == third);

                gameNumber = new Number(first, second, third);
        }

        /**세개의 숫자를 입력받음*/
        private boolean inputNumber() {
                String input;

                Scanner scan = new Scanner(System.in);
                try {
                        input = scan.nextLine();

                        if(input.length()>3) {
                                throw new StringIndexOutOfBoundsException();
                        }

                        if(input.charAt(0)<'1' || input.charAt(0)>'9'
                                ||input.charAt(1)<'1' || input.charAt(1)>'9'
                                ||input.charAt(2)<'1' || input.charAt(2)>'9') {
                                throw new inputNumberNaturalNumberException();
                        }

                        if(input.charAt(0) == input.charAt(1)
                                ||input.charAt(0) == input.charAt(2)
                                ||input.charAt(1) == input.charAt(2)) {
                                throw new inputNumberOverlapException();
                        }

                }catch(StringIndexOutOfBoundsException e){
                        System.err.println("입력 수 오류");
                        return false;
                }
                catch(inputNumberNaturalNumberException e){
                        System.err.println("입력 값 오류");
                        return false;
                }catch(inputNumberOverlapException e){
                        System.err.println("중복 입력 오류");
                        return false;
                }

                this.playerNumber = new Number(input.charAt(0) - '0',
                                                input.charAt(1) - '0',
                                                input.charAt(2) - '0');
                return true;
        }

        /**세자리 숫자를 입력 받을 때의 예외처리 - 자연수 이외의 값이 입력 된 경우*/
        public class inputNumberNaturalNumberException extends RuntimeException{
        }

        /**세자리 숫자를 입력 받을 때의 예외처리 - 중복 숫자 오류*/
        public class inputNumberOverlapException extends RuntimeException{
        }

        /**컴퓨터의 숫자와 사용자의 입력 숫자를 비교*/
        private boolean checkNumber() {
                return (playerNumber.getFirst() == gameNumber.getFirst()
                        && playerNumber.getSecond() == gameNumber.getSecond()
                        && playerNumber.getThird() == gameNumber.getThird());
        }
        /**
         * @return 같다면 true 다르다면 false 반환
         */

        /**정답 화면을 출력*/
        private void printCorrect() {
                System.out.println("세개의 숫자를 모두 맞히셨습니다!\n");
        }

        /**스트라이크 갯수를 카운팅*/
        private int countStrike() {
                int count = 0;

                if (playerNumber.getFirst() == gameNumber.getFirst()) {
                        count++;
                }
                if (playerNumber.getSecond() == gameNumber.getSecond()) {
                        count++;
                }
                if (playerNumber.getThird() == gameNumber.getThird()) {
                        count++;
                }
                return count;
        }
        /**
         * @return 스트라이크 수를 나타내는 count 변수 값을 반환
         */

        /**볼 갯수를 카운팅*/
        private int countBall() {
                int count = 0;
                if (playerNumber.getFirst() == gameNumber.getSecond()
                                || playerNumber.getFirst() == gameNumber.getThird()) {
                        count++;
                }
                if (playerNumber.getSecond() == gameNumber.getFirst()
                                || playerNumber.getSecond() == gameNumber.getThird()) {
                        count++;
                }
                if (playerNumber.getThird() == gameNumber.getFirst()
                                || playerNumber.getThird() == gameNumber.getSecond()) {
                        count++;
                }
                return count;
        }
        /**
         * @return 볼 수를 나타내는 count 변수 값을 반환
         */

        /**볼 갯수를 카운팅*/
        private void printResult(int strike, int ball) {
                String message = "";

                if (strike == 0 && ball == 0) {
                        message += "낫싱";
                }
                else {
                        if (strike != 0) {
                                message += strike + " 스트라이크  ";
                        }
                        if (ball != 0) {
                                message += ball + " 볼";
                        }
                }

                System.out.println(message);
        }
        /**
         * @param 스트라이크 수와 볼 수를 매개변수로 가짐
         */
}
